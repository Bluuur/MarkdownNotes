public class CharTest01{
	public static void main(String[] args){
/*
	字符型
		char

		1.char占用两个字节
		2.char的取值范围：[0，65535]
		3.char采用unicode编码方式
		4.char类型的字面量使用单引号括起来
		5.char可以储存一个汉字

*/
		char c1 = '中';			
		System.out.println(c1);
		//char可以储存一个汉字
		//一个汉字占用两个字节
		//char类型也占用两个字节
		
		char c2 = 'a';
		System.out.println(c2);

		char c3 = '0';
		System.out.println(c3);
	} 
}