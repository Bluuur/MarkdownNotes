# 控制语句

## 控制语句

控制语句的出现可以让我们的程序具有逻辑性/条理性，可以使用通过使用控制语句来实现一个“业务”

## 控制语句的分类

### 选择语句(分支语句)

#### if语句

#### switch语句

### 循环语句

只要循环反复执行某段特定的代码块

#### for语句

#### while语句

#### do{}while()语句

# 控制语句

## if语句的语法结构以及运行原理

if语句时分支语句，也可以叫做条件语句

### if语句的语法格式

#### 写法1：

```java
if(布尔表法式){
Java语句；
Java语句；
}
```

这里的一个大括号叫做一个分支
如果圆括号内的布尔表达式为true，则执行分支
如果圆括号内的布尔表达式为false，则不执行分支

#### 写法2：

```
if(布尔表达式){    //分支一
Java语句；
}else{            //分支二
Java语句；
}
```

如果圆括号内的布尔表达式为true，则实行分支一，分支二不执行
如果圆括号内的布尔表达式为false，则执行分支二，分支一不执行
以上语句可以保证一定有一个分支被执行

#### 写法3：

```java
if(布尔表达式1){        //分支一
	java语句；
}else if(布尔表达式2){    //分支二
	java语句；                
}else if(布尔表达式3){    //分支三
	java语句；
}else if(布尔表达式4){    //分支四
	java语句；    
}...
```

先判断布尔表达式1，如果布尔表达式1为true，则执行分支一，然后if语句结束
当布尔表达式1为false，则继续判断布尔表达式2的结果，如果布尔表达式2的结果是true，则执行分支二，然后if语句结束。以此类推

#### 写法4：

```java
if(布尔表达式1){		//分支一
    java语句；
}else if(布尔表达式2){	//分支二
    java语句；				
}else if(布尔表达式3){	//分支三
    java语句；
}else if(布尔表达式4){	//分支四
    java语句；	
}else{
    java语句；			//以上的条件均为false时执行
}
```

### <font color = "red">注意</font>

​	1.if语句不可能用两个及以上分支执行
​	
​	2.if语句中只要有一个分支被执行了，整个if语句就结束了
​	
​	3.凡是带有else的，一定能保证有一个分支被执行		
​	
​	4.当分支中“java语句”只有一条，大括号可以省略。但为了代码的可读性，最好不要省略

​	5.控制语句和控制语句之间是可以嵌套的

但是嵌套的时候最好一个语句一个语句进行分析，不要冗杂再一起分析

## switch语句

### 1.switch语句也是选择语句（分支语句）

### 2.switch语句的语法格式

```java
switch(值){
    case 值1:
        java语句;
        java语句;
        break;
    case 值2:
        java语句;
        java语句;
        break;
    case 值3:
        java语句;
        java语句;
        break;
    default:
        java语句;
}
```

>以上是一个完整的switch语句(<font color="blue">注</font>:case穿透)
>其中：break语句不是必须的，default分支也不是必须的

### switch语句支持的值

支持int类型以及String类型
但要注意JDK的版本，JDK8之前不支持String类型，只支持int
在JDK8之后，switch语句开始支持字符串类型

### switch语句的执行原理

+  switch后圆括号内的值，与case后的值1进行匹配，值与值进行匹配时，使用==进行比较

+  如果匹配，则执行该分支中的Java语句，遇到break停止（但break不是必须的）

+  <font color="blue">注意</font>，如果分支执行了，但是分支最后没有break语句，会发生case穿透现象> 

   

>  case穿透
>  当在switch语句中，执行case分支语句，如果满足case1，但是在case1的语句块中，没有加break;，即使case1，满足条件，程序仍然会向下执行case2，即使case2不满足条件，除非case2语句块中有break;，程序会跳出switch选择结构，否则继续执行case3，一直这样执行下去，直到整个switch语句全部执行完毕，才能结束

如果“值”与“值1”不匹配，则向后面的值匹配
	
如果所有的语句都不匹配，default分支就会执行

switch语句本质上是只支持int和String类型
但是byte，short，char也可以

因为在switch语句中，小容量会自动转换为大容量的int

```java
public class SwitchTest01{
	public static void main(String[] args){
		//以下代码报错：错误：不兼容的类型，long类型转换为int类型可能会有损失
		/*long x = 100;
		switch(){
		
		}
		强制类型转换可以通过编译（但可能会有精度损失）
		*/

		//以下代码不会报错，因为有自动类型转换(short，byte也可以)
		/*
		byte b = 100;
		switch(b){

		}
		*/
		
		//以下代码也不会报错（自动类型转换）
		/*
		char c = 'a';//c被转成了ASCII码对应的数字“97”
		switch(c){
			
		}
		*/

		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("请输入[0-6]的整数：");
		int num = s.nextInt();
		//case穿透
		switch(num){
			case 0:
				System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");

			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;

		
		switch(num){
			case 0:
				System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
		} 

		//default语句
		switch(num){
			case 0:
				System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
			default:
				System.out.println("你输入的数据不合法，请重新运行此程序并输入合法数据");
			
		}

		//case合并
		switch(num){
			case 0: case 7: case 8://这里合并了0，7，8.输入0，7，8都会执行此分支		System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
			default:
				System.out.println("你输入的数据不合法，请重新运行此程序并输入合法数据");
			
		}
	}
}
```

# 循环语句

## 关于循环语句

for循环

while循环

do…while循环

 

### 什么是循环语句，为什么要使用这种语句

因为在显示世界中，又很多事情都需要重复做
对应到程序中，如果有一块代码需要重复执行
为了减少代码量，我们使用循环语句

 <font color="red">**所有合法的控制语句都可以嵌套使用**</font>

 

### for循环的语法机制以及运行原理

for(初始化表达式; 布尔(条件)表达式; 更新表达式){
		循环体（由Java语句构成）;
}

>  注意：
>  第一：初始化表达式最先执，并且在整个循环中只执行一次
>  第二：条件表达式结果必须是一个布尔类型：true或false

初始化表达式\布尔表达式\更新表达式都不是必须的,可以缺失

#### 执行原理：

首先执行初始化表达式,然后执行条件表达式,如果为true则执行循环体,然后执行更新表达式
然后执行条件表达式,如果为true,执行循环体,以此循环,直到条件表达式结果为false跳出循环
更新表达式的作用是:控制循环的次数,换句话说,更新表达式会更新某个变量的值,这样条件表达式的结果才有可能从true变成false,从而终止for循环的执行,如果缺失更新表达式,很有可能会导致死循环

# 转向语句

```java
break:
	/*
	    break语句：
	        break是由一个单词构成的一个完整java语句
	        break只能用在两个地方
	            第一个位置:switch语句中,用来终止switch语句的执行
	            第二个位置:在循环语句中,用来终止循环的执行
	                for
	                while
	                do...while
	        break语句的执行不会让整个方法结束,只会让距离它最近的那一个循环语句结束
	 */
	
	public class BreakTest01 {
	    public static void main(String[] args) {
	        for(int i = 0; i < 10; i++){
	            if(i == 5){
	                //break语句会终止距离break最近的一个循环
	                break;
	            }
	            System.out.println("i = " + i);
	        }
	
	        //以下语法在实际开发中很少用到
	        //下面两个for魂环的嵌套中,如果想要里层for循环中的break语句结束外层的for循环,可以给每个循环起名字
	        a:for (int k = 0; k < 2; k++){
	            b:for (int i = 0; i < 10; i++){
	                if(i == 5){
	                    break a;//终止指定的循环
	                }
	                System.out.println(i);
	            }
	        }
	    }
	}

continue:
/*
    continue语句的作用:终止当前本次循环,直接进入下一循环

    与break一样,continue也可以指定循环
 */

public class ContinueTest01 {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++){
            if(i == 5){
                break;
            }
            System.out.println(i);
        }

        System.out.println("-----------------------------");

        for(int i = 0; i < 10; i++){
            if(i == 5){
                continue;//表示本次循环只会执行到此，continue语句后的程序不再执行，直接跳到下一次循环
            }
            System.out.println(i);
        }

    }
}


return:
//终止当前方法
```

