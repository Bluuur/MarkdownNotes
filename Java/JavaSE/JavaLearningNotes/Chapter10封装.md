# 面向对象的三大特征

**封装**
**继承**
**多态**

先后顺序
		先封装，才能继承，才能多态

# 封装概念与作用

手机、笔记本电脑等，都是封装在壳里的
封装起来，保护内部的部件是安全的
封装之后，对于使用者来说，看不见内部的结构
使用者也不用关心内部有多复杂，只需要操作“壳”上的按钮即可

## 封装的作用

+  保证内部结构的安全

+  屏蔽复杂，暴露简单

 

**在代码级别上，封装的作用**

一个类体中的数据，封装之后，对于代码的调用人员来说，不需要关心代码中的复杂实现，只需要通过一个简单的入羊口就可以访问了，另外，类体中安全级别较高的数据封装起来，外部人员不能随意访问，来保证数据的安全性

 

## 封装的代码实现

第一步：属性私有化（使用pribate关键字进行修饰）

第二步：对外提供简单的操作入口：get和set方法，其中set可以设置关卡

--------------------------------------
```java
/*
Person表示人类
每一个人都有奈年龄这样的属性
年龄age，int类型

不进行封装，Person类的age属性对外暴露，可以在外部程序中随意访问，导致了不安全
可以通过封装解决这个问题
*/

//这是没有封装的Person
/*
public class Person{
//实例变量（属性）
int age; //age属性是暴露的，在外部程序可以随意访问。导致了不安全
}
*/
//不使用封装机制，程序有什么缺点

//尝试封装一下
//不再对外暴露复杂的数据，封装一下
//对外只提供简单的操作入口
//优点：数据安全了，调用者也方便了
public class Person{
  //private表示私有的，被这个关键字修饰以后，该数据只能在本类中访问
  //离开了类体，age属性就无法访问
  private int age;

  //对外提供简单的访问入口
  //外部程序只能通过调用以下代码来完成访问
  //思考：应该对外提供几个访问入口
  //这些操作入口是否应该是方法？
  //写一个方法专门来完成读（get）
  //写一个方法专门来完成写（set）
  //get和set方法应不应该带有static？是定义为实例方法，还是普通方法
  //实例方法，通过get和set是要对对象的实例变量进行操作
  //因此，封装的第二步：对外提供公开的set方法和get方法作为操作入口（都是实例方法）
  /*
  [修饰符列表] 返回值类型 方法名（形参列表）{
  }
   */

  //get方法
  public int getAge() {
    return age;
  }

  //set方法
  public void setAge(int age) {
    //在这里设置关卡，以访输入的值不合法
    if (age < 0 || age > 150){
      System.out.println("输入的年龄不合法");
      return;
    }
    this.age = age;
  }
```

**注意：**
Java开发规范中有要求，set方法和get方法要按满足以下格式
	get方法的要求
		public 返回值类型 get+属性首字母大写（无参）{
		}

​	set方法的要求
​		public void set+属性名首字母大写（有1个参数）{
​		}



```java
//在外部程序中访问Person这个类型中的数据
public class PersonTest{
public static void main(String[] args){
        //创建Person对象
        Person = new Person();
        //访问一个对象的属性，通常包括两种操作
        //一种是读数据，一种是写数据
        //读数据
        System.out.println(p1.age);//读（get，表示获取）

        //修改数据（set，表示修改/设置）
        p1.age = 50;

		//再次读取
		System.out.println(p1.age);

        //在PersonTest这个外部程序中，目前是可以随意对age属性进行操作
        //一个人的年龄值不因该为负数
        //程序中给年龄赋值了一个负数，按说是不符合业务要求的
        //这就是程序的一个bug
		p1.age = -100;
		System.out.println("您的年龄是：" + p1.age);//读
	}    
}
```

```java
public class PersonTest01{
public static void main(String[] args){
        Person的age，彻底在外部不能访问量，这有点太安全了
        如果age属性不能访问，程序的意义就不大了
        //创建对象
        Person p1 = new Person();

        //读取age属性的值
        System.our.print(p1.age);

        //修改属性的值
        p1.age = -100;

        //访问age
        System.out.println(p1.age);
	}
}
```

# 实例方法

实例方法在栈中压栈，只要是方法，都在栈中压栈

带有static，没有static方法分别怎么调用

+  带有static的方法怎么调用
+  通过<类名.方法名>的方式访问

对象被称为实例
	实例相关的有：实例变量、实例方法
		实例变量是对象变量，实例方法是对象方法
		实例相关的都需要先使用new运算符创建对象, 通过"引用."的方法去访问

```java
public class MethodTest{
public static void main(String[] args){
        MethodTest.doSome();
        //在同一个类中，前面的类名可以省略
        doSome();
        //尝试使用"类名."的方法范围跟实例方法
        //        MethodTest.doOther();//错误：无法从静态上下文中引用非静态方法

        //创建对象
        MethodTest mt = new MethodTest();
        //通过“引用.”的方式去访问实例方法
        mt.doOther();

        }

        //带有static
        public static void doSome(){
        System.out.println("Do some!!");
        }

        //这个方法没有static
        //这个方法被称为实例方法（对象级别的方法）
        public void doOther(){
        System.out.println("do other");
	}
}
```


