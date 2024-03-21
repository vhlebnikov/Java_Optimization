#include <stdio.h>
#include <stdlib.h>
#include <time.h>

long matrix[1024][1024];
long result[1024][1024];

int main() {
    int dimensions[2] = {128, 1024};
    printf("Test from C code:\n");

    for (int l = 0; l < 2; l++) {

        // malloc allocating (slower)

//        int **matrix = (int **) malloc(sizeof(int *) * dimensions[l]);
//        int **result = (int **) malloc(sizeof(int *) * dimensions[l]);
//        for (int i = 0; i < dimensions[l]; i++) {
//            matrix[i] = (int *) malloc(sizeof(int) * dimensions[l]);
//            result[i] = (int *) malloc(sizeof(int) * dimensions[l]);
//            for (int j = 0; j < dimensions[l]; j++) {
//                matrix[i][j] = i * dimensions[l] + j + 1;
//            }
//        }

        // using global arrays

        for (int i = 0; i < dimensions[l]; i++) {
            for (int j = 0; j < dimensions[l]; j++) {
                matrix[i][j] = i * dimensions[l] + j + 1;
            }
        }

        // calculating
        clock_t start_time = clock();

        for (int i = 0; i < dimensions[l]; i++) {
            for (int j = 0; j < dimensions[l]; j++) {
                result[i][j] = 0;
                for (int k = 0; k < dimensions[l]; k++) {
                    result[i][j] += matrix[i][k] * matrix[k][j];
                }
            }
        }

        double elapsed_time = (double)(clock() - start_time) / CLOCKS_PER_SEC;
        printf("Result for %d x %d matrix multiplication: %f seconds\n", dimensions[l], dimensions[l], elapsed_time);

        // free memory

//        for (int i = 0; i < dimensions[l]; i++) {
//            free(matrix[i]);
//            free(result[i]);
//        }
//        free(matrix);
//        free(result);
    }
}