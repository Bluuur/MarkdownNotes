//
// Created by ZidongZh on 2022/9/23.
//

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main() {

    for (int dimension = 1; dimension <= 100 * 100; dimension *= 10) {

        long tic = clock();

        // Initialize array
        double array1[dimension];
        double array2[dimension];

        // Get data
        for (int i = 0; i < dimension; ++i) {
            array1[i]=rand();
        }
        for (int i = 0; i < dimension; ++i) {
            array2[i]=rand();
        }

        // Compute & Output
        double result = 0;
        for (int i = 0; i < dimension; ++i) {
            result += (array1[i] * array2[i]);
        }

        long tak = clock();

        printf("n = %d, time cost: %d ms\n", dimension, tak - tic);
    }
    return 0;
}
