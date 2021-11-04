package com.feidian.java.thread;

public class ThreadTest02 {
    //这里是main方法,这里的代码属于主线程,在主栈中运行
    //创建一个分支线程对象
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //启动分支线程
        //start方法的作用是在JVM中开辟一个新的栈空间,这段代码的任务(开辟新的栈空间)完成之后,瞬间就结束了,线程启动成功
        //启动成功的线程会自动调用run方法,并且run方法在分支栈的底部(压栈)
        //run方法在分支栈的栈底,main方法在主栈的栈底;run方法和main方法是平级的
        myThread.start();
        //如果直接调用myThread.run()方法,不会启动线程,不会分配新的分支栈
        //从这里开始的代码任然运行在主线程中
        for (int i = 0; i < 1000; i++){
            System.out.println("主线程-->" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("分支线程-->" + i);
        }
    }
}