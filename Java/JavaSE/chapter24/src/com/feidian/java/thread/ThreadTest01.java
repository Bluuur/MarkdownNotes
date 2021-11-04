package com.feidian.java.thread;
/*
    以下程序，除了垃圾回收线程之外，只有一个线程，因为只有一个栈
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main begin");
    }

    private static void m1() {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 begin");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 begin");
    }

    private static void m3() {
        System.out.println("m3 begin");
        System.out.println("m3 begin");
    }
}
