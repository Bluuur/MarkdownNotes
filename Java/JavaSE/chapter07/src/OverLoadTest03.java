/*
    ��������
        ʲôʱ����ʹ�÷�������
            ��ͬһ�����У�������������Ĺ��������Ƶģ����Կ��ǽ�����������һ�£���������
            �����ۣ��ֱ��ں��ڵĴ����д
 */
public class OverLoadTest03 {
    public static void main(String[] args) {
        m1();
        m1(100);
    }

    public static void m1(){
        System.out.println("m1�޲�����ִ��");
    }

    //z��������Ĳ������������淽���Ĳ���������ͬ
    public static void m1(int a){
        System.out.println("m1��һ��int����ִ��");
    }
}

class MyClass01{
    public static void m1(int x, int y){

    }
}