/*
 * Copyright (c) 2021. by ZiDong Zh
 */

package com.java.date;
/*
    ��ȡ��1970��1��1��00:00:00 000����ǰϵͳʱ����ܺ�����
        ����:ͳ��һ��������ʱ
 */
public class DateTest02 {
    public static void main(String[] args) {
        long nowMillis1 = System.currentTimeMillis();
        print();
        long nowMillis2 = System.currentTimeMillis();
        System.out.println(nowMillis2 - nowMillis1);

    }

    public static void print(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
