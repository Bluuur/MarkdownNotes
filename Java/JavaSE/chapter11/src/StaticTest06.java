/*
    1.使用static关键字可以定义：静态代码块
    2.语法
        static{
            java语句；
            java语句；
        }
    3.static静态代码块在什么时候执行?
        类加载时执行，并且只执行一次
        静态代码块 具有这样的特点/特征
    4.注意：静态代码块在类加载时执行，并且在main方法执行之前执行
    5.静态代码块一般是按照自上而下的顺序执行
    6.静态代码块的作用
        第一：静态代码块不是那么常用，不是每一个类中都要写二点东西
        第二：静态代码块这种语法机制实际上时SUN公司给Java程序员的一个特殊时机
            这个时机叫做：类加载时机
        具体作用：
            项目经理要求：对于所有编写的程序，只要是类加载了，就记录类加载的日志信息
            （哪个类在什么时间加载到JVM中了）
            这些记录日志的代码就写在静态代码块中
 */
public class StaticTest06 {
    //静态代码块
    static {
        System.out.println("A");
    }

    //入口
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    //编写一个静态代码块
    static {
        System.out.println("C");
    }
}
