/*
	1.在Java语言中，boolean类型只有两个值，没有其他值
	true和false
	不像C和C++，C语言中1和0也可以表示布尔类型

	2.Boolean类型在实际开发中的使用
	使用在逻辑判断中，通常放到条件的位置上
*/
public class BooleanTest01{
	public static void main(String[] args){
		
		//以下代码会报错吗？
		//boolean xingBie = 1;
		//	错误: 不兼容的类型: int无法转换为boolean

		//需求规定：如果为true则表示男，如果为false则表示女
		boolean gender = true;
		//后面会学习if语句
		//if语句是一个条件语句
		if (gender){			//if后的括号中的值为true，则执行其后紧跟的花括号
									//if后的括号中的值为false，则执行else其后紧跟的花括号
			System.out.println("男");
		}else{
			System.out.println("女");
		}

		//boolean flag = (a < b);	//运算符有优先级，不确定可以加小括号，加了小括号的最先运算
		//System.out.println(flag);
	}
}