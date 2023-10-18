# this

+  this是一个关键字，是一个引用，保存内存地中指向自身
+  this额可以使用在实例方法中，也可以使用在构造方法中
+  this出现在示例方法中，代表的是当前对象
+  this不能使用挂在静态方法中
+  this. 大部分情况下可以省略，但是用来区分局部变量和示例变量的时候不能生省略
+  this() 这种语法只能出现在构造方法的第一行，表示当前构造方法调用本列其他的构造方法，目的是代码复用

# 继承extends

## 继承的定义和作用

### 继承的作用

+  基本作用：子类继承父类，代码可以得到复用
+  主要作用：有了继承关系，才有了后期的方法覆盖和多态机制性

### 继承的相关特性

+  B类继承A类，则称A类为超类(superclass)、父类、基类；B类称为子类(subclass)、派生类、扩展类

+  Java中的继承只支持单继承，不支持多继承；C++中支持多继承，这也是Java体现简单性的一点，换句话说，Java中不允许这样写代码：

   ```java
   class B extends A,C{
       
   }
   ```

+  虽然Java中不支持多继承，但有的时候会产生间接继承的效果。例如：class C extends B，class B extends A，也就是说C直接继承B，其实C还要间接继承A

+  Java中规定，子类继承父类，除构造方法不能继承外，剩下的都可以继承，但是私有的属性无法在子类中直接访问（父类中private修饰的不能在子类中直接访问，可以通过间接的手段访问（set和get方法））

+  Java中的类没有显示的继承任何类，则默认继承Object类，Object类是Java语言提供的根类，也就是说，一个对象与生俱来就具有Object类型中所有的特征

+  继承也存在一些缺点，例如CreditAccount类继承Account类会带之它们之间的耦合度非常高，Account类发生改变之后会马上影响到CreditAccount类

## 子类对象调用父类方法 ExtendsTest03.java

本质上，子类继承父类之后，是将父类继承过来的方法归为自己所有，实际上调用的不是父类的方法，是子类自己的方法 

```java
public class ExtendsTest03 {
    public static void main(String[] args) {
        //创建子类对象
        Cat c = new Cat();
        //调用方法
        c.move();
    }
}

class Animal{
    //名字
    String name = "XiaoHei";//默认值 
    //提供一个动物移动的方法
    public void move(){
        System.out.println(name + "正在移动");
    }
}

//Cat子类
//Cat继承Anima，会将Animal中所有的属性全部继承过来
class Cat extends Animal{

}

```

## 什么时候使用继承

凡是能够采用"is a"描述的,都可以继承
例如:
Cat is an animal
CreditAccount is an Account等



## Object类的方法

任何一个类,没有显示 继承任何类,默认继承Object,

对于代码:
System.out.println("hello world")
System.out中,out后没有小括号,说明out是变量名,System是一个类名
直接使用类名System.out说明out是一个静态变量
System.out返回一个对象,然后采用"对象."的方式访问println()方法

```java

public class Object {
	//注意:当源码中一个方法以";"结尾,并且修饰符列表中有"native"关键字
    //表示底层调用C++写的dll程序(dll动态连接库文件)
    private static native void registerNatives();
    //静态代码块(在类加载时执行,且只执行一次)
    static {
        //调用registerNatives方法 
        registerNatives();
    }

 
    public final native Class<?> getClass();

    public native int hashCode();
   
    public boolean equals(Object obj) {
        return (this == obj);
    }

   	//已有对象a,想要创建一个和a一摸一样的对象,可以调用这个clone方法
   	//底层也是调用C++
    protected native Object clone() throws CloneNotSupportedException;
  	
    //适用对象调用此方法,会返回一串十六进制数,如1b6d3586
    //这是内存地址经过"哈希算法"得出的十六进制结果
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public final native void notify();

    public final native void notifyAll();

    public final native void wait(long timeout) throws InterruptedException;

    public final void wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException(
                                "nanosecond timeout value out of range");
        }

        if (nanos > 0) {
            timeout++;
        }

        wait(timeout);
    }

    public final void wait() throws InterruptedException {
        wait(0);
    }

    protected void finalize() throws Throwable { }
}

```



