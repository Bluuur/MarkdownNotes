//С��������ÿ�����2.5Ԫ,�����������;����,û����һ̨���Ǵ�Ǯ�ĵ�5�����5�ı���Ļ�
//������ȥ����6Ԫ,����,����������,С���ΰ����Դ浽100Ԫ?
public class Homework06 {
    public static void main(String[] args) {
        double moneySum = 0;
        int day = 1;
        for(; moneySum < 100.0; day++){
            moneySum += 2.5;
            if(day % 5 == 0){
                moneySum -= 6.0;
            }
        }
        System.out.println(day);
    }
}
