/*
    continue��������:��ֹ��ǰ����ѭ��,ֱ�ӽ�����һѭ��

    ��breakһ��,continueҲ����ָ��ѭ��
 */

public class ContinueTest01 {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++){
            if(i == 5){
                break;
            }
            System.out.println(i);
        }

        System.out.println("-----------------------------");

        for(int i = 0; i < 10; i++){
            if(i == 5){
                continue;//��ʾ����ѭ��ֻ��ִ�е��ˣ�continue����ĳ�����ִ�У�ֱ��������һ��ѭ��
            }
            System.out.println(i);
        }

    }
}
