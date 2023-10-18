public class Test01{
	public static void main(String[] args){
		int i = 10;
		add(i);
		System.out.println("main --->" + i);//这里输出10
	}

	public static void add(int i){
		i++;
		System.out.println("add --->" + i);//这里输出11
	}
}
//Java中规定：参数传递的时候，和类型无关，不管是基本数据类型还是引用数据类型
//统一都是变量这个“盒子”中保存的值复制一份，传递下去