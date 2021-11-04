/*
    方法递归;
        方法自己调用自己

        递归没有结束条件的时候,栈内存会溢出
            Exception in thread "main" java.lang.StackOverflowError
        所以递归必须要有结束条件
        如果有合法的结束条件,递归也会有可能出现栈内存溢出错误,可能递归的太深,栈内存不够

        JVM发生错误之后只有一个结果:退出JVM

        在实际开发的过程中,不建议轻易选择递归,能用for循环while循环带代替的,尽量使用循环来做
        因为循环的效率高,耗费的内存少
        递归耗费的内存比较大,另外递归的使用不当会导致JVM死机

        如果必须使用方法递归,确认代码无误后仍然内存溢出
        可以尝试手动分批额JVM内存
        (DOS下使用java -x命令)
 */

public class RecursionTest01 {
    public static void main(String[] args) {
        doSome();
    }

    private static void doSome() {
        System.out.println("doSome method begin");
//        doSome();
        System.out.println("doSome method over");
    }
}
