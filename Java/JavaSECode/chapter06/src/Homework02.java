//计算 1+2-3+4-5+6-7...+100的结果
public class Homework02 {
    public static void main(String[] args) {
        int result = 1;
        for(int i = 2; i <= 100; i++){
            if (i % 2 == 1) {
                result -= i;
            } else {
                result += i;
            }
        }
        System.out.println(result);
    }
}
