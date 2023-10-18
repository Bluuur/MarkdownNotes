import java.util.Scanner;

//从控制台接受一个正整数，判断该数字是否为质数
public class Homework04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个正整数:");
        int i = s.nextInt();
        if(i == 1 || i ==2) {//如果输入的是1或2,直接提示是质数,并终止程序
            System.out.println(i + "是质数");
            return;
        }
        for(int k = 2; k < i; k++){//进行到此步,说明输入的不是1或2,在此循环体内,将i本身和1以外,比i本身小的正胜数与i做求模运算
            if(i % k == 0){
                System.out.println(i + "不是质数");
                return;
            }
        }
        System.out.println(i + "是质数");
    }
}
