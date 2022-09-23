//
// Created by ZidongZh on 2022/9/23.
//

#include <stdlib.h>
#include <time.h>
#include <stdio.h>
#include <math.h>

double getMax(double array[]) {
    double max = array[0];
    for (int i = 0; i < ((int) sizeof(array) / sizeof(*array)); ++i) {
        if (array[i] >= max) {
            max = array[i];
        }
    }
    return max;
}

double getMin(double array[]) {
    double min = array[0];
    for (int i = 0; i < ((int) sizeof(array) / sizeof(*array)); ++i) {
        if (array[i] <= min) {
            min = array[i];
        }
    }
    return min;
}

double getMean(double array[]) {
    int len = (int) sizeof(array) / sizeof(*array);
    double sum = 0.0;
    double mean = 0.0;
    for (int i = 0; i < len; ++i) {
        sum += array[i];
    }
    mean = sum / len;
    return mean;
}

double getSD(double array[]) {
    int len = (int) sizeof(array) / sizeof(*array);
    double mean = getMean(array);
    double SS = 0.0;
    for (int i = 0; i < len; ++i) {
        SS += pow(array[i] - mean, 2);
    }
    double SD = sqrt(SS / (len - 1));
    return SD;
}

int main() {
    for (int length = 10; length <= 100 * 100; length += 100) {

        long tic = clock();

        double array[length];
        for (int i = 0; i < length; ++i) {
            array[i] = rand();
        }
        getMax(array);
        getMin(array);
        getMean(array);
        getSD(array);

        long tak = clock();

        printf("n = %d, time cost: %d ms\n", length, tak - tic);
    }
    return 0;
}

