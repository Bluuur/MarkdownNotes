public class OverrideTest02 {
    public static void main(String[] args) {
        NewBird b = new NewBird();
        b.move();
    }
}

class NewAnimal{
    public void move(){
        System.out.println("�������ƶ�");
    }
}

class NewBird extends Animal00 {
    //��move�������з�������
    public void move(){
        System.out.println("���ڷ�");
    }
}