//
// Created by ZidongZh on 2022/9/23.
//

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main() {

    for (int dimension = 10; dimension <= 100; dimension += 10) {
        int tic = clock();

        // Initialize array
        double matrix1[dimension][dimension];
        double matrix2[dimension][dimension];
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                matrix1[i][j] = rand();
            }
        }
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                matrix2[i][j] = rand();
            }
        }

        // Compute
        double result = 0;
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                result += (matrix1[i][j] * matrix2[i][j]);
            }
        }

        int tak = clock();
        printf("n = %d, time cost: %d ms\n", dimension, (tak - tic));
    }
    return 0;
}
