package com.feidian.java.thread;

import java.util.ArrayList;
import java.util.List;

/*
    使用wait()方法和notify()方法实现生产者/消费者模型

    模拟:
        仓库采用List集合
        仓库List集合中只能存储一个元素
       做到生产一个消费一个
 */
public class ThreadTest16 {
    public static void main(String[] args) {
        //创建一个仓库对象
        ArrayList list = new ArrayList();

        Thread t1 = new Thread(new Producer(list));//生产者线程
        Thread t2 = new Thread(new Consumer(list));//消费者线程

        t1.setName("ProducerThread");
        t2.setName("ConsumerThread");

        t1.start();
        t2.start();
    }
}

class Producer implements Runnable{
    //共享一个仓库
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直生产
        while(true){
            synchronized (list){//给仓库对象list加锁
                if (list.size() > 0){//仓库满了
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {//当前线程进入等待状态,释放t1占有的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {//否则仓库已空,生产者生产
                    Object obj = new Object();
                    list.add(obj);
                    System.out.println(Thread.currentThread().getName() + "--->" + obj);
                    //已完成生产,notify消费者进行消费
                    list.notify();
                }
            }
        }
    }
}

class Consumer implements Runnable{
    //仓库
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直消费
        while (true) {
            synchronized (list){
                if (list.size() == 0){//仓库空
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {//否则仓库满.消费者消费
                    Object obj = list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "--->" + obj);
                    //已完成消费,notify生产者生产
                    list.notify();
                }
            }
        }
    }
}
