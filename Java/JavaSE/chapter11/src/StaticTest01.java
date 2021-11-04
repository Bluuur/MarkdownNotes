/*
    static：
        1.static被翻译为”静态的“
        2.所有static关键字修饰的都是类相关的，类级别的
        3.所有static修饰的，都是”类名.“的方式访问
        4.static修饰的变量：静态变量
        5.static修饰的方法：静态方法

    变量的分类
        变量根据定义的位置进行划分
            在方法体中声明的变量是局部变量
            在类体中声明的变量是成员变量

        成员变量又可以分为：
            实例变量
            静态变量
 */
public class StaticTest01 {
}
class VarTest{
    //以下静态的都是类相关的，访问时采用”类名.“的方式，不需要new对象
    //以下实例的，都是对象相关的，访问时采用”引用.“的方式访问，需要先new对象

    //成员变量中的实例变量
    int i;

    //成员变量中的静态变量
    static int k;

    //静态方法
    public static void m1(){

    }

    //实例方法
    public void m2(){

    }
}
