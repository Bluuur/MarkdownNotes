/*
    什么时候变量声明为实例的，什么时候声明为静态的？
 */
public class StaticTest02 {
    public static void main(String[] args) {
        homoSapines man = new homoSapines("42011x-xxxxxxxx-xxxx", "张三", "human");
    }
}

class homoSapines{
    //身份证号
    String idNum;//每个对象的的身份证号不同，应该通过对象去访问，是实例变量
    //姓名
    String name;//每个对象的姓名不同，应该通过对象访问，是实例变量
    //国籍
    String species;//这个类的species是homoSpaines，这个类创建的对象的此属性相同
    //所以这里的species不是对象级别的特征，属于整个类的特征

    public homoSapines() {
    }

    public homoSapines(String idNum, String name, String species) {
        this.idNum = idNum;
        this.name = name;
        this.species = species;
//    static String nationality = "human";
//    #重点#
//      加static的变量叫做静态变量
//      静态变量在类加载时初始化，不需要new对象，静态变量的空间就开出来了
//      静态变量存储在方法区

    }
}
