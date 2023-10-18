public class OperatorTest05{
	public static void main(String[] args){
		boolean gender = false;
	//下行被注释的代码会报错吗？
	//gender ? "male" : "female";  //不会，因为后面的"male"和"female"不是语句
	/*
		运行效果与
		100;
		一样
	*/
	//下行被注释的代码会报错吗？
	//string x = gender ? "male" : "female";      //可以，但要注意变量类型
		
	//下面情况在开发中不会出现
	//char x = gender ? '男' : "女"； //这里回报错：错误：不兼容的类型：条件表达中的类型错误String无法转换为char     ##强制类型转换？？
	//这样可以吗？
		System.out.println(gender ? '男' : "女");
	//可以
		System.out.println("这个括号里面什么类型都可以放");
	}
}