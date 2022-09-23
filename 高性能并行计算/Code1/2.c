//
// Created by ZidongZh on 2022/9/23.
//

#include <stdio.h>

int main() {
    int dimension;

    // Get the dimension of array
    printf("Enter the dimension of the two vectors:");
    scanf("%d", &dimension);

    // Initialize array
    double array1[dimension];
    double array2[dimension];

    // Get data
    for (int i = 0; i < dimension; ++i) {
        printf("Enter data (vector1, %d of %d):", i + 1, dimension);
        scanf("%lf", &array1[i]);
    }
    printf("--------------------------\n");
    for (int i = 0; i < dimension; ++i) {
        printf("Enter data (vector2, %d of %d):", i + 1, dimension);
        scanf("%lf", &array2[i]);
    }

    // Display
    printf("\nVector 1:\n");
    for (int i = 0; i < dimension; ++i) {
        printf("%lf \n", array1[i]);
    }
    printf("\nVector 2:\n");
    for (int i = 0; i < dimension; ++i) {
        printf("%lf\n", array2[i]);
    }

    // Compute & Output
    double result = 0;
    for (int i = 0; i < dimension; ++i) {
        result += (array1[i] * array2[i]);
    }

    printf("\nDot product of the two vectors is %lf", result);

    return 0;
}
