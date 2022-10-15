//
// Created by ZidongZh on 2022/10/6.
//
#include<stdio.h>
#include "mpi.h"

int main(int argc, char *argv[]) {
    static int NUM_STEPS = 1000000000;

    int rank;
    int size;

    double pi;
    double step;
    double x;
    double sum;
    double start;
    double finish;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Bcast(&NUM_STEPS, 1, MPI_INT, 0, MPI_COMM_WORLD);

    step = 1.0 / (double) NUM_STEPS;
    sum = 0.0;

    if (rank == 0) {
        start = MPI_Wtime();
    }

    int i;
    for (i = rank; i < NUM_STEPS; i += size) {
        x = step * ((double) i - 0.5);
        sum += 4.0 / (1.0 + x * x);
    }

    sum = step * sum;

    MPI_Reduce(&sum, &pi, 1, MPI_DOUBLE, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        finish = MPI_Wtime();
        printf("Pi: %.20f\nTime cost: %fs\n", pi, finish - start);
    }

    MPI_Finalize();
    return 0;
}
