/*
    �����ݹ�;
        �����Լ������Լ�

        �ݹ�û�н���������ʱ��,ջ�ڴ�����
            Exception in thread "main" java.lang.StackOverflowError
        ���Եݹ����Ҫ�н�������
        ����кϷ��Ľ�������,�ݹ�Ҳ���п��ܳ���ջ�ڴ��������,���ܵݹ��̫��,ջ�ڴ治��

        JVM��������֮��ֻ��һ�����:�˳�JVM

        ��ʵ�ʿ����Ĺ�����,����������ѡ��ݹ�,����forѭ��whileѭ���������,����ʹ��ѭ������
        ��Ϊѭ����Ч�ʸ�,�ķѵ��ڴ���
        �ݹ�ķѵ��ڴ�Ƚϴ�,����ݹ��ʹ�ò����ᵼ��JVM����

        �������ʹ�÷����ݹ�,ȷ�ϴ����������Ȼ�ڴ����
        ���Գ����ֶ�������JVM�ڴ�
        (DOS��ʹ��java -x����)
 */

public class RecursionTest01 {
    public static void main(String[] args) {
        doSome();
    }

    private static void doSome() {
        System.out.println("doSome method begin");
//        doSome();
        System.out.println("doSome method over");
    }
}
