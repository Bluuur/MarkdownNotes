public class Test001 {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.move();

        Cat c1 = new Cat();
        c1.move();

        Bird b1 = new Bird();
        b1.move();

        //代码能这样写吗?
        /*
            Animal和Cat之间有继承关系
            Animal是父类,Cat是子类
            Cat is an Animal
         */
        Animal a2 = new Cat();
        a2.move();
        //上面两行代码中:
        //编译阶段:编译器在Animal字节码文件中寻找move方法,找到了,编译通过
        //运行阶段:由于a2底层是一个cat对象,所以最终会执行cat的move方法

        //分析以下代码能否运行:
        Animal a5 = new Cat();
//        a5.catchMouse();
        //运行前需要先看编译阶段
        //a5底层是cat对象
        //但是在编译阶段,编译器会在Animal类中找catchMouse方法,结果没有找到
        //所以静态绑定失败,语法错误
        //所以编译报错

        //如果想要强制实现a5.catchMouse()需要向下转型
        ((Cat)a5).catchMouse();

        //向下转型由风险吗
        Animal a6 = new Bird();
        //在编译阶段,a6静态绑定为Animal类型;运行时,a6的底层为Bird类型

        /*
            对下面两行代码进行分析:
                编译器检测到a6引用是Animal类型,而Cat类是继承Animal类的子类,可以向下转型
                但是运行阶段,底层实际为bird类型的引用a6被转为Cat类型,而Cat与Bird类型之间没有继承关系
                会出现异常:
                    Exception in thread "main" java.lang.ClassCastException: Bird cannot be cast to Cat
         */
//        Cat y = (Cat)a6;
//        y.catchMouse();

        //如何避免ClassCastException异常的发生?
        /*
            instanceof运算符:
                第一:instanceof运算符可以在运行阶段动态判断引用指向对象的类型
                第二:instanceof运算符的语法:
                    (引用 instanceof 类型)
                第三:instanceof运算符的结果只能是boolean类型
                第四:
                    (c instanceof Cat)为true表示
                        c引用指向的对象是一个Cat类型
                    (c instanceof Cat)为false表示
                        c引用指向的对象是一个Cat类型
         */
        //使用条件语句;
        if (a6 instanceof Cat){//如果a6是一只猫,则进行向下转型,这是java规范的要求
            Cat y = (Cat)a6;
            y.catchMouse();
        }
    }
}
