/*
    java语言中异常是以什么样的形式存在的？
        1.异常在Java中以类的形式存在，每一个异常类都可以创建异常对象
 */
public class ExceptionTest02 {
    public static void main(String[] args) {

        //通过“异常类”实例化“异常对象”
        NumberFormatException nfe = new NumberFormatException("数字格式化异常！");
        System.out.println(nfe);

    }
}
