/*
	switch��䣺
		1.switch���Ҳ��ѡ����䣨��֧��䣩
		2.switch�����﷨��ʽ
			switch(ֵ){
			case ֵ1:
				java���;
				java���;
				break;
			case ֵ2:
				java���;
				java���;
				break;
			case ֵ3:
				java���;
				java���;
				break;
			default:
				java���;
			}
		������һ��������switch���
			���У�break��䲻�Ǳ���ģ�default��֧Ҳ���Ǳ����
		
		switch���֧�ֵ�ֵ
			֧��int�����Լ�String����
			��Ҫע��JDK�İ汾��JDK8֮ǰ��֧��String���ͣ�ֻ֧��int
			��JDK8֮��switch��俪ʼ֧���ַ�������

		switch����ִ��ԭ��
			switch��Բ�����ڵ�ֵ����case���ֵ1����ƥ�䣬ֵ��ֵ����ƥ��ʱ��ʹ��==���бȽ�
			���ƥ�䣬��ִ�и÷�֧�е�Java��䣬����breakֹͣ����break���Ǳ���ģ�
			//ע�⣬�����ִ֧���ˣ����Ƿ�֧���û��break��䣬�ᷢ��case��͸����
				case��͸��������case1ƥ��ʱ��ִ����case1��֧�е����û������break��������������ִ��
				��ʱ������case2ֵ���бȽϣ�����ֱ��ִ��case2�е���䣬ֱ������break
			�����ֵ���롰ֵ1����ƥ�䣬��������ֵ��case2��case3...��ƥ��

			switch��䱾������ֻ֧��int��String����
			����byte��short��charҲ����
			��Ϊ��switch����У�С�������Զ�ת��Ϊ��������int(�Զ�����ת��)

*/
public class SwitchTest01{
	public static void main(String[] args){
		//���´��뱨�����󣺲����ݵ����ͣ�long����ת��Ϊint���Ϳ��ܻ�����ʧ
		/*long x = 100;
		switch(){
		
		}
		ǿ������ת������ͨ�����루�����ܻ��о�����ʧ��
		*/

		//���´��벻�ᱨ����Ϊ���Զ�����ת��(short��byteҲ����)
		/*
		byte b = 100;
		switch(b){

		}
		*/
		
		//���´���Ҳ���ᱨ���Զ�����ת����
		/*
		char c = 'a';//c��ת����ASCII���Ӧ�����֡�97��
		switch(c){
			
		}
		*/

		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("������[0-6]��������");
		int num = s.nextInt();
		//case��͸
/*		switch(num){
			case 0:
				System.out.println("������");
				break;
			case 1:
				System.out.println("����һ");

			case 2:
				System.out.println("���ڶ�");
				break;
			case 3:
				System.out.println("������");
				break;
			case 4:
				System.out.println("������");
				break;
			case 5:
				System.out.println("������");
				break;
			case 6:
				System.out.println("������");
				break;
*/
		
		switch(num){
			case 0:
				System.out.println("������");
				break;
			case 1:
				System.out.println("����һ");
				break;
			case 2:
				System.out.println("���ڶ�");
				break;
			case 3:
				System.out.println("������");
				break;
			case 4:
				System.out.println("������");
				break;
			case 5:
				System.out.println("������");
				break;
			case 6:
				System.out.println("������");
				break;
		} 

		//default���
		switch(num){
			case 0:
				System.out.println("������");
				break;
			case 1:
				System.out.println("����һ");
				break;
			case 2:
				System.out.println("���ڶ�");
				break;
			case 3:
				System.out.println("������");
				break;
			case 4:
				System.out.println("������");
				break;
			case 5:
				System.out.println("������");
				break;
			case 6:
				System.out.println("������");
				break;
			default:
				System.out.println("����������ݲ��Ϸ������������д˳�������Ϸ�����");
			
		}

		//case�ϲ�
		switch(num){
			case 0: case 7: case 8://����ϲ���0��7��8.����0��7��8����ִ�д˷�֧		System.out.println("������");
				break;
			case 1:
				System.out.println("����һ");
				break;
			case 2:
				System.out.println("���ڶ�");
				break;
			case 3:
				System.out.println("������");
				break;
			case 4:
				System.out.println("������");
				break;
			case 5:
				System.out.println("������");
				break;
			case 6:
				System.out.println("������");
				break;
			default:
				System.out.println("����������ݲ��Ϸ������������д˳�������Ϸ�����");
			
		}
	}
}