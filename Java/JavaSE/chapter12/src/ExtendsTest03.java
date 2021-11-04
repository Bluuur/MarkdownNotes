public class ExtendsTest03 {
    public static void main(String[] args) {
        //创建子类对象
        Cat c = new Cat();
        //调用方法
        c.move();
        System.out.println(c);
    }
}

class Animal extends Object{
    //名字
    String name = "XiaoHei";//默认值
    //提供一个动物移动的方法
    public void move(){
        System.out.println(name + "正在移动");
    }
}

//Cat子类
//Cat继承Anima，会将Animal中所有的属性全部继承过来
class Cat extends Animal{

}
