# 控制语句

## 控制语句

控制语句的出现可以让我们的程序具有逻辑性/条理性，可以使用通过使用控制语句来实现一个“业务”

## 控制语句的分类

### 选择语句 (分支语句)

#### if 语句

#### switch 语句

### 循环语句

只要循环反复执行某段特定的代码块

#### for 语句

#### while 语句

#### do{}while() 语句

# 控制语句

## if 语句的语法结构以及运行原理

if 语句时分支语句，也可以叫做条件语句

### if 语句的语法格式

#### 写法 1：

```java
if(布尔表法式){
Java 语句；
Java 语句；
}
```

这里的一个大括号叫做一个分支
如果圆括号内的布尔表达式为 true，则执行分支
如果圆括号内的布尔表达式为 false，则不执行分支

#### 写法 2：

```
if(布尔表达式){    //分支一
Java 语句；
}else{            //分支二
Java 语句；
}
```

如果圆括号内的布尔表达式为 true，则实行分支一，分支二不执行
如果圆括号内的布尔表达式为 false，则执行分支二，分支一不执行
以上语句可以保证一定有一个分支被执行

#### 写法 3：

```java
if(布尔表达式 1){        //分支一
	java 语句；
}else if(布尔表达式 2){    //分支二
	java 语句；                
}else if(布尔表达式 3){    //分支三
	java 语句；
}else if(布尔表达式 4){    //分支四
	java 语句；    
}...
```

先判断布尔表达式 1，如果布尔表达式 1 为 true，则执行分支一，然后 if 语句结束
当布尔表达式 1 为 false，则继续判断布尔表达式 2 的结果，如果布尔表达式 2 的结果是 true，则执行分支二，然后 if 语句结束。以此类推

#### 写法 4：

```java
if(布尔表达式 1){		//分支一
    java 语句；
}else if(布尔表达式 2){	//分支二
    java 语句；				
}else if(布尔表达式 3){	//分支三
    java 语句；
}else if(布尔表达式 4){	//分支四
    java 语句；	
}else{
    java 语句；			//以上的条件均为 false 时执行
}
```

### <font color = "red"> 注意 </font>

​	1.if 语句不可能用两个及以上分支执行
​	
​	2.if 语句中只要有一个分支被执行了，整个 if 语句就结束了
​	
​	3.凡是带有 else 的，一定能保证有一个分支被执行		
​	
​	4.当分支中“java 语句”只有一条，大括号可以省略。但为了代码的可读性，最好不要省略

​	5.控制语句和控制语句之间是可以嵌套的

但是嵌套的时候最好一个语句一个语句进行分析，不要冗杂再一起分析

## switch 语句

### 1.switch 语句也是选择语句（分支语句）

### 2.switch 语句的语法格式

```java
switch(值){
    case 值 1:
        java 语句;
        java 语句;
        break;
    case 值 2:
        java 语句;
        java 语句;
        break;
    case 值 3:
        java 语句;
        java 语句;
        break;
    default:
        java 语句;
}
```

> 以上是一个完整的 switch 语句 (<font color="blue"> 注 </font>:case 穿透)
> 其中：break 语句不是必须的，default 分支也不是必须的

### switch 语句支持的值

支持 int 类型以及 String 类型
但要注意 JDK 的版本，JDK8 之前不支持 String 类型，只支持 int
在 JDK8 之后，switch 语句开始支持字符串类型

### switch 语句的执行原理

+  switch 后圆括号内的值，与 case 后的值 1 进行匹配，值与值进行匹配时，使用==进行比较

+  如果匹配，则执行该分支中的 Java 语句，遇到 break 停止（但 break 不是必须的）

+  <font color="blue"> 注意 </font>，如果分支执行了，但是分支最后没有 break 语句，会发生 case 穿透现象> 

   

>  case 穿透
>  当在 switch 语句中，执行 case 分支语句，如果满足 case1，但是在 case1 的语句块中，没有加 break;，即使 case1，满足条件，程序仍然会向下执行 case2，即使 case2 不满足条件，除非 case2 语句块中有 break;，程序会跳出 switch 选择结构，否则继续执行 case3，一直这样执行下去，直到整个 switch 语句全部执行完毕，才能结束

如果“值”与“值 1”不匹配，则向后面的值匹配
	
如果所有的语句都不匹配，default 分支就会执行

switch 语句本质上是只支持 int 和 String 类型
但是 byte，short，char 也可以

因为在 switch 语句中，小容量会自动转换为大容量的 int

```java
public class SwitchTest01{
	public static void main(String[] args){
		//以下代码报错：错误：不兼容的类型，long 类型转换为 int 类型可能会有损失
		/*long x = 100;
		switch(){
		
		}
		强制类型转换可以通过编译（但可能会有精度损失）
		*/

		//以下代码不会报错，因为有自动类型转换 (short，byte 也可以)
		/*
		byte b = 100;
		switch(b){

		}
		*/
		
		//以下代码也不会报错（自动类型转换）
		/*
		char c = 'a';//c 被转成了 ASCII 码对应的数字“97”
		switch(c){
			
		}
		*/

		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("请输入[0-6] 的整数：");
		int num = s.nextInt();
		//case 穿透
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

		//default 语句
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

		//case 合并
		switch(num){
			case 0: case 7: case 8://这里合并了 0，7，8.输入 0，7，8 都会执行此分支		System.out.println("星期日");
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

for 循环

while 循环

do…while 循环

 

### 什么是循环语句，为什么要使用这种语句

因为在显示世界中，又很多事情都需要重复做
对应到程序中，如果有一块代码需要重复执行
为了减少代码量，我们使用循环语句

 <font color="red">**所有合法的控制语句都可以嵌套使用**</font>

 

### for 循环的语法机制以及运行原理

for(初始化表达式; 布尔 (条件) 表达式; 更新表达式){
		循环体（由 Java 语句构成）;
}

>  注意：
>  第一：初始化表达式最先执，并且在整个循环中只执行一次
>  第二：条件表达式结果必须是一个布尔类型：true 或 false

初始化表达式\布尔表达式\更新表达式都不是必须的,可以缺失

#### 执行原理：

首先执行初始化表达式,然后执行条件表达式,如果为 true 则执行循环体,然后执行更新表达式
然后执行条件表达式,如果为 true,执行循环体,以此循环,直到条件表达式结果为 false 跳出循环
更新表达式的作用是:控制循环的次数,换句话说,更新表达式会更新某个变量的值,这样条件表达式的结果才有可能从 true 变成 false,从而终止 for 循环的执行,如果缺失更新表达式,很有可能会导致死循环

# 转向语句

```java
break:
	/*
	    break 语句：
	        break 是由一个单词构成的一个完整 java 语句
	        break 只能用在两个地方
	            第一个位置:switch 语句中,用来终止 switch 语句的执行
	            第二个位置:在循环语句中,用来终止循环的执行
	                for
	                while
	                do...while
	        break 语句的执行不会让整个方法结束,只会让距离它最近的那一个循环语句结束
	 */
	
	public class BreakTest01 {
	    public static void main(String[] args) {
	        for(int i = 0; i < 10; i++){
	            if(i == 5){
	                //break 语句会终止距离 break 最近的一个循环
	                break;
	            }
	            System.out.println("i = " + i);
	        }
	
	        //以下语法在实际开发中很少用到
	        //下面两个 for 魂环的嵌套中,如果想要里层 for 循环中的 break 语句结束外层的 for 循环,可以给每个循环起名字
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
    continue 语句的作用:终止当前本次循环,直接进入下一循环

    与 break 一样,continue 也可以指定循环
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
                continue;//表示本次循环只会执行到此，continue 语句后的程序不再执行，直接跳到下一次循环
            }
            System.out.println(i);
        }

    }
}


return:
//终止当前方法
```

