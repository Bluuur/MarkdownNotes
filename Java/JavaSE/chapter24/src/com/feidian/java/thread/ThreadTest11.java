package com.feidian.java.thread;

public class ThreadTest11 {
    public static void main(String[] args) {
        Thread t = new BackUpThread();
        t.setName("数据备份线程");
        //启动线程前,将t设置为守护线程
        t.setDaemon(true);
        t.start();

        //主线程(用户线程)
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//守护线程(用户线程全部结束,守护线程也结束)
class BackUpThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        //死循环
        while (true){
            System.out.println(Thread.currentThread().getName() + "-->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
