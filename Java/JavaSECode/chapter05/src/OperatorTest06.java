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
