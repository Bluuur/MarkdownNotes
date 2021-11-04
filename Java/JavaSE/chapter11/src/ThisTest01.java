///*
//    this:
//        1.this是一个关键字，全部小写
//        2.this的内存
//            一个对象，一个this
//            this是一个变量，是引用
//            this指向自身的内存地址：”我指我自己“
//            所以，严格意义上来说，this代表的就是”当前对象“
//            this存储在堆内存中对象的内部
//        3.this只能使用在实例方法中，谁调用这个实例方法，this就是谁
//            所以this代表的是：当前对象
//        4.”this.“在大部分情况下是可以省略的
//        5.为什么this不能使用在静态方法中
//            this代表的是当前对象，而静态方法的调用不需要对象,bu
// */
//public class ThisTest01 {
//    public static void main(String[] args) {
//        Customer c1 = new Customer("张三");
//        Customer c2 = new Customer("李四");
//    }
//}
//
//class Customer{
//    //属性
//    String name;
//
//    //构造方法
//    public Customer(){
//
//    }
//
//    public Customer(String s){
//        name = s;
//    }
//
//    //顾客购物的方法
//    //实例方法
//    public void  shopping(){
//        System.out.println(name + "正在购物！");//这里访问了实例变量
//        //为什么不是”引用.name“的形式？
//        //实际上这里应该是”this.name“，在这里，this可以省略不写
//    }
//
//    //静态方法
//    public static void doSome(){
//        System.out.println("do some");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
////什么时候定义实例变量，什么时候定义静态变量
////  如果方法中直接访问了实例变量，该方法必须是实例方法
