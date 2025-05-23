# 数据类型概述

## 数据类型的作用

数据类型用来声明变量，程序在运行过程中根据不同数据类型分配不同大小的空间

例如：

```
int i = 10;
double d = 1.23;
```

i 变量和 d 变量类型不同，空间大小不同

## 数据类型在 Java 语言中包括两种

**第一种：**基本数据类型

基本数据类型可以划分为 4 类 8 种

第一类：整数型

byte\short\int\long

第二类：浮点型

float\double

第三类：布尔型

boolean：只有两个值 true 和 false

第四类：字符型

char：Java 中规定字符型字面量必须使用单引号括起来，属于文字

**第二种：**引用数据类型

字符串型 String

 

Java 中除了基本数据类型之外，剩下的都是引用数据类型

引用数据类型后期面向对象的时候才会接触

 

## 8 种基本数据类型

**整数型：**byte short int long 的区别

byte 占用 1 个字节

short 占用 2 个字节

int 占用 4 个字节

long 占用 8 个字节

浮**点型：**float 和 double 的区别

**区别：**占用的空间大小不同

 

**关于计算机存储单位**

计算机只能识别二进制

1 字节（byte） = 8 比特（bit）

1bit 就是一个 1 或 0

1KB = 1024byte

1MB = 1024KB

1GB = 1024 MB

1TB = 1024GB

1PB = 1024TB

 

示例：

byte b = 2; 在计算机中这样表示： 00000010

short s = 2; 在计算机中这样表示： 00000000 00000010

int i = 2;在计算机中这样表示： 00000000 00000000 00000000 00000010

## 整数型的四种表示方式 Int.java

​	十进制（最常用）
​	二进制
​	八进制
​	十六进制
​	

整数型在 Java 中共四种类型

| 类型  |  大小   |
| :---: | :-----: |
| byte  | 1 个字节 |
| short | 2 个字节 |
|  int  | 4 个字节 |
| long  | 8 个字节 |

数字默认是十进制
八进制以 0 开始
十六进制以 0x 开始
二进制以 0b 开始（JDK8 以后的特性，低版本不支持）

3.2 有关整数型的默认规定
	在任何情况下，整数型的字面量默认被当作 int 类型处理
	如果希望整数型字面量被当作 long 类型处理，需要在字面量后面添加 l 或 L
	（建议使用大写 L 因为小写 l 和 1 差不多）
	

## 自动类型转换 IntTest02.java

## 强制类型转换 IntTest03.java

强制类型转换的底层实现过程：
	long 类型 100L：00000000 00000000 00000000 00000000 00000000 00000000 00000000 01100100
	以上 long 类型强制转换为 int 类型，会自动将前面的 4 个字节去掉
	变为：00000000 00000000 00000000 01100100

## 精度损失以及不超范围可以直接赋值 byte 和 short IntTest04.java

## 整数没有超范围可以直接赋值给 char  CharTest03.java

​	数据类型：
​		字符型 char
​		整数型 byte short int long 
​		浮点型 float double
​		布尔型 boolean
​		

	char
		整数能否直接赋值给 char
		
		运行结果
		
		char c2 = 97；这个语句是允许的，并且输出的结果是“a”
		经过这个测试可以得出两个结论：
			1.当一个整数赋值给 char 类型变量时，会自动转换成 char 字符型，最终输出字符
			2.当一个整数没有超出 byte short char 的取值范围时，这个整数可以直接赋值给 byte short char 类型的变量

​		

## 计算机原码反码补码

​	计算机在任何情况下都只能识别二进制
​	计算机在底层存储数据的时候，一律储存的是“二进制的补码形式”
​	计算机采取补码形式存储数据的原因是：补码形式效率最高
​	补码
​		二进制有原码 反码 补码
​		对于一个正整数来说，二进制原码、反码、补码完全相同
​			例如：
​				int i = 1;
​				对应的二进制原码：00000000 00000000 00000000 00000001
​				对应的二进制反码：00000000 00000000 00000000 00000001
​				对应的二进制补码：00000000 00000000 00000000 00000001
​				

		对于一个负数来说，二进制原码补码反码存在转换关系
			例如：
				int i = -1;
				对应的二进制原码：10000000 00000000 00000000 00000001
				对应的二进制反码：11111111 11111111 11111111 11111110
			反码：相比原码，符号位（负数还是以 1 开头）不变，其他位取反（0 取为 1；1 取为 0）
				对应的二进制补码：11111111 11111111 11111111 11111111
			补码：反码+1
