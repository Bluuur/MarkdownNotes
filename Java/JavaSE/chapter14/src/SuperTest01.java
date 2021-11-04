public class SuperTest01 {
    public static void main(String[] args) {
    new B();//模拟现实,先有父子类型对象,后有子类型对象
    }
}

class A{
    /*
    public A(){
        System.out.println("A类的无参数构造方法");
    }
    */

    public A(int i){

    }
}

class B extends A{

    public B(){
        super(123);
//        super();//这里实际上有个super方法,用来调用父类的构造方法
        System.out.println("B类的无参数构造方法");
    }
}
