import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
    处理异常的第一种方式：在方法声明的位置上使用throws关键字抛出，谁调用就抛给谁。抛给调用者来处理
 */
public class ExceptionTest06 {
    //一般不建议在main方法上使用throws，因为这个异常如果真正的发生了，一定会抛给JVM，JVM只有终止
    //异常处理机制的作用就是增强程序的健壮性，要做到异常发生了也不影响程序的执行
    //一般main方法中的异常建议使用try...catch进行捕捉
    public static void main(String[] args) {
        try {
            System.out.println(100 / 0);//运行时异常，这里可以不处理，编译器不管
        } catch (ArithmeticException e){
            System.out.println("出现算数异常！");
        }
        System.out.println("main begin");
        m1();
        System.out.println("main over");
    }

    private static void m1(){
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }

    private static  void m2(){
        System.out.println("m2 begin");
        try {//try尝试
            m3();
            //以上代码出现异常，直接进入catch语句块中执行
            System.out.println("hello");//这行不会被执行
        } catch (FileNotFoundException e) {//catch实在捕捉异常之后走的分支 这个小括号里的e是变量名（小括号 形参）
            //这个分支可以使用e引用，e引用保存的内存地址是那个new出来的异常对象的地址
            //在catch中处理异常，try...catch捕捉异常之后，代码会继续往下运行
            System.out.println("路径错误或文件不存在！");//上行代码中的e接受异常对象的
        }
        //#注意#只要异常没有捕捉，采用上报的方式，此方法的后续代码不会执行
        System.out.println("m2 over");
    }

    private static void m3()throws FileNotFoundException {
        //调用SUN jdk中的构造方法
        //创建以一个输入流对象，该流指向一个文件
        //编译报错的原因是什么
        //  第一这里调用了一个构造方法：FileInputStream(String name)
        //  第二这个构造方法的声明位置上有throw FileNotFoundException
        //  第三：通过类的继承结构看到FileNotFoundException的父类是IOException,IOException的父类是Exception
        //  所以FileNotFoundException是编译时异常，必须在编译时处理异常
        new FileInputStream("D:\\progrem\\Java_learnling\\chapter01\\test1.java");//两个反斜杠，第一个是转义字符
        System.out.println("如果看到这行话，说明此方法中没有异常");

    }
}
