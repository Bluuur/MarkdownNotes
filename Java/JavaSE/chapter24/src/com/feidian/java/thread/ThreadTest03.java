package com.feidian.java.thread;

public class ThreadTest03 {
    public static void main(String[] args) {
        //创建一个可运行对象
        MyRunnable04 r = new MyRunnable04();
        //将可运行的对象封装成一个线程对象
        Thread t = new Thread(r);
        //启动线程
        t.start();
        for (int i = 0; i < 1000; i++){
            System.out.println("主线程-->" + i);
        }
    }
}

//这不是一个线程类,是一个可运行类.它还不是一个线程
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("分支线程-->" + i);
        }
    }
}
