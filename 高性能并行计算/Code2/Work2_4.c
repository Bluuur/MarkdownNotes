//
// Created by ZidongZh on 2022/9/26.
//

#include<stdio.h>
#include<stdlib.h>
#include <ntdef.h>
#include <profileapi.h>

void BubbleSort(int array[], int length) {
    int i, j, temp;
    for (i = 0; i < length - 1; i++) {
        for (j = 0; j < length - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;
            }
        }
    }
}

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

        BubbleSort(array, k);

        // tack
        QueryPerformanceCounter(&time_over);

        // Get time in us
        run_time = 1000000 * (time_over.QuadPart - time_start.QuadPart) / dqFreq;

        printf("\ndata num:%d, run_time:%fus", k, run_time);

    }
    return 0;

}
