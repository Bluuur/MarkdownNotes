# 算数运算符

| 符号 | 意义  |
| ---- | ----- |
| +    | 求和  |
| -    | 求差  |
| *    | 求积  |
| /    | 求商  |
| %    | 求模  |
| ++   | 自加1 |
| --   | 自减1 |

多种数据类型进行运算时，先转换成最大数据类型再做运算

>  >  | 类型    | 占用字节数量 |
>  >  | ------- | ------------ |
>  >  | byte    | 1            |
>  >  | Short   | 2            |
>  >  | int     | 4            |
>  >  | long    | 8            |
>  >  | float   | 4            |
>  >  | double  | 8            |
>  >  | boolean | 1            |
>  >  | char    | 2            |

<font color = "red">对于自加/自减运算来说:</font>

```java
public class OperatorTest01{
	public static void main(String[] args){
		int a = 10;
		int b = 3;
		System.out.println(a + b);//13
		System.out.println(a - b);//7
		System.out.println(a * b);//30
		System.out.println(a / b);//3
		System.out.println(a % b);//1

		//自加1
		int i = 10;
		i++;	//++可以出现在变量前，也可以出现在变量后
		System.out.println(i);	//11

		//语法：当++出现在变量后时，先做赋值运算，再自加1
		int m = 10;
		int n = m++;
		System.out.println(n);//10
		System.out.println(m);//11

		//语法：当++出现在变量前时，先自加1，再做赋值运算
		int p = 20;
		int q = ++p;
		System.out.println(q);//21
		System.out.println(p);//21

		//more practice
		int c = 90;
		System.out.println(c++);//这里有一个“隐形”的赋值运算
		//上行代码可由拆解为：
		//int temp = c++;
		//System.out.println(temp);
		System.out.println(c);//91

		int d = 80;
		System.out.println(++d);//同上，这里输出81
		System.out.println(d);//81
	}
}
```

```java
public class HomeWork01{
	public static void main(String[] args){
		int i = 10;
		i = i++;
		System.out.println(i);
		/*
			设立输出的结果是10，而不是11
			首先，第一点：这种代码不会有人写
			其次，第二点：没必要讨论这个问题，因为在C++中运行的结果确实是11
			Java中运行的结果是10
			C++中运行的结果是11
			是因为Java和C++的编译器是不同的人开发的，原理不同
		*/

		//在Java语言中，i++这种表达式在执行的时候，会提前将i变量找一个临时变量储存
		//C++中并没有这样做
		int k = 10;
		k = k++;
		//在k = k++;这一步中，实际进行了以下过程：
		//int temp = k;
		//k++;
		//k = temp;
		System.out.println(i);

	}
}
```

# 关系运算符

| 符号 | 意义             |
| ---- | ---------------- |
| >    | 判断是否大于     |
| >=   | 判断是否大于等于 |
| <    | 判断是否小于     |
| <=   | 判断是否小于等于 |
| ==   | 判断是否等于     |
| !=   | 判断是否不等于   |

>所有的关系运算符的运算结果都是布尔类型
>不是true就是false，不可能是其他值

<font color="blue">在Java中</font>

| 符号 | 意义                     |
| ---- | ------------------------ |
| =    | 赋值运算符               |
| ==   | 关系运算符  判断是否相等 |

>注意：关系运算符中如果有两个符号的话，两个符号之间不能有空格

```java
public class OperatorTest02{
	public static void main(String[] args){
		int a = 10;
		int b = 10;
		System.out.println(a > b);	//false
		System.out.println(a >= b);	// ture
		System.out.println(a < b);	//false
		System.out.println(a <= b);	//ture
		System.out.println(a == b);	//ture
		System.out.println(a != b);	//false
	}
}
```

# 赋值运算符

赋值运算符包括"基本赋值运算符"和"扩展赋值运算符"

## 基本赋值运算符

| 基本赋值运算符 |
| -------------- |
| =              |

+  "="右边表达式优先级更高，右边表达式先执行，执行完后的结果赋值给=左边

## 扩展赋值运算符

| 扩展赋值运算符 |
| -------------- |
| +=             |
| -+             |
| *=             |
| /=             |
| %=             |
| $\cdots$       |

>注意：扩展赋值运算符在编写的时候，两个符号之间不能有空格

**使用扩展赋值运算符时，不会改变运算结果类型**

>可以认为：x += 1等同于x = (byte)(x + 1)
>所以在使用扩展赋值运算符时，有可能损失精度

# 逻辑运算符

| 符号 | 名称   | 意义     | 备注                             |
| ---- | ------ | -------- | -------------------------------- |
| $    | 逻辑与 | （并且） | 只要有一边是false，结果就是false |
| \|   | 逻辑或 | （或者） | 只要有一边是true，结果就是true   |
| !    | 逻辑非 | （取反） |                                  |
| $$   | 短路与 |          |                                  |
| \|\| | 短路或 |          |                                  |

>  <font color="blue">注意:</font>
>  **逻辑运算符两边要求都是布尔类型**，并且最终的运算结果也是布尔类型
>  [ture] \$ [ture]$\rightarrow$ ture

```java
public class OperatorTest03{
	public static void main(String[] args){
		System.out.println(true & true);//true
		System.out.println(true & false);//false
		System.out.println(false & false);//false

		System.out.println(100 > 90 & 100 > 101);//false

		int a = 100;
		int b = 101;
		int c = 90;
		System.out.println(a < b | c > b);//(true|false)输出true
		System.out.println(true | false);//true
		System.out.println(true | true);//true
		System.out.println(false | false);//false

		System.out.println(!false);//true
		System.out.println(!true);//false

		//注意：这里要加小括号
		System.out.println(!(a > b));//true


		System.out.println(true & true);//true
		System.out.println(true & false);//false
		System.out.println(false & false);//false
		
		System.out.println(true && true);//true
		System.out.println(true && false);//false
		System.out.println(false && false);//false


		//短路现象，什么时候会发生“短路”
		int x = 10;
		int y = 11;
		
		//逻辑与只有在&两边都是true，结果才是true
		//如果&左边是false，那么运算结果必为法拉瑟
		//理论上，&右边没有必要执行
		System.out.println(x > y & x > y++);//false
		System.out.println(y);//输出12，说明上行中&右边被执行了

		int m = 10;
		int n = 11;
		System.out.println(m > n && m > n++);//false
		System.out.println(n);//11，因为&&左边已经是false了，&&右边没有必要执行
		//&&右边被短路


	}
}
```

# 三目运算符

## 语法格式

```java
<布尔表达式(true/false)> ? <表达式1> : <表达式2> 
```

## 执行原理

如果布尔表达式结果为true，执行表达式1

如果布尔表达式结果为false ，执行表达式2

```java
public class OperatorTest05{
	public static void main(String[] args){
		boolean gender = false;
	//下行代码编译时会报错吗？
	gender ? "male" : "female";  //不会，因为后面的"male"和"female"不是语句
	/*
		运行效果与
		100;
		一样
	*/
	//下行代码会报错吗？
	string x = gender ? "male" : "female";      //可以，但要注意变量类型
		
	//下面情况在开发中不会出现
	//char x = gender ? '男' : "女"； //这里回报错：错误：不兼容的类型：条件表达中的类型错误String无法转换为char     
	//这样可以吗？
		System.out.println(gender ? '男' : "女");
	//可以
		System.out.println("这个括号里面什么类型都可以放");
	}
}
```

# 字符串连接运算符

## "+"在Java中有两个作用:

### 1.求和

### 2.字符串的拼接

当+运算符两边都是数字类型的时候求和

当+运算符两边任意一边是字符串类型的时候，进行字符串拼接操作

字符串拼接之后的结果还是字符串

```java
	public class OperatorTest06{
		public static void main(String[] args){
			int age = 12 ;
			System.out.println("年龄=" + age);//+在这里回进行字符串拼接操作（相比Python，这里不需要类型转换）
			
			int a = 100;
			int b =200;
			int c = a + b;
			
			//当一个表达式中有多个加号的时候，遵循自左向右的顺序一次执行，除非额外加了小括号，小括号的优先级高
			System.out.print(a + b + "110");//先计算a与b求和，然后结果300与字符串110拼接，最后输出的结果为字符串类型300110
			System.out.print(a + (b + "110") );//先讲数字类型b与字符串类型110拼接，结果为字符串类型，然后与数字a拼接，结果为字符串类型100200110
			
			//用以上定义的变量输出“100+200=300”
			System.out.println(a + "+" + b + "=" + c);
			
			
		}
}

```

