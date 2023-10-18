/*
    关于Java中的package和import机制
        1.为什么要使用package
            package是Java中包机制
            包机制的作用是方便程序的管理
            不同功能的类分别存放在不同的包下
            （按照功能划分的，不同的软件包具有不同的功能）
        2.package怎么用
            package是一个关键字，后面加包名
            例如：com.feidianstudio.shell
            注意:package语句只能出现在Java源代码的第一行
        3.包名的命名规范
            一般都采用公司域名倒序的方式（因为公司域名具有全球唯一性 ）
                公司域名倒序+项目名+模块名+功能名
        4.对于带有package的Java程序怎么编译和运行
            类名不再是HelloWorld了
            类名变成com.bjpowernode.javase.chapter17.HelloWorld
            编译：javac -d . HelloWorld.java
            -d:-directory
            .:当前目录

 */
package com.bjpowernode.javase;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
