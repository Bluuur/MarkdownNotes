public class MethodTest05{
	public static void main(String[] args){
		System.out.println("main begin");
		m1();
		System.out.println("main over");
	}

	public static void m1(){
		//���ó���һ��Ҫд��main������
		System.out.println("m1 begin");
		m2();
		System.out.println("m1 over");
	}

	public static void m2(){
		System.out.println("m2 begin");
		T.m3();
		System.out.println("m2 over");
	}
}
class T{
	public static void m3(){
		System.out.println("m3 begin");
		System.out.println("T's m3 method execute!");
		System.out.println("m3 over");
	}
}
/*
	���н��
	main begin
	m1 begin
	m2 begin
	m3 begin
	T's m3 method execute!
	m3 over
	m2 over
	m1 over
	main over
	main��������ִ�У�����main�������һ������
	main�������������ͽ�����
*/