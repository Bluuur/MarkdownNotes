public class HomeWork01{
	public static void main(String[] args){
		int i = 10;
		i = i++;
		System.out.println(i);
		/*
			设立输出的结果是10，而不是11
			首先，第一点：这种代码不会有人写
			其次，第二点：没必要讨论这个问题，因为在C++中运行的结果确实是11
			Java中运行的结果是10
			C++中运行的结果是11
			是因为Java和C++的编译器是不同的人开发的，原理不同
		*/

		//在Java语言中，i++这种表达式在执行的时候，会提前将i变量找一个临时变量储存
		//C++中并没有这样做
		int k = 10;
		k = k++;
		//在k = k++;这一步中，实际进行了以下过程：
		//int temp = k;
		//k++;
		//k = temp;
		System.out.println(i);

	}
}