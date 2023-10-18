//一个数如果恰好等于它的因子之和,这个数就是完数,例如 6 = 1 + 2 +3
//找出1000以内所有的完数
public class Homework07 {
    public static void main(String[] args) {
        for(int i = 1; i <=1000; i++ ){
            int sum = 0;
            for(int factor =1; factor < i; factor++){
                if(i % factor == 0){
                    sum += factor;
                }
            }
            if(sum == i){
                System.out.println(i);
            }
        }
    }
}
