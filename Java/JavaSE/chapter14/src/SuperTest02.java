public class SuperTest02 {
    public static void main(String[] args) {
    new C02();
    }
}

class A02{
    public A02() {
        System.out.println("A���޲������췽��");
    }
}

class B02 extends A02{
    public B02() {
        System.out.println("B���޲������췽��");
    }

    public B02(String name){
        System.out.println("B���в������췽��(String)");
    }
}

class C02 extends B02{
    public C02() {
        this("zhangsan");
        System.out.println("C���޲������췽��ִ��");
    }

    public C02(String name) {
        this(name,20);
        System.out.println("C���в������췽��ִ��(String)");
    }

    public C02(String name, int age) {
        super(name);
        System.out.println("C���в������췽��ִ��(String, int )");
    }
}