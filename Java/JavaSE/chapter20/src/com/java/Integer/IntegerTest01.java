package com.java.Integer;

/*
    Java中为基本数据类型又对应准备了8种包装类,8种包装类属于引用数据类型,父类是Object
 */

public class IntegerTest01 {
    public static void main(String[] args) {
        //有没有这种需求:调用doSome()方法的时候需要传一个数字进去
        //但是数字属于基本数据类型,而doSome方法参数的类型是Object
        //doSome方法无法接受基本数据类型的数字

        //可以传一个数字对应的包装类进去
        Integer integer = new Integer(100);
        doSome(integer);
    }

    public static void doSome(Object obj){
        System.out.println(obj);
    }
}