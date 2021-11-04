 public class C16Test02 {
     public static void main(String[] args) {
         Flyable f2 = new C16Cat();
     }
}

class C16Animal {

}

interface Flyable{
    void fly();
}

class C16Cat extends C16Animal implements Flyable{

    @Override
    public void fly() {
        System.out.println("Ã¨Æð·É");
    }
}

class Snake extends C16Animal{

}