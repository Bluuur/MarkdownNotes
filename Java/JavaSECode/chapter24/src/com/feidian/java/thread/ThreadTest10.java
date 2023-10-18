package com.feidian.java.thread;

public class ThreadTest10 {
    public static void main(String[] args) {
        MyRunnable05 r = new MyRunnable05();
        Thread t = new Thread(r);
        t.setName("t");
        t.start();

        //5秒后终止t线程
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终止线程
        r.run = false;
    }

}

class MyRunnable05 implements Runnable{
    //添加bool标记,控制线程的终止与执行
    boolean run = true;
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            if(run){
                System.out.println(Thread.currentThread().getName() + "-->" + (i + 1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //如果有数据需要保存,可以在return前添加代码保存
                return;//如果外部修改run标记为false,则结束run方法
            }
        }
    }
}