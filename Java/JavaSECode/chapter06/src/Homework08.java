//给一个不多于5位的正整数
//要求:
//    1.求它是几位数
//    2.逆序打印出各位数字
import java.util.Scanner;

public class Homework08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个不多于5位的正整数:");
        String num = s.nextLine();
        byte[] strs = num.getBytes();
        int len = strs.length;
        System.out.println(num + "是" + len + "位数");
        for(int i = (len - 1); i >=0; i--){
            System.out.print((char)strs[i]);
        }
    }
}
