//ʹ��forѭ��,ʵ��1~100�����������
public class ForTest04 {
    public static void main(String[] args) {
        //����1
//        int u = 0;
//        for (int i = 1; i < 100; i += 2){
//            u = u + i;
//        }
//        System.out.println(u);

        //����2
        //���ҳ�100����ȫ������
        //�������ص�:��2���������Ϊ1
        int sum = 0;
        for (int i =0; i <= 100; i++){
            if(i % 2 == 1){
                sum += i;
            }
        }
        System.out.println(sum);
    }//����1ѭ��������,Ч�ʸ���
}
