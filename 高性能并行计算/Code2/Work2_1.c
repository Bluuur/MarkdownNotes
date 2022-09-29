//
// Created by ZidongZh on 2022/9/26.
//

#include "stdio.h"
#include "math.h"
#include <ntdef.h>
#include <profileapi.h>


double getMax(double array[], int len) {
    double max = array[0];
    int i;
    for (i = 0; i < len; ++i) {
        if (array[i] > max) {
            max = array[i];
        }
    }
    return max;
}

double getMin(double array[], int len) {
    double min = array[0];
    int i;
    for (i = 0; i < len; ++i) {
        if (array[i] <= min) {
            min = array[i];
        }
    }
    return min;
}

double getMean(double array[], int len) {
    double sum = 0.0;
    double mean = 0.0;
    int i;
    for (i = 0; i < len; ++i) {
        sum += array[i];
    }
    mean = sum / len;
    return mean;
}

double getSD(double array[], int len) {
    double mean = getMean(array, len);
    double SS = 0.0;
    int i;
    for (i = 0; i < len; ++i) {
        SS += pow(array[i] - mean, 2);
    }
    double SD = sqrt(SS / (len - 1));
    return SD;
}

int main() {
    // Get the length of data
    int i;
    int j;

    double run_time;
    union _LARGE_INTEGER time_start;
    union _LARGE_INTEGER time_over;
    double dqFreq;
    LARGE_INTEGER f;

    QueryPerformanceFrequency(&f);
    dqFreq = (double) f.QuadPart;

#pragma omp parallel for

    // Mock data
    for (int k = 0; k <= 1000; k += 50) {

        double array[k];

        for (int l = 0; l < k; ++l) {
            array[l] = rand();
        }

        //  tick
        QueryPerformanceCounter(&time_start);

        getMax(array, k);
        getMin(array, k);
        getMean(array, k);
        getSD(array, k);

        // tack
        QueryPerformanceCounter(&time_over);

        // Get time in us
        run_time = 1000000 * (time_over.QuadPart - time_start.QuadPart) / dqFreq;

        printf("\ndata num:%d, run_time:%fus", k, run_time);

    }
}