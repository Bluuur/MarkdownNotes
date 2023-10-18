package com.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) throws InterruptedException, ParseException {
        while (true){

            Thread.sleep(1000);
            Date date = new Date();//获取系统当前时间(精确到毫秒)
//            System.out.println(date);
            //日期格式化
            //将日期类型按照指定的格式转换,转换成具有一定格式的日期
            //使用SimpleDateFormat类

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
            System.out.println(sdf.format(date));

            //日期字符串String转为Date类型
            String time = "2018-11-25 11:59:30";
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1  = sdf2.parse(time);
            System.out.println(date1);
        }
    }
}
