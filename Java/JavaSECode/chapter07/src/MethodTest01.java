/*
	对于一个Java程序来说，如果没有方法，会出现什么问题
		代码无法复用
*/
public class MethodTest01{
	public static void main(String[] args){
		
		//需求1：编写程序，计算100和200的和
		int x = 100;
		int y = 200;
		int z = x + y;
		System.out.println(x + "+" + y + "=" + z);
		
		//需求2：编修程序，计算66和88的和
		//需求2和需求1实际上完全相同，只是具体求和时的数据不同
		int a = 66;
		int b = 88;
		int c = a + b;
		System.out.println(a + "+" + b + "=" + c);

		//需求1和需求2本质上相同，只不过参与运算的数值不同
		//代码编写了两份，代码的复用性很差

		//功能相同，能不能只编写一次？
		//需要实现代码复用，需要使用Java中的"方法"
	}


}