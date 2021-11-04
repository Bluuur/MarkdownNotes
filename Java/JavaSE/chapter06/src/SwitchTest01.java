/*
	switch语句：
		1.switch语句也是选择语句（分支语句）
		2.switch语句的语法格式
			switch(值){
			case 值1:
				java语句;
				java语句;
				break;
			case 值2:
				java语句;
				java语句;
				break;
			case 值3:
				java语句;
				java语句;
				break;
			default:
				java语句;
			}
		以上是一个完整的switch语句
			其中：break语句不是必须的，default分支也不是必须的
		
		switch语句支持的值
			支持int类型以及String类型
			但要注意JDK的版本，JDK8之前不支持String类型，只支持int
			在JDK8之后，switch语句开始支持字符串类型

		switch语句的执行原理
			switch后圆括号内的值，与case后的值1进行匹配，值与值进行匹配时，使用==进行比较
			如果匹配，则执行该分支中的Java语句，遇到break停止（但break不是必须的）
			//注意，如果分支执行了，但是分支最后没有break语句，会发生case穿透现象
				case穿透：例如与case1匹配时，执行完case1分支中的语句没有遇到break，程序会继续向下执行
				此时不会与case2值进行比较，而是直接执行case2中的语句，直到遇到break
			如果“值”与“值1”不匹配，则向后面的值（case2、case3...）匹配

			switch语句本质上是只支持int和String类型
			但是byte，short，char也可以
			因为在switch语句中，小容量会自动转换为大容量的int(自动类型转换)

*/
public class SwitchTest01{
	public static void main(String[] args){
		//以下代码报错：错误：不兼容的类型，long类型转换为int类型可能会有损失
		/*long x = 100;
		switch(){
		
		}
		强制类型转换可以通过编译（但可能会有精度损失）
		*/

		//以下代码不会报错，因为有自动类型转换(short，byte也可以)
		/*
		byte b = 100;
		switch(b){

		}
		*/
		
		//以下代码也不会报错（自动类型转换）
		/*
		char c = 'a';//c被转成了ASCII码对应的数字“97”
		switch(c){
			
		}
		*/

		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("请输入[0-6]的整数：");
		int num = s.nextInt();
		//case穿透
/*		switch(num){
			case 0:
				System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");

			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
*/
		
		switch(num){
			case 0:
				System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
		} 

		//default语句
		switch(num){
			case 0:
				System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
			default:
				System.out.println("你输入的数据不合法，请重新运行此程序并输入合法数据");
			
		}

		//case合并
		switch(num){
			case 0: case 7: case 8://这里合并了0，7，8.输入0，7，8都会执行此分支		System.out.println("星期日");
				break;
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
			default:
				System.out.println("你输入的数据不合法，请重新运行此程序并输入合法数据");
			
		}
	}
}