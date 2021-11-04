public class OverrideTest05 {
    public static void main(String[] args) {
        fatherC c = new sonC();
        c.doSome();
    }
}

class fatherC{
    public static void doSome(){
        System.out.println("do some");
    }
}

class sonC extends fatherC{
    public static void doSome(){
        System.out.println("do some method from sonC");
    }
}
