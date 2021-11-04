import java.util.Scanner;

public class RecursionHW {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个整数，将计算其阶乘:");
        int i = s.nextInt();
        //for循环
        int result = 1;
        for(int l = i; l >0; l--){
            result *= l;
        }
        System.out.println(result);


        System.out.println(recur(5));
    }

    //方法递归
    public static int recur(int i){
        if(i == 1){
            return 1;
        }
        return i *= recur(i-1);
    }
}
