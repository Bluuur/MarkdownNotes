package com.feidian.java.thread;

public class ThreadTest07 {
    public static void main(String[] args) {
        Thread t = new MyThread03();
        t.setName("t");
        t.start();

        //sleep()是一个静态方法,不是实例方法,不是对象级别的方法.使用"引用."调用sleep()
        //与直接用"类名."调用没有区别,结果是让"currentThread"睡眠
        //在下面的代码中,是让主线程睡眠
        try {
            t.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread03 extends Thread{
    @Override
    public void run() {
        for(int  i = 0; i < 1000; i++){
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
