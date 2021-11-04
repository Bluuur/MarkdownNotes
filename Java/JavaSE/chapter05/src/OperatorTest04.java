public class OperatorTest04{
	public static void main(String[] args){
		//基本赋值运算符
		int i = 10;

		//重新赋值
		i = 20;

		//扩展赋值运算符
		int k = 10;
		k += 20;//k变量追加20
		System.out.println(k);//30
		//+=运算符*类似*以下表达式
		int m = 10;
		m = m + 20;
		System.out.println(m);//30

		//i += 10 和 i = i + 10的区别
		byte x = 100;
		System.out.println(x);

		//x = x = 1;编译不能通过，比那一起检测到x + 1是int类型，不能直接赋值给
		//byte类型的变量x，需要强制类型转换

		x += 1;//使用扩展运算符可以

		int n = 100;
		n += 100;
		System.out.println(n);//200

		n -= 100;
		System.out.println(n);//100

		n *= 10;
		System.out.println(n);//1000

		n /= 30;
		System.out.println(n);//33
		
		n %= 10;
		System.out.println(n);//3


	}
}