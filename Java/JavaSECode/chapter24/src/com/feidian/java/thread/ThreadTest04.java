package com.feidian.java.thread;

public class ThreadTest04 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    System.out.println("线程类--->" + i);
                }
            }
        });

        t.start();

        for (int i = 0; i < 1000; i++){
            System.out.println("main--->" + i);
        }
    }
}
