/*
    1.for循环的语法机制以及运行原理
        for(初始化表达式; 布尔(条件)表达式; 更新表达式){
            循环体（由Java语句构成）;
        }
        注意：
            第一：初始化表达式最先执，并且在整个循环中只执行一次
            第二：条件表达式结果必须是一个布尔类型：true或false

            初始化表达式\布尔表达式\更新表达式都不是必须的,可以缺失

        执行原理：
            首先执行初始化表达式,然后执行条件表达式,如果为true则执行循环体,然后执行更新表达式
            然后执行条件表达式,如果为true,执行循环体,以此循环,直到条件表达式结果为false跳出循环

       更新表达式的作用是:控制循环的次数,换句话说,更新表达式会更新某个变量的值,这样条件表达式的结果才有可能从true
       变成false,从而终止for循环的执行,如果缺失更新表达式,很有可能会导致死循环

 */
public class ForTest02 {
    public static void main(String[] args) {
        //最简练的for循环
        for(int i = 0; i < 10; i++){
            //i变量只能在循环中使用
            //i变量属于for循环域
            System.out.println("i = " + i);
        }

        int u = 0;
        for (;u < 10; u++){
            System.out.println("u = " + u);
        }
        System.out.println(u);
    }
}
