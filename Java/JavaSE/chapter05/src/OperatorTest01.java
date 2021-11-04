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