/*
    �������ػ���
        1.���³����Ȳ�ʹ�÷������ػ��ƣ����������ȱ��
            �����������ܲ�ͬ���������ơ�

 */
public class OverLoadTest01 {
    public static void main(String[] args) {
        int x = intAddition(10, 20);
        System.out.println(x);

        double y = doubleAddtion(10.0, 20.0);
        System.out.println(y);

        long z = longAddtion(10L, 20L);
        System.out.println(z);
    }

    //����һ������int�������ݵ���ͷ���
    public static int intAddition(int a, int b){
        int result = a + b;
        return result;
    }

    //����һ������double�������ݵ���ͷ���
    public static double doubleAddtion(double a, double b){
        double result = a + b;
        return result;
    }

    //����һ������long�������ݵ���ͷ���
    public static long longAddtion(long a, long b){
        long result = a + b;
        return result;
    }
}
