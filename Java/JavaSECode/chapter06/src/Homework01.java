//����1000���ڲ��ܱ�7����������֮��
public class Homework01 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0; i <= 1000; i++){
            if(i % 7 != 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
