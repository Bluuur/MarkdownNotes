package com.java.array;

/*
    ��ά������Ԫ�صĶ���д

 */
public class ArrayTest06 {
    public static void main(String[] args) {
        int[][] a = {
                {34, 3, 65},
                {100, 200, 3900, 111},
                {0}
        };

        //ȡ��a�еĵ�һ��һά����
        int[] a0 = a[0];
        //��һ��һά����ĵ�һ��Ԫ��
        int i =  a0[0];
        //i �ȼ�:
        System.out.println(i == a[0][0]);//�����������д���ĺϲ�

    }
}
