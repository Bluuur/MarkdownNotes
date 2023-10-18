import java.util.Scanner;

//输出指定模型
public class Homework05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个正整数:");
        int lineNo = s.nextInt();
        for(int line = 1; line <= lineNo; line++){
            for(int spaceNum = 1; spaceNum <= (lineNo - line); spaceNum++){
                System.out.print(" ");
            }
            for(int starNum = 1; starNum <= (2 * line - 1); starNum++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
