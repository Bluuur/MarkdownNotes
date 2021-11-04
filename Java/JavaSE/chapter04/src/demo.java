public class demo{
	public static void main(String[] args){
		
		char c1 = 'a';
		System.out.println(c1);

		//以下会做类型转换吗
		//97被默认当作int类型
		//c2是char类型
		char c2 = 97;
		System.out.println(c2);

		//char的取值范围：[0~65535]
		char c3 = 65535;	//65535对应一个字符，但由于dos命令窗口采用GBK编码，无法显示
		System.out.println(c3);

		//char的取值范围：[0~65535]
//		char c4 = 65536;	//与整数型一样，会报错精度损失
//		System.out.println(c4);
		//同样也可以使用强制转换（char）
	}
}