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
    String name;//Java�����������г��ֺ͸���ͬ��������(����)

    public Vip() {
    }

    public Vip(String name) {
        super(name);
    }

    public void shopping(){
        System.out.println(this.name + " is shopping");//null
        //����������к͸���ͬ��������,��Ҫ�������з��ʸ�����������,"super."����ʡ��
        System.out.println(super.name + " is shopping");//zhangsan

        System.out.println(name + " is shopping");//null
    }
}