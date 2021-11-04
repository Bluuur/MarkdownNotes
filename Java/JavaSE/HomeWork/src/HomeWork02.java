public class HomeWork02{
	public static void main(String[] args){
		int x = 10;
		int a = x + x++;
		System.out.println("a = " + a);
		System.out.println("x = " + x);
		int b = x + ++x;
		System.out.println("b = " + b);
		System.out.println("x = " + x);
		int c = x + x--;
		System.out.println("c = " + c);
		System.out.println("x = " + x);
		int d = x + --x;
		System.out.println("d = " + d);
		System.out.println("x = " + x);

	}
}