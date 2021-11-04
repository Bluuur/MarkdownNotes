/*
    1.什么是异常，Java提供异常机制有什么用
        以下程序在执行过程中发生了不正常的情况，而这种不正常的情况叫做：异常
        Java语言是很完善的语言，提供了异常的处理方式，以下程序执行过程中出现了不正常情况
        Java把该异常信息打印输出到控制台，供程序员参考
        程序员在看到异常信息之后，可以对程序进行修改，让程序更加健壮
    2.以下程序运行时出现了异常信息，这个信息时JVM打印的

 */
public class ExceptionTest01 {
    public static void main(String[] args) {
/*
        int a = 10;
        int b = 0;
        int c = a / b;
        System.out.println(c);
 */
        int a = 10;
        int b = 0;
        if(b == 0){//实际上JVM在执行到此处的时候，会new异常对象：new ArithmeticException("/ by zero");然后再控制台上抛出异常对象
            System.out.println("除数不能为零");
            return;
        }
        //程序运行到此处表示输出一定不是0
        int c = a / b;
        System.out.println(c);
    }
}
