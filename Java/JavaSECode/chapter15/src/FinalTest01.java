public class FinalTest01 {
    public static void main(String[] args) {

    }
}

class User{
//    final double Height = 1.8;//
    final double height;//这里没有赋值,而是在构造方法中赋值
    //这样是没有问题的,和赋默认值一样,赋值的过程发生在new对象调用构造方法的时候
    //在下面的构造方法中手动赋了值,程序是可以正常运行的,但是如果在下面的构造方法中没有手动赋值
    //是不会有自动的默认赋值的,因为final修饰的变量只能赋值一次,系统不会用掉这个唯一一次的赋值
    public User() {
        this.height = 1.8;
    }
}