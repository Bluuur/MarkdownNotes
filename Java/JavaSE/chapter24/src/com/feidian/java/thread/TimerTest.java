package com.feidian.java.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer01 = new Timer();
        Timer timer02 = new Timer(true);//也可以在创建timer对象时,设置其为守护线程

        //指定定时任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date firstTime = sdf.parse("2021-03-21 14:13:00");
            timer01.schedule(new LogTimerTask(), firstTime, 1000 * 10);//可以认为这是一个线程
            //这里的task也可以采用匿名内部类的方式
            //类<LogTimerTask>中的run方法会从<firstTime>起,每隔<period>时长执行一次
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

//编写一个定时任务类
class LogTimerTask extends TimerTask{

    @Override
    public void run() {
        //编写需要执行的任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + ": 完成备份");
    }
}