/*
    break��䣺
        break����һ�����ʹ��ɵ�һ������java���
        breakֻ�����������ط�
            ��һ��λ��:switch�����,������ֹswitch����ִ��
            �ڶ���λ��:��ѭ�������,������ֹѭ����ִ��
                for
                while
                do...while
        break����ִ�в�����������������,ֻ���þ������������һ��ѭ��������
 */

public class BreakTest01 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            if(i == 5){
                //break������ֹ����break�����һ��ѭ��
                break;
            }
            System.out.println("i = " + i);
        }

        //�����﷨��ʵ�ʿ����к����õ�
        //��������for�껷��Ƕ����,�����Ҫ���forѭ���е�break����������forѭ��,���Ը�ÿ��ѭ��������
        a:for (int k = 0; k < 2; k++){
            b:for (int i = 0; i < 10; i++){
                if(i == 5){
                    break a;//��ָֹ����ѭ��
                }
                System.out.println(i);
            }
        }
    }
}
