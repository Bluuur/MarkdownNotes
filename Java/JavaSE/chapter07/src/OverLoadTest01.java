/*
    方法重载机制
        1.以下程序先不使用方法重载机制，分析程序的缺点
            三个方法功能不同，但是相似。

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

    //定义一个计算int类型数据的求和方法
    public static int intAddition(int a, int b){
        int result = a + b;
        return result;
    }

    //定义一个计算double类型数据的求和方法
    public static double doubleAddtion(double a, double b){
        double result = a + b;
        return result;
    }

    //定义一个计算long类型数据的求和方法
    public static long longAddtion(long a, long b){
        long result = a + b;
        return result;
    }
}
