public class ExtendsTest03 {
    public static void main(String[] args) {
        //�����������
        Cat c = new Cat();
        //���÷���
        c.move();
        System.out.println(c);
    }
}

class Animal extends Object{
    //����
    String name = "XiaoHei";//Ĭ��ֵ
    //�ṩһ�������ƶ��ķ���
    public void move(){
        System.out.println(name + "�����ƶ�");
    }
}

//Cat����
//Cat�̳�Anima���ὫAnimal�����е�����ȫ���̳й���
class Cat extends Animal{

}
