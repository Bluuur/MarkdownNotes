/*
    空指针异常（NullPointerException）

    关于垃圾回收器GC
        在Java语言中，垃圾回收器主要针对的是堆内存
        当一个Java对象没有任何引用指向该对象的时候
        GC会考虑将该垃圾数据释放回收掉

    出现空指针异常的前提条件
        “空引用”访问实例（对象）相关数据时，都会出现空指针异常
*/
public class NullPointerTest {
    public static void main(String[] args) {
        //创建客户对象
        Customer c = new Customer();//默认赋值0
       //访问这个客户的id
        System.out.println(c.id);

        //重新给id赋值
        c.id = 9521;//代号
        System.out.println("客户的代号是：" + c.id);

//        c = null;
//        System.out.println(c.id);//这里符合Java语法机制，编译器不会报错
        //运行错误Exception in thread "main" java.lang.NullPointerException
    }
}

class Customer{
    //客户id
    int id;
}
