# static

什么时候变量声明为实例的，什么时候声明为静态的？
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
//    #重点
//      加static的变量叫做静态变量
//      静态变量在类加载时初始化，不需要new对象，静态变量的空间就开出来了
//      静态变量存储在方法区

    }
}


-------------------------------------------------------------------------------------------------------------------------------------
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

//    #重点
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
//    #重点
//      加static的变量叫做静态变量
//      静态变量在类加载时初始化，不需要new对象，静态变量的空间就开出来了
//      静态变量存储在方法区

    }
}


什么时候定义实例变量，什么时候定义静态变量
	实例变量
		每个对象的该属性不同，这个属性会因对象的改变而改变，需通过"对象."来访问
		
	静态变量
		一个类实例化出来的对象具有的某一相同属性，只要是这个类中实例化出来的对象，这一属性均相同
		则使用静态变量。
		虽然实例变量可以达到相同的效果，但是会占用更多内存，不建议使用实例变量，建议定义为类级别特征