# Object类

`Object`类是所有类的父类,这个类中的方法都是子类通用的,任何一个类默认继承`Object`类; 就算没有直接继承,也有间接继承

## API

应用程序接口
整个JDK的类库就是一个JavaSE的API

每个API都会配置一个API帮助文档

# Object类中的重要方法

## toString ()方法

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

源代码中toString()方法的默认实现是
	`类名@对象的内存地址转换成十六进制的形式`

### SUN公司设计toString()方法的目的

通过调用`toString()`方法,可以将一个`java对象`转换成`字符串表示形式`

#### 帮助文档中的描述:

>返回该对象的字符串表示。通常，toString 方法会返回一个“以文本方式表示”此对象的字符串。结果应是一个<u>简明但易于读懂的信息表达式</u>。**建议所有子类都重写此方法。** 
>Object 类的 toString 方法返回一个字符串，该字符串由类名（对象是该类的一个实例）、at 标记符“@”和此对象哈希码的无符号十六进制表示组成。换句话说，该方法返回一个字符串，它的值等于： 
>`getClass().getName() + '@' + Integer.toHexString(hashCode())`



输出引用的时候,会自动调用该引用的toString()方法
`System.out.println([引用]);`

## euqals()方法

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

### SUN公司设计euqals()方法的目的

通过`equals()`方法判断两个对象(引用数据类型)是否相等

>  不能通过`==`比较两个对象是否相等,因为`==`比较的是两个对象的内存地址

在`Object`类中默认的`equals()`方法使用的是`==`比较,所以一般在所写的类中,`equals()`<u>方法也需要重写</u>

重写应该让两个对象之间进行内容的比较

```java
public class MyTime {
    private int year;
    private int month;
    private int day;

    public MyTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object obj) {//这里必须要向下转型(多态),因为重写方法,不能改动形式参数列表
        if(obj == null || !(obj instanceof MyTime)){//如果传入的对象为null,直接返回false;如果传入的对象不是MyTime类型,直接返回false
            return false;
        }

        if(obj == this){//如果传入的对象是它本身,直接返回true
            return true;
        }

        //obj是MyTime的父类,向下转型
        MyTime mt = (MyTime) obj;
        return this.year == mt.year && this.month == mt.month && this.day == mt.day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

```

>  以上覆盖的方法可以在IDEA中直接生成



>  注意:
>
>  重写`equals()`方法时要彻底

## finalize()方法(非重点)

```java
protected void finalize() throws Throwable { }
```

`finalize()`方法只有一个方法体,里面没有代码.这个方法是`protected`修饰的

这个方法重写后不需要手动调用,JVM的垃圾回收器负责调用这个方法
当一个Java对象即将被垃圾回收器回收的时候,垃圾回收器会调用`finalize()`方法

`finalize()`方法实际上是SUN公司为Java程序员准备的一个时机,垃圾销毁时机
如果希望在对象销毁实际执行一段代码的话,这段代码要写到`finalize()`方法中
类似静态代码块

>  静态代码块在类加载时执行,并且只执行一次;这是SUN准备的类加载时机

这个方法可以在对象被JVM 释放的时候,记录释放时间

>  `finalize()`方法在对象释放的时候不一定会执行,因为垃圾较少的时候垃圾回收器不会启动
>
>  可以使用`System.gc()`建议垃圾回收器启动

## hashCode()方法

```java
public native int hashCode();
```

这个方法不是抽象方法,带有`native`关键字,底层调用C++程序	

`hashCode()`方法返回的时哈希码,实际上是一个Java对象经过哈希算法,得出的一个值.可以认为`hashCode()`方法执行的结果看作一个Java对象的内存地址	



# 匿名内部类

## 内部类

在类的内部又定义一个新的类,称内部类

## 内部类的分类

### 静态内部类

类似静态变量

### 实例内部类

类似实例变量

### 局部内部类

类似局部变量

```java
public class InnerClassTest01 {
    static class Inner01{//静态内部类

    }

    class Inner02{//实例内部类

    }

    public void doSome(){

        class Inner03{//局部内部类

        }
        
    }
}

```

>  **注意**
>  使用内部类编写的代码可读性很差,能不用尽量不用

## 匿名内部类

匿名内部类时局部内部类的一种

多用于接口的实现(如多线程,实现runnable)