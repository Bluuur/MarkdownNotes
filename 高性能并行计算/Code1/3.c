//
// Created by ZidongZh on 2022/9/23.
//

#include <stdio.h>

int main() {
    int dimension;

    // Get the dimension of array
    printf("Enter the dimension of the matrix:");
    scanf("%d", &dimension);

    // Initialize array
    double matrix1[dimension][dimension];
    double matrix2[dimension][dimension];

    //
    for (int i = 0; i < dimension; ++i) {
        for (int j = 0; j < dimension; ++j) {
            printf("Enter the number of matrix1 at row %d, column %d:", i + 1, j + 1);
            scanf("%lf", &matrix1[i][j]);
        }
    }
    printf("------------------------------");
    for (int i = 0; i < dimension; ++i) {
        for (int j = 0; j < dimension; ++j) {
            printf("Enter the number of matrix2 at row %d, column %d:", i + 1, j + 1);
            scanf("%lf", &matrix2[i][j]);
        }
    }

    printf("\nMatrix 1:\n");
    for (int i = 0; i < dimension; ++i) {
        for (int j = 0; j < dimension; ++j) {
            printf("%lf ", matrix1[i][j]);
        }
        printf("\n");
    }
    printf("\nMatrix 2:\n");
    for (int i = 0; i < dimension; ++i) {
        for (int j = 0; j < dimension; ++j) {
            printf("%lf ", matrix2[i][j]);
        }
        printf("\n");
    }

    // Compute
    double result = 0;
    for (int i = 0; i < dimension; ++i) {
        for (int j = 0; j < dimension; ++j) {
            result += (matrix1[i][j] * matrix2[i][j]);
        }
    }

    printf("\nDot product of the two vectors is %lf", result);
    return 0;
}
