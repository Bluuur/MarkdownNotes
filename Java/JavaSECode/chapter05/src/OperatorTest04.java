public class OperatorTest04{
	public static void main(String[] args){
		//������ֵ�����
		int i = 10;

		//���¸�ֵ
		i = 20;

		//��չ��ֵ�����
		int k = 10;
		k += 20;//k����׷��20
		System.out.println(k);//30
		//+=�����*����*���±��ʽ
		int m = 10;
		m = m + 20;
		System.out.println(m);//30

		//i += 10 �� i = i + 10������
		byte x = 100;
		System.out.println(x);

		//x = x = 1;���벻��ͨ��������һ���⵽x + 1��int���ͣ�����ֱ�Ӹ�ֵ��
		//byte���͵ı���x����Ҫǿ������ת��

		x += 1;//ʹ����չ���������

		int n = 100;
		n += 100;
		System.out.println(n);//200

		n -= 100;
		System.out.println(n);//100

		n *= 10;
		System.out.println(n);//1000

		n /= 30;
		System.out.println(n);//33
		
		n %= 10;
		System.out.println(n);//3


	}
}