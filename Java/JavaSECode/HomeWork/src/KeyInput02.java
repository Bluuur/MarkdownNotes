import java.util.Scanner;
public class KeyInput02{
	public static void main(String[] args){
		//创建键盘扫描器对象
		Scanner s = new Scanner(System.in);
		//输出一个欢迎信息
		System.out.println("欢迎使用小型迷你计算器");
		System.out.print("请输入第1个数字：");
		int num1 = s.nextInt();
		System.out.print("请输入第2个数字：");
		int num2 = s.nextInt();
		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
	}
}