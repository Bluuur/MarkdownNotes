/*
	构造方法作用：
		创建对象，并且创建对象的时候给属性赋值（初始化）
		对于实例变量来说，只要在构造方法中没有手动赋值
		统一都会默认赋值
*/

public class Constructor02{
	public static void main(String[] args){
		User u = new User();

		System.out.println(u.id);//0
		System.out.println(u.name);//null
		System.out.println(u.age);//0
		
	}
}