public class FloatTest01{
	public static void main(String[] args){
		
		double pi = 3.1415926;
		System.out.println(pi);
		//这里不存在类型转换
		//3.1415926是double类型
		//pi是double类型
		
		//以下代码会报错吗？
		//float f = 3.14;
		//错误: 不兼容的类型: 从double转换到float可能会有损失

		//改正：
		//方法1，在字面量后面添加F/f
		float f = 3.14F;
		System.out.println(f);

		//方法2，强制类型转换，但可能损失精度，谨慎使用！
		float p = (float)3.14;
		System.out.println(p);

		//以下代码会报错吗？
		//int i = 10.0 / 5;
		//错误: 不兼容的类型: 从double转换到int可能会有损失
		//原理：先将5转换成double类型，然后再运算，结果是double
		//结果是double类型，赋值给int i，无法直接赋值，需要强制类型转换
		int i = (int)10.0 / 5;
		System.out.println(i);     //输出2

		//可以这样修改吗？
		int x = (int)(10.0 / 5);
		System.out.println(x);     //输出2
		//先算(10.0 / 5)，运算完成后（结果是double类型）进行强制类型转换	
	}
}
		

