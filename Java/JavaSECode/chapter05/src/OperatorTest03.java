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
		//如果&左边是false，那么运算结果必为false
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