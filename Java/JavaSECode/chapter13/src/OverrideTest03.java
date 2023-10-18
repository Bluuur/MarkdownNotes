public class OverrideTest03 {
    public static void main(String[] args) {
        Chinese p1 = new Chinese();
        p1.setName("张三");
        p1.speak();

        American p2 = new American();
        p2.setName("Jack");
        p2.speak();
    }
}

//人
class People{
    //属性
    private String name;
    //构造方法
    public People(){}
    public People(String name){
        this.name = name;
    }

    //setter and getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //说话方法
    public void speak(){
        System.out.println("正在说话");
    }
}

//中国人
class Chinese extends People{
    @Override
    public void speak() {
        System.out.println(this.getName() + "正在说汉语");
    }
}

class American extends People{
    @Override
    public void speak() {
        System.out.println(this.getName() + "正在说英语");
    }
}