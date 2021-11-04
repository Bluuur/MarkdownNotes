///*
//	java中关于方法调用时参数传递实际上只有一个规则：
//		不论是基本数据类型，还是引用数据类型
//		实际上在传递时都是将变量中保存的那个值复制一份，传过去
//		这里引用p保存的是person对象的内存地址
//		下面将这个person的内存地址复制了一份，传给pp
//		pp保存的内存地址仍占指向上面的person对象
//		下面执行add方法时，对person对象的age属性执行了自加一的动作
//		因此p.age的值会自加一，而不像此目录下的Test01中那样
//		p和pp是同一个对象的内存地址（一扇门的两把钥匙）
//*/
//
//import 方法调用时参数的传递问题.Person;
//
//public class Test02{
//	public static void main(String[] args){//main方法执行，压栈
//		Person p = new Person();//通过Person类实例化一个p对象
//		p.age = 10;//将p对象的age实例变量赋值为10
//		add(p);//将p对象作为实际参数，传到add方法，执行add方法。压栈|
//		System.out.println("mian --->" + p.age);//11				|
//	}									//							|
//	//方法的参数可以是基本数据类型，也可以时引用数据类型			|
//	//只要是合法的数据类型就行										|
//	public static void add(Person pp){//这里是引用数据类型<----------
//		pp.age++;//
//		System.out.println("add --->" + pp.age);//11
//	}
//}
//
//class person{
//	//年龄属性，成员变量中的实例变量
//	int age;
//}