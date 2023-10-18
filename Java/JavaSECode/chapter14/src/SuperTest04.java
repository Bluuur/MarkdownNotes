public class SuperTest04 {
    public static void main(String[] args) {
        Vip v = new Vip("zhangsan");
        v.shopping();
    }
}

class Customer{
    String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }
}

class Vip extends Customer{
    String name;//Java中允许子类中出现和父类同名的属性(变量)

    public Vip() {
    }

    public Vip(String name) {
        super(name);
    }

    public void shopping(){
        System.out.println(this.name + " is shopping");//null
        //如果子类中有和父类同名的属性,想要在子类中访问父类的这个特征,"super."不能省略
        System.out.println(super.name + " is shopping");//zhangsan

        System.out.println(name + " is shopping");//null
    }
}