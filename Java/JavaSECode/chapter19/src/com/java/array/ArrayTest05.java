package com.java.array;

/*
    1.main中的String[] args有什么用
        JVM负责调用main方法
        JVM调用main方法的时候，会自动传一个string数组过来
 */
public class ArrayTest05 {
    //这个方法程序员负责写出来，JVM负责调用。JVM调用的时候一定会传一个String数组过来
    public static void main(String[] args) {
        //JVM默认传递过来的数组对象的长度默认为0
        System.out.println(args.length);
        //以下这一行代码代表的含义：数组对象创建了，但是数组中没有任何数据
        //String[] strs = nre String[0];
        //String[] strs = {};//静态初始化数据，里面没有东西

        //这个数组里面什么时候会有值
        //这个数组是留给用户的，用户可以在控制台上输入参数，这个参数会自动被转换为“String[] args”
        //例如这样运行程序：java ArrayTest05 abc def xyz
        //那么这个时候JVM会自动将“abc def xyz”通过空格的方式进行分离，分离完成之后，自动放到“String[] args”数组
        //所以main方法上面的String[] args数组主要是用来接受用户输入参数的

    }

}

