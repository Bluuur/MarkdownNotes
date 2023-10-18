/*
	输出信息到控制台
		System.out.println(...);
	在Java中怎么接收键盘的输入？
		以下代码目前看不懂，在学习面向对象之后才能够理解
*/
public class KeyInput{
	public static void main(String[] args){

		//创建一个键盘扫描器对象
		java.util.Scanner s = new java.util.Scanner(System.in);//s是变量名，可以修改，其他不能修改

		//接受用户的输入，从键盘上接收一个int类型
		int userInputNum = s.nextInt();//代码执行到这里的时候会暂停下来
		//等待用户的输入，用户可以从键盘上输入一个整数，然后回车，回车之后变量userInputnum就有值了，
		//保存的是用户输入的数字.userInputnum的作用就是接受用户的输入的
		System.out.println("您输入的数字是：" + userInputNum);

		//从键盘上接受字符串
		String str = s.next();//同样，程序运行到此处会停下来，等待用户输入字符串
		System.out.println("您输入了：" + str);

		//更加完整的
		System.out.print("请输入用户名：");
		String name = s.next();
		System.out.println("欢迎" + name + "回来！");

	}
}