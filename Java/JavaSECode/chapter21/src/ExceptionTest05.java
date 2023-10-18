public class ExceptionTest05 {
    //一种方式，在main方法继续上抛
    /*
    public static void main(String[] args) throws ClassNotFoundException{
        doSome();
    }

     */

    //第二种方式：try...catch进行捕捉
    public static void main(String[] args) {
        try {
            doSome();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
}
    public static void doSome() throws ClassNotFoundException{
        System.out.println("do some!");
    }
}
