public class ExceptionTest04 {
    public static void main(String[] args) {
        //main方法中调用doSome()
        //因为doSome()方法声明位置上有：throws ClassNotFoundException
        //我们在调用doSome()方法的时候必须对这种异常进行预先的处理
        //如果不处理，编译器就报错
    }
/*
    doSome方法在方法声明的位置上使用了：throws ClassNotFoundException
    这个代码表示doSome()方法在执行过程中有可能会出现ClassNotFoundException异常
    这个ClassNotFoundException类的直接父类是：Exception，所以ClassNotFoundException属于编译时异常
 */
    public void doSome() throws ClassNotFoundException{

    }
}
