package com.feidian.java.thread;

/*
    实现线程的第三种方式
        实现Callable接口
        优点:可与获取到线程的执行结果
        缺点:效率比较低,在获取t线程执行结果的时候,当前线程受阻塞,效率比较低
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;//JUC包下,属于Java的并法宝,老JDK中没有这个包

public class ThreadTest12 {
    public static void main(String[] args) {
        //第一步:创建一个"未来任务类"对象
        //参数非常重要,需要给一个Callable接口实现类对象
        FutureTask task = new FutureTask(new Callable() {//call()方法就相当于run方法,只不过call方法有返回值
            //线程执行一个任务,执行之后可能有一个执行结果
            //模拟执行
            @Override
            public Object call() throws Exception {
                System.out.println("call方法执行");
                Thread.sleep(1000 * 10);
                System.out.println("call方法结束");
                return new Object();
            }
        });//需要传入参数Callable/Runnable,如果传入Runnable,则没有返回值

        //创建线程对象
        Thread t = new Thread(task);
        //启动线程对象
        t.start();

        //获取t线程的返回结果
        try {
            Object obj = task.get();//在主线程中获取t线程的返回结果,会导致main线程阻塞
            //get()方法的执行会导致当前线程的阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
