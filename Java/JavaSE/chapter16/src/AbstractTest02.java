public class AbstractTest02 {
    public static void main(String[] args) {
        DongWu n = new Niao();//�����ǳ�����
        n.move();//����ʹ�ö�̬
        //���������
    }
}

abstract class DongWu{
    public abstract void move();
}

class Niao extends DongWu{
    //����Ὣ�������еĳ��󷽷��̳й���
    //������಻�ǳ�����,��ô���뽫�Ӹ����м̳й����ĳ��󷽷���д(ʵ��)
    @Override
    public void move() {
        System.out.println("move method");
    }
}
