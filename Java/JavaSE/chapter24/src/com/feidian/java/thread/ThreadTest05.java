package com.feidian.java.thread;

public class ThreadTest05 {
    public static void main(String[] args) {
        MyThread2 mt2 = new MyThread2();
        //设置线程名
        mt2.setName("tttt");
        //获取线程名
        String name = mt2.getName();
        System.out.println(name);
//        mt2.start();

        Thread currentThread = Thread.currentThread();
        String cThreadName =  currentThread.getName();
        System.out.println(cThreadName);
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("分支线程-->" + i);
        }
    }
}