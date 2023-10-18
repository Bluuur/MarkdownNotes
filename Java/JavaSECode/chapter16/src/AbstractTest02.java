public class AbstractTest02 {
    public static void main(String[] args) {
        DongWu n = new Niao();//父类是抽象类
        n.move();//可以使用多态
        //面向抽象编程
    }
}

abstract class DongWu{
    public abstract void move();
}

class Niao extends DongWu{
    //子类会将抽象父类中的抽象方法继承过来
    //如果子类不是抽象类,那么必须将从父类中继承过来的抽象方法重写(实现)
    @Override
    public void move() {
        System.out.println("move method");
    }
}
