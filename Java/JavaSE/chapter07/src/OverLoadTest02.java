/*
    ʹ�÷������ص��ŵ㣺
        ������������
        �������Ƶģ������÷�������ͬ

    java�����еķ�������
        ����java���������Ȼ�ͨ������������
        ��������������ͬ������ݷ����Ĳ������ͽ�������

 */
public class OverLoadTest02 {
    public static void main(String[] args) {
        int x = addition(10, 20);
        System.out.println(x);

        double y = addition(10.0, 20.0);
        System.out.println(y);

        long z = addition(10L, 20L);
        System.out.println(z);
    }

    //����һ������int�������ݵ���ͷ���
    public static int addition(int a, int b){
        System.out.println("int���");
        int result = a + b;
        return result;
    }

    //����һ������double�������ݵ���ͷ���
    public static double addition(double a, double b){
        System.out.println("double���");
        double result = a + b;
        return result;
    }

    //����һ������long�������ݵ���ͷ���
    public static long addition(long a, long b){
        System.out.println("long���");
        long result = a + b;
        return result;
    }
}
