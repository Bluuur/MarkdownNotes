package com.feidian.java.thread;

public class ThreadTest09 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable04());
        t.setName("t");
        t.start();
        //模拟5秒
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5秒后强制终止t线程
        t.stop();//已过时(不建议使用)
    }
}

class MyRunnable04 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
