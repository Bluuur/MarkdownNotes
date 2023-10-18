package com.bjpowernode.javase;

public class Test01 {
    public static void main(String[] args) {
//        com.bjpowernode.javase.chapter17.HelloWorld hw = new com.bjpowernode.javase.chapter17.HelloWorld;
//        System.out.println(hw);

        //包名可以省略吗？
        HelloWorld h = new HelloWorld();//可以，因为HelloWorld和Test01在同一个包下
/*
    如果不再同一个包内怎么办？
        使用import引入包
    import什么时候使用
        A类中使用B类
            A类和B类都在同一个包下，不需要import
            A类和B类不在同一个包下，需要使用import

    import怎么用
        import语句只能出现在package语句之下，class语句之上
        import语句可以采用*的方式（缺省符）导入包下所有类
 */
    }
}
