/*
    �Ȳ�ʹ�õݹ�,��д�������1-n�ĺ�
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
