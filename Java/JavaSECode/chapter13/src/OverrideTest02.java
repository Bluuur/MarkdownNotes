public class OverrideTest02 {
    public static void main(String[] args) {
        NewBird b = new NewBird();
        b.move();
    }
}

class NewAnimal{
    public void move(){
        System.out.println("动物在移动");
    }
}

class NewBird extends Animal00 {
    //对move方法进行方法覆盖
    public void move(){
        System.out.println("鸟在飞");
    }
}