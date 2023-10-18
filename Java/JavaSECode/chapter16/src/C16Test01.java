public class C16Test01 {
    public static void main(String[] args) {
        //接口的多态
        MyMath mm = new MyMathImpl();//面向接口编程
        System.out.println(mm.sub(5,2));
    }
}

interface MyMath{
    double PI = 3.1415926;
    int sum(int a, int b);
    int sub(int a, int b);
}

class MyMathImpl implements MyMath{

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}