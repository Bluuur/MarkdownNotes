package com.feidian.java.thread;

public class ThreadTest06 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "-->" + (i + 1));
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
