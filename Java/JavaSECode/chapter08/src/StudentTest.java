/*
	对象的创建和使用
		在下面程序的主方法内，可以放弃问Student类

	创建对象的语法
		new 类名（）；

	变量类型 对象名    =  new Student;
	Student  ZhangSan  =  new Student;
	以上，new Student是对象，严格来说，张三不是对象，只是一个变量名
		

		数据类型
			基本数据类型
				byte short int long float double boolean char
			引用数据类型
				String、前面创建的学生类等等
			
			所有类都是引用数据类型
			
	类是模板，通过一个类，可以创建多个对象
	new是一个运算符。专门负责对象的创建
*/
public class StudentTest{
	public static void main(String[] args){
		Student ZhangSan = new Student();//通过Student类实例化了Student对象
	}
}