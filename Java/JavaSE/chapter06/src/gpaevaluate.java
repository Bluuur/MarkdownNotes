public class gpaevaluate{
	public static void main(String[] args){
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("��������ĳɼ���");
		double score = s.nextDouble();
		if (score >= 0 && score <= 100){
			if (score <= 59){
				System.out.println("��ĳɼ��ȼ�ΪF");
				System.out.println("GPAΪ0.00");
			}else if (score <=63){
				System.out.println("��ĳɼ��ȼ�ΪD");
				System.out.println("GPAΪ1.00");
			}else if (score <= 67){
				System.out.println("��ĳɼ��ȼ�ΪC-");
				System.out.println("GPAΪ1.50");
			}else if (score <= 71){
				System.out.println("��ĳɼ��ȼ�ΪC");
				System.out.println("GPAΪ2.00");
			}else if (score <= 74){
				System.out.println("��ĳɼ��ȼ�ΪC+");
				System.out.println("GPAΪ2.30");
			}else if (score <= 77){
				System.out.println("��ĳɼ��ȼ�ΪB-");
				System.out.println("GPAΪ2.70");
			}else if (score <= 81){
				System.out.println("��ĳɼ��ȼ�ΪB");
				System.out.println("GPAΪ3.00");
			}else if (score <= 84){
				System.out.println("��ĳɼ��ȼ�ΪB+");
				System.out.println("GPAΪ3.30");
			}else if (score <= 89){
				System.out.println("��ĳɼ��ȼ�ΪA-");
				System.out.println("GPAΪ3.70");
			}else if (score <= 100){
				System.out.println("��ĳɼ��ȼ�ΪA");
				System.out.println("GPAΪ4.00");
				if(score >90){
					System.out.println("�࿼" + (int)(score - 90) + "���˷� ��");
				}else{
					System.out.println("�࿼1���˷� �ٿ�1������ ��");
					}
			}
		}else{
			System.out.println("������ĳɼ����Ϸ������������д˳�������Ϸ��ɼ�");
		}

	}
}