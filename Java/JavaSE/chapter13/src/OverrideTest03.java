public class OverrideTest03 {
    public static void main(String[] args) {
        Chinese p1 = new Chinese();
        p1.setName("����");
        p1.speak();

        American p2 = new American();
        p2.setName("Jack");
        p2.speak();
    }
}

//��
class People{
    //����
    private String name;
    //���췽��
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

    //˵������
    public void speak(){
        System.out.println("����˵��");
    }
}

//�й���
class Chinese extends People{
    @Override
    public void speak() {
        System.out.println(this.getName() + "����˵����");
    }
}

class American extends People{
    @Override
    public void speak() {
        System.out.println(this.getName() + "����˵Ӣ��");
    }
}