public class OverrideTest07 {
    public static void main(String[] args) {

    }
}

class Animal07{
    public double sum(int a,int b){
        return a + b;
    }
}

class Cat07 extends Animal07{
    //����:Cat07�е�sum(int, int)�޷��¸�Animal07�е�sum(int,int)
    /*
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
    */
}

class MyClass1{
    public Animal07 getAnimal(){
        return null;
    }
}

class MyClass2 extends MyClass1{
    //Java�����������﷨,���صĶ������ͱ�С
    //���ǿ����в���������
    @Override
    public Cat07 getAnimal() {
        return null;
    }
}