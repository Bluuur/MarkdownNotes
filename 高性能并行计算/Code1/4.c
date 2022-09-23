//
// Created by ZidongZh on 2022/9/23.
//

#include<stdio.h>
#include<stdlib.h>

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
    // Get the length of data
    int length;

    printf("Enter the size of data:");
    scanf("%d", &length);

    int array[length];

    for (int i = 0; i < length; i++) {
        array[i] = rand();
    }
    BubbleSort(array, length);

    for (int j = 0; j < length; j++) {
        printf("%d ", array[j]);
    }

    return 0;
}
