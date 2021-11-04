/*
    使用方法重载的优点：
        代码整齐美观
        功能相似的，可以让方法名相同

    java语言中的方法区分
        首先java编译器首先会通过方法名区分
        如果方法名如果相同，会根据方法的参数类型进行区分

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

    //定义一个计算int类型数据的求和方法
    public static int addition(int a, int b){
        System.out.println("int求和");
        int result = a + b;
        return result;
    }

    //定义一个计算double类型数据的求和方法
    public static double addition(double a, double b){
        System.out.println("double求和");
        double result = a + b;
        return result;
    }

    //定义一个计算long类型数据的求和方法
    public static long addition(long a, long b){
        System.out.println("long求和");
        long result = a + b;
        return result;
    }
}
