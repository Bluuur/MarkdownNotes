//�ӿ���̨����һ������������������Ľ׳�
import java.util.Scanner;

public class Homework03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a inteager:");
        int i = s.nextInt();
        int result = 1;
        for(int k = 1; k <= i; k++){
            result *= k;
        }
        System.out.println(result);
    }
}