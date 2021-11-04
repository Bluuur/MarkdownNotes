package com.java.array;

/*
    二维数组中元素的读和写

 */
public class ArrayTest06 {
    public static void main(String[] args) {
        int[][] a = {
                {34, 3, 65},
                {100, 200, 3900, 111},
                {0}
        };

        //取出a中的第一个一维数组
        int[] a0 = a[0];
        //第一个一维数组的第一个元素
        int i =  a0[0];
        //i 等价:
        System.out.println(i == a[0][0]);//这是上面两行代码的合并

    }
}
