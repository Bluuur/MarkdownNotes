//注意：程序开始执行的时候是执行的main方法
//因为main方法是程序的入口
//在Java语言中，所有的方法体中的代码都必须遵循自上而下的顺序逐行执行
//main方法不需要程序员手动调用，是由JVM调用的
//但是除了main方法以外，其他的方法都需要程序员手动调用
//方法只有调用的时候才会执行，方法不调用的时候不会执行

//方法定义在类体中，顺序没有要求（可以写在main方法前）
public class MethodTest02{
	public static void main(String[] args){
		//同样有两个需求：计算100和200的和；计算66和88的和
		sumInt(100,200);//这里调用sumInt方法
		sumInt(66,88);
	}

	//专门在这个类体中定义一个方法，这个方法专门用来完成求和
	//同样，这里按照自上而下的顺序执行
	public static void sumInt(int x, int y){
		int z = x + y;
		System.out.println(x + "+" + y + "=" + z);
	}
	
}