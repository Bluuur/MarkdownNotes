/*
	Ҫ��
		1.�Ӽ����Ͻ���һ���˵�����
		2.����Ҫ��Ϊ[0-150]������ֵ��ʾ�Ƿ�����Ҫ��ʾ�Ƿ���Ϣ
		3.�����˵���������̬�ж�����������������ĸ��׶�
			[0-5]Ӥ�׶�
			[6-10]�ٶ�
			[11-18]����
			[19-35]����
			[36-55]����
			[56-150]����
*/
public class IfTest02{
	public static void main(String[] args){
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("������������䣨0-150����");
		int userAge = s.nextInt();

		if(userAge >= 0 && userAge <=150){
			if(userAge <= 5){
				System.out.println("������Ӥ�׶��׶�");
			}else if(userAge <=10){
				System.out.println("�������ٶ��׶�");
			}else if(userAge <= 18){
				System.out.println("����������׶�");
			}else if(userAge <= 35){
				System.out.println("����������׶�");
			}else if(userAge <= 55){
				System.out.println("����������׶�");
			}else if(userAge >= 56){
				System.out.println("����������׶�");
			}
		}else{
			System.out.println("����������ַǷ������������д˳�������Ϸ�����");
		}

		//Ҳ���Բ�ʹ��ifǶ��
		if(userAge < 0 || userAge >150){
			System.out.println("����������ַǷ������������д˳�������Ϸ�����");
		}else if(userAge <= 5){
			System.out.println("������Ӥ�׶��׶�");
		}else if(userAge <=10){
			System.out.println("�������ٶ��׶�");
		}else if(userAge <= 18){
			System.out.println("����������׶�");
		}else if(userAge <= 35){
			System.out.println("����������׶�");
		}else if(userAge <= 55){
			System.out.println("����������׶�");
		}else if(userAge >= 56){
			System.out.println("����������׶�");

		}

		//�����Խ�һ������
		String str = "����";
		if(userAge < 0 || userAge >150){
			System.out.println("����������ַǷ������������д˳�������Ϸ�����");
			return;//�����ѧ�����ó�����������ֹ���������������Ĵ�ӡ
		}else if(userAge <= 5){
			str = "Ӥ�׶�";
		}else if(userAge <=10){
			str = "�ٶ�";
		}else if(userAge <= 18){
			str = "����";
		}else if(userAge <= 35){
			str = "����";
		}else if(userAge <= 55){
			str = "����";
		}
		System.out.println("������" + str + "�׶�");
	}
}