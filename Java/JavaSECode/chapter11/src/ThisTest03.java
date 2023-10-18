///*
//    1.this可以使用在实例方法中，不能使用在静态方法中
//    2.this关键字大部分情况下可以省略
//        this什么情况下不能省略
// */
//public class ThisTest03 {
//    public static void main(String[] args) {
//        Student s = new Student();
//        s.setNo(111);
//        s.setName("张三");
//
//        System.out.println("学号：" + s.getNo());
//        System.out.println("姓名：" + s.getName());
//
//        Student s2 = new Student(2222, "李四");
//        System.out.println("学号：" + s2.getNo());
//        System.out.println("姓名：" + s2.getName());
//    }
//}
//class Student{
//    //学号
//    private int no;
//    //姓名
//    private String name;
//    //构造方法有参
//    public Student(int no, String name) {
//        this.no = no;
//        this.name = name;
//    }
//    //构造方法无参
//    public Student() {
//    }
//
//    public int getNo() {
//        return no;
//    }
//
//    public void setNo(int no) {//为增强可读性，做到见名知意，这里形参的名字是no
//        this.no = no;//如果直接写no = no，这里会就近，把输入的实参no赋给no自己
//        //所以要用this.no = no，这种情况下this不可省略
//    }
//
//    public String getName() {
//        return name;//这里的this可以省略
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
