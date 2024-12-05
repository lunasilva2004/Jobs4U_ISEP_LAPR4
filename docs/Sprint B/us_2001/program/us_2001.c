#include "us_2001.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/inotify.h>
#include <string.h>
#include <sys/stat.h>
#include <signal.h>
#include <libgen.h>
#include <errno.h>
#include <dirent.h>

#define MAX_PATH_LENGTH 256
#define INPUT_DIRECTORY "/home/josemendes/Área de Trabalho/us_2001/input"
#define OUTPUT_DIRECTORY "/home/josemendes/Área de Trabalho/us_2001/output"
#define NUM_WORKERS 5
#define TIME_INTERVAL 10

volatile sig_atomic_t running = 1;

int pipe_fd[2]; // Pipe para comunicação entre o processo pai e o processo filho que monitora o diretório
int worker_pipe_fds[NUM_WORKERS][2]; // Um pipe para cada worker


char *extract_job_reference(const char *file_path) {
    FILE *file = fopen(file_path, "r");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo");
        return NULL;
    }

    static char buffer[1024];
    if (fgets(buffer, sizeof(buffer), file) == NULL) {
        perror("Erro ao ler a primeira linha do arquivo");
        fclose(file);
        return NULL;
    }

    // Remover o caractere de nova linha do final da string, se houver
    size_t len = strlen(buffer);
    if (len > 0 && buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }

    fclose(file);
    return buffer;
}

int extract_application_number(const char *path) {
    char *filename = strrchr(path, '/');
    if (filename != NULL) {
        filename++; // Move past the '/'
        char *dash = strchr(filename, '-');
        if (dash != NULL) {
            size_t len = dash - filename;
            char *result = malloc(len + 1); // Alocar memória dinamicamente para o número da aplicação
            if (result != NULL) {
                strncpy(result, filename, len);
                result[len] = '\0';
                int number = atoi(result); // Converter a string para um número inteiro
                free(result); // Liberar a memória alocada
                return number;
            } else {
                printf("Erro ao alocar memória\n");
                return -1; // Retornar um valor inválido para indicar um erro
            }
        } else {
            printf("Nenhum '-' encontrado no nome do arquivo\n");
            return -1; // Retornar um valor inválido para indicar um erro
        }
    } else {
        printf("Nenhum '/' encontrado no caminho\n");
        return -1; // Retornar um valor inválido para indicar um erro
    }
}

int mkdir_p(const char *path) {
    // Faz uma cópia do caminho porque dirname pode modificar o argumento
    char *path_copy = strdup(path);
    char *dir = dirname(path_copy);

    // Se o diretório pai não é o diretório atual ou a raiz
    if (strcmp(dir, ".") != 0 && strcmp(dir, "/") != 0) {
        // Cria o diretório pai
        int status = mkdir_p(dir);
        if (status == -1) {
            free(path_copy);
            return -1;
        }
    }
    // Cria o diretório especificado no caminho
    int status = mkdir(path, 0700);

    free(path_copy);

    // Se mkdir falhou e o erro não é que o diretório já existe
    if (status == -1 && errno != EEXIST) {
        return -1;
    }

    return 0;
}

void process_file(int worker_id) {
    char buffer[1024 * 512];
    int num_bytes = read(worker_pipe_fds[worker_id][0], buffer, sizeof(buffer));
    if (num_bytes == -1) {
        perror("Erro ao ler do pipe");
        exit(EXIT_FAILURE);
    }
    char buffer_copy[1024 * 512];
    memcpy(buffer_copy, buffer, sizeof(buffer));


    char final_directory_path[512];
    char *file_path = strtok(buffer, "\n");
    while (file_path != NULL) {
        if (strstr(file_path, "candidate-data") != NULL) {
            char *jobreference = extract_job_reference(file_path);
            int application_number = extract_application_number(file_path);
            snprintf(final_directory_path, sizeof(final_directory_path), "%s/%s/%d", OUTPUT_DIRECTORY, jobreference,
                     application_number);
            break;
        }
        file_path = strtok(NULL, "\n");
    }
    // Novo loop while para copiar os arquivos para o diretório final
    file_path = strtok(buffer_copy, "\n");
    while (file_path != NULL) {

        if (mkdir_p(final_directory_path) == -1) {
            perror("Erro ao criar o diretório");
            return;
        }

        // Copy the file to the new directory
        char command[512];
        snprintf(command, sizeof(command), "cp \"%s\" \"%s\"", file_path, final_directory_path);
        system(command);

        file_path = strtok(NULL, "\n");

    }

    sleep(2);
    kill(getppid(), SIGUSR2); // Envia um sinal ao processo pai quando termina de processar um arquivo
}

void distribute_file_to_worker() {
    char buffer[1024 * 512];
    int num_bytes = read(pipe_fd[0], buffer, sizeof(buffer));
    if (num_bytes == -1) {
        perror("Erro ao ler do pipe");
        exit(EXIT_FAILURE);
    }

    char *file_paths[NUM_WORKERS][1024]; // Array para armazenar os caminhos dos arquivos para cada worker
    int file_counts[NUM_WORKERS] = {0}; // Contadores para o número de arquivos para cada worker

    char *file_path = strtok(buffer, "\n");
    while (file_path != NULL) {
        // Extrair o primeiro caractere do nome do arquivo
        char *filename = strrchr(file_path, '/');
        int first_digit = -1;
        if (filename != NULL) {
            filename++; // Move past the '/'
            if (*filename >= '0' && *filename <= '9') {
                first_digit = *filename - '0';
            }
        }

        int worker_id;
        if (first_digit != -1) {
            // Se o nome do arquivo começa com um dígito, use-o para determinar o worker_id
            worker_id = first_digit % NUM_WORKERS;
        } else {
            // Se o nome do arquivo não começa com um dígito, use o próximo worker disponível
            static int next_worker = 0;
            worker_id = next_worker % NUM_WORKERS;
            next_worker++;
        }

        // Adicionar o caminho do arquivo ao array para o worker correspondente
        file_paths[worker_id][file_counts[worker_id]] = strdup(file_path);
        file_counts[worker_id]++;

        file_path = strtok(NULL, "\n");
    }

    // Enviar todos os caminhos de arquivos para cada worker de uma vez
    for (int i = 0; i < NUM_WORKERS; i++) {
        if (file_counts[i] > 0) {
            close(worker_pipe_fds[i][0]);
            char all_file_paths[1024 * 512] = "";
            for (int j = 0; j < file_counts[i]; j++) {
                strcat(all_file_paths, file_paths[i][j]);
                strcat(all_file_paths, "\n");
                free(file_paths[i][j]); // Liberar a memória alocada para o caminho do arquivo
            }
            // Enviar a string com todos os caminhos de arquivos para o worker
            write(worker_pipe_fds[i][1], all_file_paths, strlen(all_file_paths) + 1);
            //printf("Arquivos enviados para o worker %d\n", i);
        }
    }
}

void monitor_directory(const char *directory) {
    int fd = inotify_init();
    if (fd == -1) {
        perror("inotify_init");
        exit(EXIT_FAILURE);
    }

    int wd = inotify_add_watch(fd, directory, IN_CREATE);
    printf("A monitorização do diretório %s começou! \n", directory);
    fflush(stdout);
    if (wd == -1) {
        perror("inotify_add_watch");
        exit(EXIT_FAILURE);
    }

    char *file_paths[1024]; // Array para armazenar os caminhos dos arquivos
    int file_count = 0; // Contador para o número de arquivos

    while (1) {
        char buffer[1024];
        int num_bytes = read(fd, buffer, sizeof(buffer));
        if (num_bytes == -1) {
            perror("read");
            exit(EXIT_FAILURE);
        }

        for (int i = 0; i < num_bytes;) {
            struct inotify_event *event = (struct inotify_event *) &buffer[i];
            if (event->len) {
                if (event->mask & IN_CREATE) {
                    char *file_path = malloc(512);
                    int path_len = snprintf(file_path, 512, "%s/%s", directory, event->name);
                    if (path_len >= 512) {
                        fprintf(stderr, "File path is too long: %s\n", file_path);
                        exit(EXIT_FAILURE);
                    }
                    file_paths[file_count] = file_path; // Adicionar o caminho do arquivo ao array
                    file_count++; // Incrementar o contador de arquivos
                }
            }
            i += sizeof(struct inotify_event) + event->len;
        }

        // Concatenar todos os caminhos de arquivos em uma única string
        char all_file_paths[1024 * 512] = "";
        for (int i = 0; i < file_count; i++) {
            strcat(all_file_paths, file_paths[i]);
            strcat(all_file_paths, "\n");
            free(file_paths[i]); // Liberar a memória alocada para o caminho do arquivo
        }
        file_count = 0; // Resetar o contador de arquivos

        // Enviar a string com todos os caminhos de arquivos para o processo pai
        close(pipe_fd[0]);
        write(pipe_fd[1], all_file_paths, strlen(all_file_paths) + 1);

        kill(getppid(), SIGUSR1);
        sleep(TIME_INTERVAL);
    }

    inotify_rm_watch(fd, wd);
    close(fd);
}

void createPipes() {
    if (pipe(pipe_fd) == -1) {
        perror("Erro ao criar pipe");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < NUM_WORKERS; i++) {
        if (pipe(worker_pipe_fds[i]) == -1) {
            perror("Erro ao criar pipe");
            exit(EXIT_FAILURE);
        }
    }
}

void generate_report(const char *outputDir) {
    char reportFilePath[MAX_PATH_LENGTH];
    snprintf(reportFilePath, sizeof(reportFilePath), "%s/report.txt", outputDir);

    FILE *reportFile = fopen(reportFilePath, "w");
    if (reportFile == NULL) {
        perror("Erro ao criar o arquivo de relatório");
        return;
    }

    // Iterar através do diretório de saída
    DIR *dir;
    struct dirent *jobReference;
    if ((dir = opendir(outputDir)) != NULL) {
        while ((jobReference = readdir(dir)) != NULL) {
            if (jobReference->d_type == DT_DIR) {
                // Pular "." e ".."
                if (strcmp(jobReference->d_name, ".") == 0 || strcmp(jobReference->d_name, "..") == 0) {
                    continue;
                }
                // Iterar através dos diretórios de JOBREFERENCE
                char jobRefPath[MAX_PATH_LENGTH];
                snprintf(jobRefPath, sizeof(jobRefPath), "%s/%s", outputDir, jobReference->d_name);
                DIR *jobRefDir;
                struct dirent *candidate;
                if ((jobRefDir = opendir(jobRefPath)) != NULL) {
                    while ((candidate = readdir(jobRefDir)) != NULL) {
                        if (candidate->d_type == DT_DIR) {
                            // Pular "." e ".."
                            if (strcmp(candidate->d_name, ".") == 0 || strcmp(candidate->d_name, "..") == 0) {
                                continue;
                            }
                            // Iterar através dos diretórios de ID
                            char idPath[MAX_PATH_LENGTH];
                            snprintf(idPath, sizeof(idPath), "%s/%s", jobRefPath, candidate->d_name);
                            DIR *idDir;
                            struct dirent *file;
                            if ((idDir = opendir(idPath)) != NULL) {
                                while ((file = readdir(idDir)) != NULL) {
                                    if (file->d_type == DT_REG) {
                                        fprintf(reportFile, "Job Reference: %s, Candidate: %s, File: %s\n",
                                                jobReference->d_name, candidate->d_name, file->d_name);
                                    }
                                }
                                closedir(idDir);
                            } else {
                                perror("Erro ao abrir diretório de ID");
                            }
                            // Adicionar uma nova linha após cada candidato
                            fprintf(reportFile, "\n");
                        }
                    }
                    closedir(jobRefDir);
                } else {
                    perror("Erro ao abrir diretório de JOBREFERENCE");
                }
                // Adicionar uma nova linha após cada JOBREFERENCE
                fprintf(reportFile, "\n");
            }
        }
        closedir(dir);
    } else {
        perror("Erro ao abrir diretório de saída");
    }
    fclose(reportFile);
}

void handle_signal(int signal) {
    if (signal == SIGUSR1) {
        //printf("Recebido sinal de novos arquivos.\n");
        distribute_file_to_worker();
    } else if (signal == SIGUSR2) {
        //printf("Worker terminou de processar arquivos.\n");
        generate_report(OUTPUT_DIRECTORY);
        // O processo pai pode agora enviar o próximo arquivo
    } else if (signal == SIGINT) {
        running = 0;
    }
}

#ifndef TESTING
int main() {
    mkdir(INPUT_DIRECTORY, 0777);
    mkdir(OUTPUT_DIRECTORY, 0777);

    signal(SIGUSR1, handle_signal);
    signal(SIGUSR2, handle_signal);
    signal(SIGINT, handle_signal);

    createPipes();

    pid_t continues_pid = fork();
    if (continues_pid == -1) {
        perror("Erro ao criar processo filho para vigiar o diretório");
        exit(EXIT_FAILURE);
    } else if (continues_pid == 0) {
        //processo filho
        //printf("PID do processo filho que vigia: %d\n", getpid());
        monitor_directory(INPUT_DIRECTORY);
    } else {
        //Processo pai
        //printf("PID do processo pai: %d\n", getpid());

        for (int i = 0; i < NUM_WORKERS; i++) {
            //criaçao dos workers
            pid_t pid = fork();
            if (pid == -1) {
                perror("Erro ao criar processo filho");
                exit(EXIT_FAILURE);
            } else if (pid == 0) {
                //printf("PID do processo filho que processa: %d\n", getpid());
                while (1) {
                    // Verificar se há dados disponíveis para leitura no pipe do worker
                    fd_set read_fds;
                    FD_ZERO(&read_fds);
                    FD_SET(worker_pipe_fds[i][0], &read_fds);
                    // struct timeval timeout = {0, 0}; // Não bloquear na chamada para select
                    int num_ready = select(worker_pipe_fds[i][0] + 1, &read_fds, NULL, NULL,NULL);
                    if (num_ready == -1) {
                        // Verificar se o erro foi devido a um sinal de interrupção
                        if (errno == EINTR) {
                            continue;
                        } else {
                            // Caso contrário, imprimir o erro e sair do program
                            perror("Erro ao chamar o select");
                            exit(EXIT_FAILURE);
                        }
                    } else if (num_ready > 0) {
                        // Há dados disponíveis para leitura no pipe do worker
                        //printf("Processo filho %d recebeu ficheiros!\n", getpid());
                        process_file(i);
                    }
                }
            }
        }
        while (running) {
            pause();
        }
    }
    return 0;
}
#endif