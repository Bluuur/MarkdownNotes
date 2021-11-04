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
    //错误:Cat07中的sum(int, int)无法堵盖Animal07中的sum(int,int)
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
    //Java中允许这种语法,返回的对象类型变小
    //但是开发中不会这样用
    @Override
    public Cat07 getAnimal() {
        return null;
    }
}