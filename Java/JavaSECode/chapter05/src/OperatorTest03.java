public class OperatorTest03{
	public static void main(String[] args){
		System.out.println(true & true);//true
		System.out.println(true & false);//false
		System.out.println(false & false);//false

		System.out.println(100 > 90 & 100 > 101);//false

		int a = 100;
		int b = 101;
		int c = 90;
		System.out.println(a < b | c > b);//(true|false)���true
		System.out.println(true | false);//true
		System.out.println(true | true);//true
		System.out.println(false | false);//false

		System.out.println(!false);//true
		System.out.println(!true);//false

		//ע�⣺����Ҫ��С����
		System.out.println(!(a > b));//true


		System.out.println(true & true);//true
		System.out.println(true & false);//false
		System.out.println(false & false);//false
		
		System.out.println(true && true);//true
		System.out.println(true && false);//false
		System.out.println(false && false);//false


		//��·����ʲôʱ��ᷢ������·��
		int x = 10;
		int y = 11;
		
		//�߼���ֻ����&���߶���true���������true
		//���&�����false����ô��������Ϊfalse
		//�����ϣ�&�ұ�û�б�Ҫִ��
		System.out.println(x > y & x > y++);//false
		System.out.println(y);//���12��˵��������&�ұ߱�ִ����

		int m = 10;
		int n = 11;
		System.out.println(m > n && m > n++);//false
		System.out.println(n);//11����Ϊ&&����Ѿ���false�ˣ�&&�ұ�û�б�Ҫִ��
		//&&�ұ߱���·


	}
}