///*
//    导致空指针最本质的原因
//        空引用访问“实例相关的数据（实例变量、实例方法（不带static的方法））”
//*/
//
//
//public class NullPointerTest{
//    public static void main(String[] args) {
//        User u = new User();
//        System.out.println(u.id);
//        u.doSome();
//
//        u = null;
////        System.out.println(u.id);
////        u.doSome();//实例方法，需要由对象来执行，这里这个引用u没有指向对象，所以报错
//    }
//}
//class User{
//    int id;
//
//    public void doSome(){
//        System.out.println("do some");
//    }
//}