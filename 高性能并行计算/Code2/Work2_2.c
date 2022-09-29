//
// Created by ZidongZh on 2022/9/26.
//

#include <stdio.h>
#include <stdlib.h>
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

    for (int k = 0; k < 1000; k += 50) {

        double array[k];

        // Mock data
        for (int l = 0; l < k; ++l) {
            array[l] = rand();
        }

        //  tick
        QueryPerformanceCounter(&time_start);


        // Initialize array
        double array1[k];
        double array2[k];

        // Mock data
        for (int i = 0; i < k; ++i) {
            array1[i]=rand();
        }
        for (int i = 0; i < k; ++i) {
            array2[i]=rand();
        }

        // Compute & Output
        double result = 0;
        for (int i = 0; i < k; ++i) {
            result += (array1[i] * array2[i]);
        }

        // tack
        QueryPerformanceCounter(&time_over);

        // Get time in us
        run_time = 1000000 * (time_over.QuadPart - time_start.QuadPart) / dqFreq;

        printf("\ndata num:%d, run_time:%fus", k, run_time);

    }

    return 0;
}
