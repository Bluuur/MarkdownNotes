public class FloatTest01{
	public static void main(String[] args){
		
		double pi = 3.1415926;
		System.out.println(pi);
		//���ﲻ��������ת��
		//3.1415926��double����
		//pi��double����
		
		//���´���ᱨ����
		//float f = 3.14;
		//����: �����ݵ�����: ��doubleת����float���ܻ�����ʧ

		//������
		//����1�����������������F/f
		float f = 3.14F;
		System.out.println(f);

		//����2��ǿ������ת������������ʧ���ȣ�����ʹ�ã�
		float p = (float)3.14;
		System.out.println(p);

		//���´���ᱨ����
		//int i = 10.0 / 5;
		//����: �����ݵ�����: ��doubleת����int���ܻ�����ʧ
		//ԭ���Ƚ�5ת����double���ͣ�Ȼ�������㣬�����double
		//�����double���ͣ���ֵ��int i���޷�ֱ�Ӹ�ֵ����Ҫǿ������ת��
		int i = (int)10.0 / 5;
		System.out.println(i);     //���2

		//���������޸���
		int x = (int)(10.0 / 5);
		System.out.println(x);     //���2
		//����(10.0 / 5)��������ɺ󣨽����double���ͣ�����ǿ������ת��	
	}
}
		

