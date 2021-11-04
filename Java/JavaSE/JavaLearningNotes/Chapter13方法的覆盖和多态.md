#  方法覆盖

## 什么时候进行方法覆盖

子类继承父类之后,当继承过来的方法无法满足当前子类的业务需求时,子类有权对这个方法进行重新编写,有必要进行方法覆盖

方法覆盖又叫方法重写,英文为override\overwrite

+  区分方法重载:
   当在一个代码中,如果功能类似的话,建议将名字定义的一样,这一样代码美观,方便编程
+  方法重载需要满足的条件
   +  在同一个类中
   +  方法名相同
   +  形式参列表不同(数量,顺序,种类)

## 如何方法覆盖

+  两个类具有继承关系
+  重写之后的方法必须和原方法具有
   +  相同的返回值类型
   +  相同的方法名
   +  相同的形式参数列表

+  访问权限不能更低,可以更高
+  重写之后的方法不能比之前的方法抛出更多的异常,可以更少

### 注:

>  +  方法覆盖只针对于方法,与属性无关
>  +  私有方法无法覆盖
>  +  构造方法不能被继承,所以构造方法也不能被覆盖
>  +  方法覆盖只是针对于示例方法,静态方法覆盖没有意义

# 多态

## 多态的基础语法

### 向上转型(upcasting)

子$\rightarrow$父

### 向下转型(downcasting)

父$\rightarrow$子（类似强制类型转换，需要加强制"类型转换符"）

如果需要调用或执行子类中特有的方法，必须进行向下转型，才可以调用

Java允许向上转型,也允许向下转型

无论是向上转型还是向下转型,两种类型之间必须有继承关系,没有继承关系编译器会报错

```java
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
        Cat x = (Cat)a5;
		x.catchMouse();

        //向下
    }
}

```

## 什么是多态

Java程序分为编译阶段和运行阶段

+  编译阶段
   +  对于编译器来说,编译器只知道a1的类型是Animal.所以编译器在检查语法的时候,回去Animal.class字节码文件中找move()  方法
   +  找到move()之后,绑定上move()方法,编译通过,<font color = "blue">静态绑定</font>成功(编译阶段属于静态绑定)

+  运行阶段
   +  运行阶段实际上在堆内存中创建的Java对象是Cat对象,所以move的时候,真正参与move对象的是Cat 
   +  所以运行阶段会动态执行Cat对象的move()方法,这个过程属于运行阶段绑定(运行阶段属于<font color="blue">动态绑定</font>)

**多态指的是：父类引用指向子类型对象**

包括编译阶段和运行阶段
编译阶段：绑定的时父类的方法
运行阶段：动态绑定子类型对象的方法
编译的时候编译器发现a的类型是Animal，所以编译器回去Animal类中找move()方法,找到了绑定,编译通过.但是运行的时候和底层堆内存中的世界对象有关
真正执行的时候会自动调用"堆内存中真是对象"的相关方法

```java
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

        

```

分析以下代码能否运行:

```java
        Animal a5 = new Cat();
//        a5.catchMouse();
```

运行前需要先看编译阶段
a5底层是cat对象
但是在编译阶段,编译器会在Animal类中找catchMouse方法,结果没有找到
所以静态绑定失败,语法错误
所以编译报错

如果想要强制实现a5.catchMouse()需要向下转型
    ((Cat)a5).catchMouse();

## 向下转型的风险

```java
Animal a6 = new Bird();
```


在编译阶段,a6静态绑定为Animal类型;运行时,a6的底层为Bird类型

对下面两行代码进行分析:
编译器检测到a6引用是Animal类型,而Cat类是继承Animal类的子类,可以向下转型
但是运行阶段,底层实际为bird类型的引用a6被转为Cat类型,而Cat与Bird类型之间没有继承关系
会出现异常:
Exception in thread "main" java.lang.ClassCastException: Bird cannot be cast to Cat

//        Cat y = (Cat)a6;
//        y.catchMouse();

### 如何避免ClassCastException异常的发生?

#### instanceof 运算符

+  instanceof运算符可以在运行阶段动态判断引用指向对象的类型
+  instanceof运算符的语法:
   +  (引用 instanceof 类型)
+  第三:instanceof运算符的结果只能是boolean类型
+  第四:
       (c instanceof Cat)为true表示
           c引用指向的对象是一个Cat类型
       (c instanceof Cat)为false表示
           c引用指向的对象是一个Cat类型

```java
//使用条件语句;
        if (a6 instanceof Cat){//如果a6是一只猫,则进行向下转型,这是java规范的要求
            Cat y = (Cat)a6;
            y.catchMouse();
        }
```



##　多态在开发中的作用

降低程序的耦合度，提高程序的扩展力



面向对象的三大特征:
	封装、继承、多态



```java
/*
    多态练习：
        编写程序模拟"主人"喂养"宠物"的场景
            要求:
                主人类:Master
                宠物类:Pet
                宠物类子类:Dog/Cat/Parrot
                主人应该由喂养的方法:feed()
                宠物应该有吃的方法:eat()
                只要主人喂宠物,宠物就吃
                主人类中只提供一个喂养方法feed(),要求可以喂养各种类型的宠物
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        Master zhuRen = new Master();
        Pet gouZi = new Dog();
        Pet maoZi = new Cat();
        Pet yingWu = new Parrot();
        zhuRen.feed(gouZi);
        zhuRen.feed(maoZi);
        zhuRen.feed(yingWu);
    }
}

class Master{
    public void feed(Pet pet){
        System.out.println("主人喂养了" + pet.toString());
        if(pet instanceof Dog){
            Dog d = (Dog) pet;
            d.eat();
        }else if (pet instanceof Cat){
            Cat c = (Cat) pet;
            c.eat();
        }else if (pet instanceof Parrot){
            Parrot p = (Parrot) pet;
            p.eat();
        }
    }
}

class Pet{
    public void eat(){
        System.out.println("宠物正在进食");
    }
}

class Dog extends Pet{
    @Override
    public void eat() {
        System.out.println("狗正在进食");
    }

    @Override
    public String toString() {
        return "狗";
    }
}

class Cat extends Pet{
    @Override
    public void eat() {
        System.out.println("猫正在进食");
    }

    @Override
    public String toString() {
        return "猫";
    }
}

class Parrot extends Pet{
    @Override
    public void eat() {
        System.out.println("鹦鹉正在进食");
    }

    @Override
    public String toString() {
        return "鹦鹉";
    }
}

```

## 静态方法不存在方法覆盖

```java
public class OverrideTest05 {
    public static void main(String[] args) {
        fatherC c = new sonC();//多态
        c.doSome();
    }
}

class fatherC{
    public static void doSome(){
        System.out.println("do some");
    }
}

class sonC extends fatherC{
    public static void doSome(){
        System.out.println("do some method from sonC");
    }
}

```

输出结果:

```java
do some

Process finished with exit code 0
```

没有起到方法覆盖的作用

虽然静态方法既可以采用"类名."的方式调用,也可以采用"引用."的方式调用
原因:<font color="blue">静态方法和对象无关</font>,因为静态方法不是对象级别的方法,实例方法才是对象级别的方法

静态方法的执行不需要对象,一般情况下,不探讨静态方法的覆盖

## 私有方法无法覆盖

```java
//私有方法不能覆盖
public class OverrideTest06 {
    private void doSome(){
        System.out.println("doSome from private method");
    }

    public static void main(String[] args) {
        OverrideTest06 t = new T();
        t.doSome();
    }
}

class T extends OverrideTest06{
    public void doSome(){//访问权限不能更低,可以更高
        System.out.println("doSome from extended  method");
    }
}

```

输出结果:

```
doSome from private method

Process finished with exit code 0
```

私有方法无法覆盖,私有方法只能在本类调用