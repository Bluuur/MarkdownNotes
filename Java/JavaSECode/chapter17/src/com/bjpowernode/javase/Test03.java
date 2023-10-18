package com.bjpowernode.javase;

//import java.util.Scanner;
//或者：
import  java.util.*;//这里不需要手动输入，IDEA会自动导包

public class Test03 {
    public static void main(String[] args) {//为什么String不需要导入？
        //因为string在java.lang包根目录下，不需要手动导入（lang包下annotation等目录内的类需要导入）

//        java.util.Scanner s = new java.util.Scanner(System.in);
//        这样写太麻烦了，直接使用import
        Scanner s = new Scanner(System.in);
        System.out.print("Enter text:");
        String str = s.next();
        System.out.println("the text you entered is:" + str);
    }
}
