public class SuperTest02 {
    public static void main(String[] args) {
    new C02();
    }
}

class A02{
    public A02() {
        System.out.println("A的无参数构造方法");
    }
}

class B02 extends A02{
    public B02() {
        System.out.println("B的无参数构造方法");
    }

    public B02(String name){
        System.out.println("B类有参数构造方法(String)");
    }
}

class C02 extends B02{
    public C02() {
        this("zhangsan");
        System.out.println("C的无参数构造方法执行");
    }

    public C02(String name) {
        this(name,20);
        System.out.println("C的有参数构造方法执行(String)");
    }

    public C02(String name, int age) {
        super(name);
        System.out.println("C的有参数构造方法执行(String, int )");
    }
}