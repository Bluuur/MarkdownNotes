//
// Created by ZidongZh on 2022/9/23.
//

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

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
    for (int length = 10; length < 100 * 100; length += 200) {
        int tic = clock();
        int array[length];
        for (int i = 0; i < length; i++) {
            array[i] = rand() % 100;
        }
        BubbleSort(array, length);
        int tak = clock();
        printf("n = %d, time cost: %d ms\n", length, (tak - tic));
    }
    return 0;
}
