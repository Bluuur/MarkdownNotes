//私有方法不能覆盖
public class OverrideTest06 {
    private void doSome(){
        System.out.println("doSome from private method");
    }

    public static void main(String[] args) {
        OverrideTest06 t = new T();
        t.doSome();
    }
}

class T extends OverrideTest06{
    public void doSome(){//访问权限不能更低,可以更高
        System.out.println("doSome from extended  method");
    }
}
