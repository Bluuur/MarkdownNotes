/*
    方法重载
        什么时候考虑使用方法重载
            在同一个类中，如果两个方法的功能是相似的，可以考虑将两个方法名一致，这样代码
            既美观，又便于后期的代码编写
 */
public class OverLoadTest03 {
    public static void main(String[] args) {
        m1();
        m1(100);
    }

    public static void m1(){
        System.out.println("m1无参数的执行");
    }

    //z这个方法的参数个数和上面方法的参数个数不同
    public static void m1(int a){
        System.out.println("m1有一个int参数执行");
    }
}

class MyClass01{
    public static void m1(int x, int y){

    }
}