import java.util.Scanner;

//�ӿ���̨����һ�����������жϸ������Ƿ�Ϊ����
public class Homework04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("������һ��������:");
        int i = s.nextInt();
        if(i == 1 || i ==2) {//����������1��2,ֱ����ʾ������,����ֹ����
            System.out.println(i + "������");
            return;
        }
        for(int k = 2; k < i; k++){//���е��˲�,˵������Ĳ���1��2,�ڴ�ѭ������,��i�����1����,��i����С����ʤ����i����ģ����
            if(i % k == 0){
                System.out.println(i + "��������");
                return;
            }
        }
        System.out.println(i + "������");
    }
}
