public class OverrideTest01 {
    public static void main(String[] args) {
        //��������
        Bird01 b = new Bird01();
        b.move();
        //������ִ��move������ʱ��,��õĽ����:"���ڷ�"
        //���ǵ�ǰ������ִ��move������ʱ����������:"�������ƶ�"
        //����ȻBird�����Animal�����м̳й�����move()�����Ѿ��޷����������ҵ������

        Cat01 c = new Cat01();
        c.move();
    }
}

class Animal00 {
    //�ƶ�
    public void move(){
        System.out.println("�������ƶ�");
    }
}

//����
class Bird01 extends Animal00 {
        //����̳и�����,��һЩ"��Ϊ"���ܲ���Ҫ�Ľ�,��һЩ"��Ϊ"���ܱ���Ľ�
        //��Ϊ�����м̳й����ķ����Ѿ��޷����������ҵ������
}

class Cat01 extends Animal00 {

}
