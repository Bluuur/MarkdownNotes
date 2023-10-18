/*
    先不使用递归,编写程序计算1-n的和
 */
public class RecursionTest02 {
    public static void main(String[] args) {

    }

    public static int addRecursion(int n){
        if(n == 1){
            return 1;
        }
        return n + addRecursion(n - 1);
    }

    public static int addition(int n){
        int result = 0;
        for (int i = 1; i <= n; i++){
            result += i;
        }
        return result;
    }
}
