//��һ��������5λ��������
//Ҫ��:
//    1.�����Ǽ�λ��
//    2.�����ӡ����λ����
import java.util.Scanner;

public class Homework08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("������һ��������5λ��������:");
        String num = s.nextLine();
        byte[] strs = num.getBytes();
        int len = strs.length;
        System.out.println(num + "��" + len + "λ��");
        for(int i = (len - 1); i >=0; i--){
            System.out.print((char)strs[i]);
        }
    }
}
