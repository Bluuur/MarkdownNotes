public class MethodTest04{
	public static void daYin1(){
		System.out.println("Hello World");
	}

	public static void main(String[] args){
		MethodTest04.daYin1();
		MethodTest04.daYin2();
	
	//"����."����ʡ����
	//����
		daYin1();

	//�������ʱ����������ʡ
		MyClass.daYin1();
		//���������ʡ�����������Զ����ñ�����ķ������������
		//MyClass����ķ���
	}

	public static void daYin2(){
		System.out.println("Goodbye World");
	}
}

class MyClass{

	public static void daYin1(){
		System.out.println("��ӡ����");
	}
}

