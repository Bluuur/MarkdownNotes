public class OverrideTest01 {
    public static void main(String[] args) {
        //创建对象
        Bird01 b = new Bird01();
        b.move();
        //当鸟在执行move方法的时候,最好的结果是:"鸟在飞"
        //但是当前程序在执行move方法的时候输出结果是:"动物在移动"
        //很显然Bird子类从Animal父类中继承过来的move()方法已经无法满足子类的业务需求

        Cat01 c = new Cat01();
        c.move();
    }
}

class Animal00 {
    //移动
    public void move(){
        System.out.println("动物在移动");
    }
}

//子类
class Bird01 extends Animal00 {
        //子类继承父类中,有一些"行为"可能不需要改进,有一些"行为"可能必须改进
        //因为父类中继承过来的方法已经无法满足子类的业务需求
}

class Cat01 extends Animal00 {

}
