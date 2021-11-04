/*
 * Copyright (c) 2021. by ZiDong Zh
 */

package com.java.date;
/*
    获取自1970年1月1日00:00:00 000到当前系统时间的总毫秒数
        作用:统计一个方法耗时
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
