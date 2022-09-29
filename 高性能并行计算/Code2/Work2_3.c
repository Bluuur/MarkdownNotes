//
// Created by ZidongZh on 2022/9/26.
//

#include <stdio.h>
#include <stdlib.h>
#include <ntdef.h>
#include <profileapi.h>

int main() {

    double run_time;
    union _LARGE_INTEGER time_start;
    union _LARGE_INTEGER time_over;
    double dqFreq;
    LARGE_INTEGER f;

    QueryPerformanceFrequency(&f);
    dqFreq = (double) f.QuadPart;

#pragma omp parallel for

    for (int k = 0; k < 100; k += 5) {

        double array[k];

        // Mock data
        for (int l = 0; l < k; ++l) {
            array[l] = rand();
        }

        //  tick
        QueryPerformanceCounter(&time_start);

        // Initialize array
        double matrix1[k][k];
        double matrix2[k][k];
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                matrix1[i][j] = rand();
            }
        }
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                matrix2[i][j] = rand();
            }
        }

        // Compute
        double result = 0;
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                result += (matrix1[i][j] * matrix2[i][j]);
            }
        }

        // tack
        QueryPerformanceCounter(&time_over);

        // Get time in us
        run_time = 1000000 * (time_over.QuadPart - time_start.QuadPart) / dqFreq;

        printf("\ndata num:%d, run_time:%fus", k, run_time);

    }
    return 0;
}
