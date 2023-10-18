# final关键字

final是Java中的一个关键字
final表示最终的,不可变的
final可以修饰变量、方法、类

## final修饰的变量

final修饰的局部变量,只能赋一次值

### final修饰的引用

final修饰的变量如果是一个引用,那么这个引用保存的内存地址不能改变
也就是说,这个引用只能指向该对象,无法指向其他对象(包括改变为null空指针)
在这个引用所在的方法结束之前,这个对象都不会被垃圾回收器回收

### final修饰的实例变量

final修饰的实例变量在创建时如果没有手动赋值 , 那么这个实例变量不会被赋上默认值 , 编译不会通过,

实例变量在构造方法执行的时候赋值(new)

```java
public class FinalTest01 {
    public static void main(String[] args) {

    }
}

class User{
//    final double Height = 1.8;//
    final double height;//这里没有赋值,而是在构造方法中赋值
    //这样是没有问题的,和赋默认值一样,赋值的过程发生在new对象调用构造方法的时候
    //在下面的构造方法中手动赋了值,程序是可以正常运行的,但是如果在下面的构造方法中没有手动赋值
    //是不会有自动的默认赋值的,因为final修饰的变量只能赋值一次,系统不会用掉这个唯一一次的赋值
    public User() {
        this.height = 1.8;
    }
}
```

>  final修饰的变量,必须手动赋值

## final修饰的方法

final修饰的方法无法被覆盖

## final修饰的类

final修饰的类无法被继承

## 常量

```java
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
```

static final联合修饰的变量称为常量,字母全部大写,单词间使用"_"下划线连接

常量一般是公开的,因为无法被修改

