//
// Created by ZidongZh on 2022/9/23.
//

#include "stdio.h"
#include "math.h"

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

    // Get the length of data
    int length;

    printf("Enter the size of data:");
    scanf("%d", &length);

    // init array, get data
    double array[length];

    for (int i = 0; i < length; ++i) {
        printf("Enter data (%d of %d):", i + 1, length);
        scanf("%lf", &array[i]);
    }

    // Display data
    printf("Entered data:");

    for (int i = 0; i < length; ++i) {
        printf("%lf ", array[i]);
    }

    // Output
    printf("\nMax of data is: %lf\n", getMax(array));
    printf("Min of data is: %lf\n", getMin(array));
    printf("Mean of data is: %lf\n", getMean(array));
    printf("SD of data is: %lf\n", getSD(array));
}