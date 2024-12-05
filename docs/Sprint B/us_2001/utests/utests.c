#include <string.h>
#include <sys/stat.h>
#include <unistd.h>
#include "minunit.h"
#include "../program/us_2001.h"

static char * test_extract_application_number() {
    printf("\nExtract application number test\n");
    char *path = "/home/josemendes/Área de Trabalho/US_2002/input/1-candidate-data.txt";
    int expected = 1;
    int obtained = extract_application_number(path);

    if (obtained == expected) {
        printf("Success! Expected: %d, Obtained: %d\n", expected, obtained);
        return NULL; // Teste passou
    } else {
        printf("Failure! Expected: %d, Obtained: %d\n", expected, obtained);
        return "Test failed"; // Teste falhou
    }
}

static char *test_extract_job_reference() {
    printf("\nExtract job reference test\n");
    char *path = "/home/josemendes/Área de Trabalho/us_2001/files/1-candidate-data.txt";
    char *expected = "IBM-000123";

    // Criar um arquivo e escrever o conteúdo esperado na primeira linha
    FILE *file = fopen(path, "w");
    if (file == NULL) {
        perror("Erro ao criar arquivo fictício");
        return "Test failed";
    }
    fprintf(file, "%s\n", expected); // Escrever o conteúdo esperado na primeira linha
    fclose(file);

    char *obtained = extract_job_reference(path);

    if (obtained == NULL) {
        printf("Failure! Obtained: NULL\n");
        return "Test failed"; // Teste falhou
    }

    if (strcmp(obtained, expected) == 0) {
        printf("Success! Expected: %s, Obtained: %s\n", expected, obtained);
        return NULL; // Teste passou
    } else {
        printf("Failure! Expected: %s, Obtained: %s\n", expected, obtained);
        return "Test failed"; // Teste falhou
    }
}


static char *test_mkdir_p() {
    printf("\nMkdir_p test\n");
    const char *test_path = "/tmp/test_directory/subdirectory";
    int result = mkdir_p(test_path);

    // Verificar se o diretório foi criado corretamente
    if (result == 0) {
        // Verificar se o diretório existe
        struct stat st;
        if (stat(test_path, &st) == 0 && S_ISDIR(st.st_mode)) {
            printf("Success! Directory %s created successfully.\n", test_path);
            // Remover o diretório criado após o teste
            rmdir(test_path);
            return NULL; // Teste passou
        } else {
            printf("Failure! Directory %s not created.\n", test_path);
            return "Test failed"; // Teste falhou
        }
    } else {
        printf("Failure! mkdir_p failed to create directory %s.\n", test_path);
        return "Test failed"; // Teste falhou
    }
}

static char * all_tests() {
    mu_run_test(test_extract_application_number);
    mu_run_test(test_extract_job_reference);
    mu_run_test(test_mkdir_p);
    return 0;
}

int main(int argc, char **argv) {
    char *result = all_tests();
    if (result != 0) {
        printf("%s\n", result);
    }
    else {
        printf("\nALL TESTS PASSED\n");
    }
    printf("Tests run: %d\n", tests_run);

    return result != 0;
}
