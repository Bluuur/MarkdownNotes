

# 抽象类

## 什么是抽象类

先看对象:将多个对象之间的共同练习总结起来,对对象进行抽象,得到类. 类是现实世界中不存在的,是人类大脑思考总结的结果

如果将各个类进行抽象总结,将具有共同特征的类再进一步抽象 , 就形成了抽象类. 因为类在现实世界中不存在的,所以抽象类无法被实例化

抽象类之间可能存在共同与特征,可以被进一步抽象
抽象类的子类可以是抽象类

抽象类虽然无法实例化,但是有构造方法
因为一个类被继承的时候,子类会去调用父类的构造方法

## 抽象类属于什么类型

抽象类属于引用数据类型

## 抽象类怎么定义

语法:	

```
[修饰符列表]  abstract class 类名{
	类体
}
```



>  抽象类无法实例化,无法创建对象,所以抽象类是用来被子类继承的
>
>  所以abstract和final不能同时出现:abstract类是用来被继承的,final修饰的类是无法被继承的



# 抽象方法

抽象方法表示没有实现的方法，没有方法体的方法

## 抽象方法的特点

+  没有方法体,以分号结尾
+  修饰符列表中有abstract 

一个非抽象的类继承抽象类,必须将抽象类中的抽象方法实现

```java
public class AbstractTest02 {
    public static void main(String[] args) {
        DongWu n = new Niao();//父类是抽象类
        n.move();//可以使用多态
        //面向抽象编程
    }
}

abstract class DongWu{
    public abstract void move();
}

class Niao extends DongWu{
    //子类会将抽象父类中的抽象方法继承过来
    //如果子类不是抽象类,那么必须将从父类中继承过来的抽象方法重写(实现)
    @Override
    public void move() {
        System.out.println("move method");
    }
}
```

>  面向抽象编程,而不面向具体编程
>  降低程序的耦合度,提高程序的扩展力
>  这种编程思想符合OCP原则

>  没有方法体的方法不都是抽象方法
>
>  >  带有native关键字,调用C++底层的代码也没有方法体

# 接口

接口也是一种应用数据类型
接口是完全抽象的(抽象类是半抽象),或者说接口是特殊的抽象类

## 定义接口

```
[修饰符列表] interface 接口名{

}
```



接口编译之后也是.class文件

## 接口支持多继承

一个接口可以继承多个和接口(支持多继承)

## 接口只包含两部分内容

+  常量

+  抽象方法

>  接口中所有的元素都是public修饰的
>
>  接口中的抽象方法定义时public abstract修饰符可以省略
>  常量的public static final修饰符也可以省略
>
>  接口中的方法都是抽象方法,不能有方法体



## 接口在开发中的作用

类和类之间的关系叫继承,类和接口之间的关系叫实现
继承使用extends关键字完成
实现使用implements关键字完成

一个类可以同时实现多个接口

```java
public class C16Test02 {
}

interface A{
    void m1();
}

interface B{
    void m2();
}

interface C{
    void m3();
}

class MyClass implements A,B,C{
    //一个类可以实现多个接口
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}
```

>  Java只支持单继承.实际上单继承是为了简单而出现的
>  Java通过接口弥补了单继承带来的缺陷 

+  接口和接口之间不管有没有继承关系,都可以向下转型,编译器不会报错
   但是运行时可能会出现ClassCastException.

# 继承和实现都存在

extends关键字在前,implements关键字在后



>  import
>
>  `import java.lang.*;` 不会影响程序的执行效率,因为编译器在编译的时候会将`*`替换成需要导入的类,而不是将包下的类全部导入,但是不能每个位置使用`*`代替,因为`*`只能代替部分类