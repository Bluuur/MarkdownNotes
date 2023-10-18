public class FinalTest02 {
    public static void main(String[] args) {

    }
}

class Chinese{
    //身份证号,对象级别
    String idCard;
    //姓名,对象级别
    String name;
    //国籍,每个人都一样
    static final  String COUNTRY = "中国";
    //实例变量的缺点:实例变量是对象级别的变量 , 储存在堆内存中 , 一个对象一份
    //占空间 , 而final修饰的变量是无法改变的 , 所以final修饰的变量一般添加static修饰 , 将这个变量变为类级别的变量 , 储存在方法区
}