////在外部程序中访问Person这个类型中的数据
//public class PersonTest{
//	public static void main(String[] args){
//		//创建Person对象
//		Person = new Person();
//		//访问一个对象的属性，通常包括两种操作
//		//一种是读数据，一种是写数据
//		//读数据
//		System.out.println(p1.age);//读（get，表示获取）
//
//		//修改数据（set，表示修改/设置）
//		p1.age = 50;
//
//		//再次读取
//		System.out.println(p1.age);
//
//		//在PersonTest这个外部程序中，目前是可以随意对age属性进行操作
//		//一个人的年龄值不因该为负数
//		//程序中给年龄赋值了一个负数，按说是不符合业务要求的
//		//这就是程序的一个bug
//		p1.age = -100;
//		System.out.println("您的年龄是：" + p1.age);//读
//	}
//}