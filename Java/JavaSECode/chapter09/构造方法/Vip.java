public class Vip{
	
	//��Ա��
	long no;
	
	//��Ա����
	String name;
	
	//����
	String birthday;
	
	//�Ա�
	boolean gender;
	
	//�޲������췽��
	public Vip(){
		
	}

	//�в������췽��
	public Vip(long huiYuanHao, String xingMing){
		//��ʵ��������ֵ����ʼ����
		no = huiYuanHao;
		name = xingMing;
		//����ֻ�������β�
		//ʣ��û���ֶ���ֵ�Ķ��ḳĬ��ֵ

	}

	//�в������췽��
	public Vip(long huiYuanHao, String xingMing, String shengRi){
		no = huiYuanHao;
		name = xingMing;
		birthday = shengRi;
	}

	public Vip(long huiYuanHao, String xingMing, String shengRi, boolean xingBie){
		no = huiYuanHao;
		name = xingMing;
		birthday = shengRi;
		gender = xingBie;
	}
}