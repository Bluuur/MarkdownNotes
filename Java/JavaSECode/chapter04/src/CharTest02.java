/*
	java�е�ת���ַ�
*/
public class CharTest02{
	public static void main(String[] args){
		char c1 = 't';
		System.out.println(c1);

		//������ѧ���ݣ����´���Ӧ�ñ���
		//�������ԣ����´������ͨ�����룬�������´��롰\t��
		//ʵ������һ���ַ����������ַ���

		//�����ַ�����һ���ʾһ���ַ�������\t��ʾ���Ʊ��tab��
		char c2 = '\t';

		System.out.println("abc\tdef");

		System.out.println("HelloWorld");
		System.out.print("HelloWorld");
		
		//"\"�ĳ��ֻὫ�����ź�����ַ�����ת��

		//����ڿ���̨���'�ַ�
		System.out.println('\'');

		System.out.println(" ' ");

		//����ڿ���̨���\�ַ�
		System.out.println('\\');

		//��������˫���ŵ������磺"test"
		System.out.println("\"test\"");
	}
}