package com.feidian.java.thread;

public class ThreadTest08 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable02());
        t.start();
        try {
            Thread.sleep(1000 * 5);//五秒后终断t线程睡眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();//打断t的睡眠,引起线程t的sleep()异常,执行catch
    }
}

class MyRunnable02 implements Runnable{
    //run()方法中的异常不能抛出,只能try/catch
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---> begin");
        try {//这里不能抛出异常,只能try/catch,因为子类不能比父类抛出更多的异常
            Thread.sleep(1000 * 60 * 60 * 24 * 365);//睡眠一年
        } catch (InterruptedException e) {
            e.printStackTrace();//打印异常
        }
        System.out.println(Thread.currentThread().getName() + "---> end");
    }
}
