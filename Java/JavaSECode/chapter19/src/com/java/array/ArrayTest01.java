package com.java.array;

public class ArrayTest01 {
    public static void main(String[] args) {
        //静态初始化一维数组
        int[] a1 = {1, 33, 55, 1919};
        printArray(a1);

        System.out.println("-----------------");

        //还可以这样打印:
        printArray(new int[]{11222, 533, 6565, 1321});

        System.out.println("-----------------");

        //动态初始化一维数组
        int[] a2 = new int[5];
        printArray(a2);

        System.out.println("-----------------");

        printArray(new int[3]);
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.println(i);
        }
    }
}
