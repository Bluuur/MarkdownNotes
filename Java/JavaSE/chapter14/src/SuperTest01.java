public class SuperTest01 {
    public static void main(String[] args) {
    new B();//ģ����ʵ,���и������Ͷ���,���������Ͷ���
    }
}

class A{
    /*
    public A(){
        System.out.println("A����޲������췽��");
    }
    */

    public A(int i){

    }
}

class B extends A{

    public B(){
        super(123);
//        super();//����ʵ�����и�super����,�������ø���Ĺ��췽��
        System.out.println("B����޲������췽��");
    }
}
