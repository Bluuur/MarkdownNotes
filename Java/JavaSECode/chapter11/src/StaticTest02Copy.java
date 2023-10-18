/*
    什么时候变量声明为实例的，什么时候声明为静态的？
 */
public class StaticTest02Copy {
    public static void main(String[] args) {
        Chinese c1 = new Chinese("42011x-xxxxxxxx-xxxx", "张三");
        System.out.println(c1.idNum);
        System.out.println(c1.name);
        Chinese c2 = new Chinese("42011y-yyyyyyyy-yyyy", "李四");
        System.out.println(c2.idNum);
        System.out.println(c2.name);
    }
}

class Chinese{
    //身份证号
    String idNum;//每个对象的的身份证号不同，应该通过对象去访问，是实例变量
    //姓名
    String name;//每个对象的姓名不同，应该通过对象访问，是实例变量
    //国籍
    static String nationality = "China";
    //这个类的nationality都是China，这个类创建的对象的此属性相同
    //所以这里的nationality不是对象级别的特征，属于整个类的特征

//    #重点#
//      加static的变量叫做静态变量
//      静态变量在类加载时初始化，不需要new对象，静态变量的空间就开出来了
//      静态变量存储在方法区
//      在方法区的Chinese.class中，关联了一块名为nationality的内存区域，储存"China"
//      因此，想要访问此变量，必须通过”类名.“

    public Chinese() {
    }

    public Chinese(String idNum, String name) {
        this.idNum = idNum;
        this.name = name;
//    #重点#
//      加static的变量叫做静态变量
//      静态变量在类加载时初始化，不需要new对象，静态变量的空间就开出来了
//      静态变量存储在方法区

    }
}
