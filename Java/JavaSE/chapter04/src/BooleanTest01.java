/*
	1.��Java�����У�boolean����ֻ������ֵ��û������ֵ
	true��false
	����C��C++��C������1��0Ҳ���Ա�ʾ��������

	2.Boolean������ʵ�ʿ����е�ʹ��
	ʹ�����߼��ж��У�ͨ���ŵ�������λ����
*/
public class BooleanTest01{
	public static void main(String[] args){
		
		//���´���ᱨ����
		//boolean xingBie = 1;
		//	����: �����ݵ�����: int�޷�ת��Ϊboolean

		//����涨�����Ϊtrue���ʾ�У����Ϊfalse���ʾŮ
		boolean gender = true;
		//�����ѧϰif���
		//if�����һ���������
		if (gender){			//if��������е�ֵΪtrue����ִ���������Ļ�����
									//if��������е�ֵΪfalse����ִ��else�������Ļ�����
			System.out.println("��");
		}else{
			System.out.println("Ů");
		}

		//boolean flag = (a < b);	//����������ȼ�����ȷ�����Լ�С���ţ�����С���ŵ���������
		//System.out.println(flag);
	}
}