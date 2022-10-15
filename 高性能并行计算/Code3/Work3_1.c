//
// Created by ZidongZh on 2022/10/6.
//

#include<stdio.h>
#include<mpi.h>

int main(int argc, char *argv[]) {
    double x;
    double sum;
    double h;
    double pi;
    double tick;
    double tack;

    int rank;
    int size;
    long long n;
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    n = 0;
    if (0 == rank) {
        printf("Please enter n:");
        scanf("%d", &n);
        tick = MPI_Wtime();
    }

    MPI_Bcast(&n, 1, MPI_INT, 0, MPI_COMM_WORLD);

    h = 1.0 / (double) n;
    sum = 0.0;

    int i;
    for (i = rank + 1; i <= n; i += size) {
        x = h * ((double) i - 0.5);
        sum += (4 / (1 + x * x));
    }
    sum *= h;

    MPI_Reduce(&sum, &pi, 1, MPI_DOUBLE, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        tack = MPI_Wtime();
        printf("Pi: %0.20f\ntime cost:%fs\n", pi, tack - tick);
    }
    return 0;
}