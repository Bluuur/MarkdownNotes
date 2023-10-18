/*
	java中的转义字符
*/
public class CharTest02{
	public static void main(String[] args){
		char c1 = 't';
		System.out.println(c1);

		//根据已学内容，以下代码应该报错：
		//经过测试，以下代码可以通过编译，所以以下代码“\t”
		//实际上是一个字符，不属于字符串

		//两个字符合在一起表示一个字符，其中\t表示“制表符tab”
		char c2 = '\t';

		System.out.println("abc\tdef");

		System.out.println("HelloWorld");
		System.out.print("HelloWorld");
		
		//"\"的出现会将紧挨着后面的字符进行转义

		//如何在控制台输出'字符
		System.out.println('\'');

		System.out.println(" ' ");

		//如何在控制台输出\字符
		System.out.println('\\');

		//如何输出带双引号的内容如："test"
		System.out.println("\"test\"");
	}
}