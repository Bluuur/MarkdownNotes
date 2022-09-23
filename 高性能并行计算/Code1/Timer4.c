//
// Created by ZidongZh on 2022/9/23.
//

#include<stdio.h>
#include<stdlib.h>
#include <time.h>

void BubbleSort(double array[], int length) {
    int temp;
    for (int i = 0; i < length - 1; i++) {
        for (int j = 0; j < length - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;
            }
        }
    }
}

int main() {

    for (int length = 1; length <= 100 * 100; length += 10) {
        int length = 20;

        long tic = clock();

        int array[length];
        for (int i = 0; i < length; i++) {
            array[i] = rand();
        }

        BubbleSort(array, sizeof(array) / sizeof(array[0]));

        long tak = clock();

        printf("n = %d, time cost: %d ms\n", length, tak - tic);
    }
    return 0;
}
