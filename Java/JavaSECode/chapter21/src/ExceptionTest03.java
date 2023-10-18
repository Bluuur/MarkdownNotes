public class ExceptionTest03 {
    public static void main(String[] args) {
        /*
        程序执行到此处发生了ArithmeticException异常
        底层new了一个ArithmeticException异常对象
        然后抛给了main方法
        main方法没有被处理，将这个异常自动抛给了JVM
        JVM最终终止程序的执行
        ArithmeticException继承RuntimeException，属于运行时异常
        在程序编写阶段不需要对这种异常进行预先处理
         */
        System.out.println(100 / 0);
        //下面的hello没有输出
        System.out.println("hello");
    }
}
