//�ֲ�������ֻ�ڷ���������Ч����������֮�󣬾ֲ��������ڴ���ͷ���
//JVM������Ҫ���ڴ棺ջ�ڴ桢���ڴ桢�������ڴ�
//����ȥ���������ݣ��������д�Ŵ���Ƭ�Ρ�clas�ֽ���
//���ڴ棺�����ѧ��
//ջ�ڴ棺�������õ�ʱ�򣬸÷�����Ҫ���ڴ�ռ���ջ�з���
	//ջ�ڴ洢�淽��ִ��ʱ���ڴ�ռ��Լ��ֲ�����
//���������ã�������ջ�з���ռ�

//����ֻ���ڵ��õ�ʱ��Ż���ջ�з���ռ䣬���ҵ���ʱ����ѹջ
//����ִ�н���֮�󣬸÷�������Ҫ�Ŀռ�ͻ��ͷţ���ʱ������ջ����

//�������ý�����ѹջ��������ռ�
//����������������ջ�����ͷſռ�

public class MethodTest08{
	public static void main(String[] args){
		System.out.println("main begin");
		int x = 100;
		m1(x);
		System.out.println("main over");
	}
	public static void m1(int i){
		System.out.println("m1 begin");
		m2(i);
		System.out.println("m1 over");
	}
	public static void m2(int i){
		System.out.println("m2 begin");
		m3(i);
		System.out.println("m2 over");
	}
	public static void m3(int i){
		System.out.println("m3 begin");
		System.out.println(i);
		System.out.println("m3 over");
	}
}