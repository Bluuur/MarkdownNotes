public class MethodTest05{
	public static void main(String[] args){
		System.out.println("main begin");
		m1();
		System.out.println("main over");
	}

	public static void m1(){
		//调用程序不一定要写到main方法中
		System.out.println("m1 begin");
		m2();
		System.out.println("m1 over");
	}

	public static void m2(){
		System.out.println("m2 begin");
		T.m3();
		System.out.println("m2 over");
	}
}
class T{
	public static void m3(){
		System.out.println("m3 begin");
		System.out.println("T's m3 method execute!");
		System.out.println("m3 over");
	}
}
/*
	运行结果
	main begin
	m1 begin
	m2 begin
	m3 begin
	T's m3 method execute!
	m3 over
	m2 over
	m1 over
	main over
	main方法最先执行，并且main方法最后一个结束
	main结束，这个程序就结束了
*/