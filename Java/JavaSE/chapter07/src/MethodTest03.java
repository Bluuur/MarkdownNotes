/*
	1.方法怎么定义，语法机制是什么
		修饰符列表 返回值类型 方法名 （形式参数列表）{
			方法体；
		}

		其中，修饰符列表不是必须
		方法体由Java语句构成
		方法定义之后需要去调用，不调用是不会执行的

		1.1关于修饰符列表
			修饰符列表不是必选项，
			目前为止，直接携程public static
			后面会具体学习

		1.2关于返回值类型
			返回值类型可以是任何类型，只要是Java中合法的数据类型
			数据类型包括基本数据类型和引用数据类型

			什么是返回值
				返回值一般指一个方法执行结束后的结果
				结果通常是一个数据，所以被称为“值”
				大部分情况下都是有一个结果的，体现结果的一般都是数据

			当一个方法执行解释不返回任何值的时候
			返回值类型也不能空着，必须写上void关键字
			（main方法结束之后不需要返回任何结果）

		“谁调用返回给谁”
		main{
			//调用a方法
			a();//如果a放啊执行结束之后由返回值，这个返回值会返回给main
		}

		a(){

		}


		如果返回值类型不是void
		那么在方法执行结束的时候必须使用"return 值;"这样的语句
		来完成“值”的返回
		如果没有"return 值;"这样的语句，编译器会报错

		注意：只要有"return"关键字的语句执行，当前方法必然结束

		如果返回值类型是void，那么在方法体中不能有“return 值;”
		这样的语句。但是，可以有“return;”语句，用来终止当前方法

		1.3方法名
		方法名要见名知意
		方法名在标识符命规则中，要求首个单词的首字母小写
		后面每个单词的首字母大写

		1.4形式参数列表
		简称：形参
		注意：形式参数列表中的每一个参数都是局部变量
		方法结束之后内存释放
		形参的个数是0~n个
		形参有多个的话，用逗号隔开
		形参的数据类型其决定性作用，形参对应的变量名是随意的
		形参的数据类型可以是Java语言中任意合法的数据类型

		1.5方法体
		有Java语句构成，Java语句由;结尾
		方法体中编写的是业务逻辑代码，完成某个特定的功能
		方法体中的代码遵循自上而下的吮吸一次逐行执行

		在方法体中处理业务逻辑代码的时候需要数据
		数据的来源就是这些形参

	2.方法定义之后怎么调用
		方法必须调用之后才能执行
		调用：
			类名.方法名(实际参数列表);
*/
public class MethodTest03{

	//main方法结束之后不需要给JVM返回任何执行结果
	public static void main(String[] args){
		//如何调用方法
		MethodTest03.division(100, 30);//(100, 30)叫做实参，实参和形参必须一一对应

		//怎么接受上行方法调用后的返回值？
		//使用变量接受
		int result = MethodTest03.division(100, 30);

		//对于返回值为void的方法，变量接收不到方法执行的结果
		//对于有返回值的方法，可以选择不接受返回值，但这样没有意义，一般程序返回了执行结果都是需要接受结果的
	}

/*
	public static int division(int x, int y){
		int z = x / y;
		return z;
	}
*/
	//上面被注释的代码中，返回值也可以这样写：
	public static int division(int x, int y){
		return x / y;
	}

	//如果不需要返回值，直接输出
//	public static void division(int x, int y){
//		System.out.println(x / y);
//	}
}