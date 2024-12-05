#include "us_2001b.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/inotify.h>
#include <string.h>
#include <sys/stat.h>
#include <signal.h>
#include <libgen.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <semaphore.h>
#include <dirent.h>


#define NUM_WORKERS 5
#define EXTENDED_PATH_LENGTH 2048
#define INPUT_DIRECTORY "/home/josemendes/Desktop/us_2001b/input"
#define OUTPUT_DIRECTORY "/home/josemendes/Desktop/us_2001b/output"
#define MAX_FILES 1024
#define SHM_NAME "/shm_us2001b"
#define SEM_NAME "/sem_us2001b"
#define FILE_QUEUE "/queue_us2001b"

volatile sig_atomic_t running = 1;
volatile sig_atomic_t sigusr1_received = 0;

typedef struct {
    char file_paths[MAX_FILES][EXTENDED_PATH_LENGTH];
    int file_count;
    int processed_count;
    char final_directory_paths[MAX_FILES][EXTENDED_PATH_LENGTH];
} shared_data_t;

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

    // Remover o caracter de nova linha do final da string (caso exista)
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
            size_t len = (size_t)(dash - filename);
            char *result = malloc(len + 1); // Alocar memória para o número da aplicação
            if (result != NULL) {
                strncpy(result, filename, len);
                result[len] = '\0';
                int number = atoi(result);
                free(result);
                return number;
            } else {
                printf("Erro ao alocar memória\n");
                return -1;
            }
        } else {
            printf("Nenhum '-' encontrado no nome do arquivo\n");
            return -1;
        }
    } else {
        printf("Nenhum '/' encontrado no caminho\n");
        return -1;
    }
}

int mkdir_p(const char *path) {
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

void copy_file(const char *source_path, const char *destination_path) {
    char buffer[1024];
    size_t bytes;

    FILE *source = fopen(source_path, "rb");
    if (source == NULL) {
        perror("Erro ao abrir o arquivo fonte");
        return;
    }

    FILE *destination = fopen(destination_path, "wb");
    if (destination == NULL) {
        perror("Erro ao abrir o arquivo destino");
        fclose(source);
        return;
    }

    while ((bytes = fread(buffer, 1, sizeof(buffer), source)) > 0) {
        fwrite(buffer, 1, bytes, destination);
    }

    fclose(source);
    fclose(destination);
}

void monitor_directory(const char *directory, shared_data_t *shm, sem_t *sem_excl) {
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

    while (running) {
        char buffer[1024];
        ssize_t num_bytes = read(fd, buffer, sizeof(buffer));
        if (num_bytes == -1) {
            if (errno == EINTR) {
                printf("\n\n O Monitoramento do diretório parou devido à recepção de SIGINT\n");
                break;
            } else {
                perror("Erro ao ler do diretório");
                exit(EXIT_FAILURE);
            }
        }

        for (size_t i = 0; i < (size_t)num_bytes;) {
            struct inotify_event *event = (struct inotify_event *) &buffer[i];
            if (event->len) {
                if (event->mask & IN_CREATE) {
                    sem_wait(sem_excl);
                    if (shm->file_count < MAX_FILES) {
                        snprintf(shm->file_paths[shm->file_count], EXTENDED_PATH_LENGTH, "%s/%s", directory, event->name);
                        shm->file_count++;
                    }
                    sem_post(sem_excl);
                    kill(getppid(), SIGUSR1);
                }
            }
            i += (size_t)(sizeof(struct inotify_event) + event->len);
        }
    }

    inotify_rm_watch(fd, wd);
    close(fd);
}

void generate_report(const char *outputDir) {
    char reportFilePath[EXTENDED_PATH_LENGTH];
    if (snprintf(reportFilePath, sizeof(reportFilePath), "%s/report.txt", outputDir) >= (int)sizeof(reportFilePath)) {
        fprintf(stderr, "Erro: Caminho do relatório é muito longo.\n");
        return;
    }

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
                char jobRefPath[EXTENDED_PATH_LENGTH];
                if (snprintf(jobRefPath, sizeof(jobRefPath), "%s/%s", outputDir, jobReference->d_name) >= (int)sizeof(jobRefPath)) {
                    fprintf(stderr, "Erro: Caminho de referência de trabalho é muito longo.\n");
                    continue;
                }
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
                            char idPath[EXTENDED_PATH_LENGTH];
                            if (snprintf(idPath, sizeof(idPath), "%s/%s", jobRefPath, candidate->d_name) >= (int)sizeof(idPath)) {
                                fprintf(stderr, "Erro: Caminho do ID é muito longo.\n");
                                continue;
                            }
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
    if (signal == SIGINT) {
        running = 0;
    } else if (signal == SIGUSR1) {
        sigusr1_received = 1;
    }
}

void setup_signal_handlers() {
    struct sigaction sa;
    memset(&sa, 0, sizeof(struct sigaction));
    sa.sa_handler = handle_signal;

    if (sigaction(SIGINT, &sa, NULL) == -1) {
        perror("Erro ao configurar SIGINT");
        exit(EXIT_FAILURE);
    }

    if (sigaction(SIGUSR1, &sa, NULL) == -1) {
        perror("Erro ao configurar SIGUSR1");
        exit(EXIT_FAILURE);
    }
}

void process_file(shared_data_t *shm, sem_t *sem_excl, sem_t *sem_queue) {
    while (running) {
        sem_wait(sem_queue);
        sem_wait(sem_excl);

        int index = shm->processed_count;
        if (shm->processed_count < shm->file_count) {
            char final_directory_path[512];
            //printf("Worker %d: Novo arquivo recebido: %s\n", getpid(), shm->file_paths[index]);

            if (strstr(shm->file_paths[index], "candidate-data") != NULL) {
                char *jobreference = extract_job_reference(shm->file_paths[index]);
                int application_number = extract_application_number(shm->file_paths[index]);

                snprintf(final_directory_path, sizeof(final_directory_path), "%s/%s/%d", OUTPUT_DIRECTORY, jobreference, application_number);
                strcpy(shm->final_directory_paths[application_number], final_directory_path);
                mkdir_p(final_directory_path);

            } else {

                int application_number = extract_application_number(shm->file_paths[index]);
                strcpy(final_directory_path, shm->final_directory_paths[application_number]);

            }

            if (final_directory_path[0] != '\0') {
                char destination_path[EXTENDED_PATH_LENGTH];
                snprintf(destination_path, sizeof(destination_path), "%s/%s", final_directory_path, strrchr(shm->file_paths[index], '/') + 1);
                copy_file(shm->file_paths[index], destination_path);
            }
            shm->processed_count++;
        }

        sem_post(sem_excl);
    }
    exit(0);
}

#ifndef TESTING
int main() {
    mkdir(INPUT_DIRECTORY, 0777);
    mkdir(OUTPUT_DIRECTORY, 0777);

    int fd;
    shared_data_t *shm;
    sem_t *sem_excl, *sem_queue;

    if ((fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, S_IRUSR | S_IWUSR)) == -1) {
        perror("shm_open");
        exit(1);
    }

    if (ftruncate(fd, sizeof(shared_data_t)) == -1) {
        perror("ftruncate");
        exit(2);
    }

    if ((shm = (shared_data_t *)mmap(NULL, sizeof(shared_data_t), PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0)) == MAP_FAILED) {
        perror("mmap");
        exit(3);
    }

    if ((sem_excl = sem_open(SEM_NAME, O_CREAT, 0644, 1)) == SEM_FAILED) {
        perror("sem_open");
        exit(4);
    }

    if ((sem_queue = sem_open(FILE_QUEUE, O_CREAT, 0644, 0)) == SEM_FAILED) {
        perror("sem_open");
        exit(5);
    }

    shm->file_count = 0;
    shm->processed_count = 0;

    setup_signal_handlers();

    pid_t pid = fork();
    if (pid == -1) {
        perror("Erro ao criar processo filho para vigiar o diretório");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Processo filho "Monitor"
        monitor_directory(INPUT_DIRECTORY, shm, sem_excl);
        exit(0);
    } else {
        // Processo pai
        for (int i = 0; i < NUM_WORKERS; i++) {
            pid_t worker_pid = fork();
            if (worker_pid == -1) {
                perror("Erro ao criar processo filho");
                exit(EXIT_FAILURE);
            } else if (worker_pid == 0) {
                // Processo filho "Worker"
                process_file(shm, sem_excl, sem_queue);
            }
        }

        int last_file_count = 0;
        while (running) {
            pause();
            if (sigusr1_received) {
                sigusr1_received = 0;
                sem_wait(sem_excl);
                for (int i = last_file_count; i < shm->file_count; i++) {
                    sem_post(sem_queue);
                }
                last_file_count = shm->file_count;
                sem_post(sem_excl);
            }
        }
        generate_report(OUTPUT_DIRECTORY);

        kill(pid, SIGINT);
        wait(NULL);

        for (int i = 0; i < NUM_WORKERS; i++) {
            kill(0, SIGINT);
            wait(NULL);
        }
    }

    munmap(shm, sizeof(shared_data_t));
    close(fd);
    shm_unlink(SHM_NAME);
    sem_close(sem_excl);
    sem_close(sem_queue);
    sem_unlink(SEM_NAME);
    sem_unlink(FILE_QUEUE);

    return 0;
}
#endif