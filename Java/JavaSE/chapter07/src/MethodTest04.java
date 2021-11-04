public class MethodTest04{
	public static void daYin1(){
		System.out.println("Hello World");
	}

	public static void main(String[] args){
		MethodTest04.daYin1();
		MethodTest04.daYin2();
	
	//"类名."可以省略吗？
	//可以
		daYin1();

	//跨类调用时，类名不能省
		MyClass.daYin1();
		//如果在这里省略类名，会自动调用本类里的方法，不会调用
		//MyClass类里的方法
	}

	public static void daYin2(){
		System.out.println("Goodbye World");
	}
}

class MyClass{

	public static void daYin1(){
		System.out.println("打印方法");
	}
}

