//һ�������ǡ�õ�����������֮��,�������������,���� 6 = 1 + 2 +3
//�ҳ�1000�������е�����
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
