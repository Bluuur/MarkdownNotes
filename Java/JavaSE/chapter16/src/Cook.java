// �˿�
class Customer{
    // �˿�������һ���˵�
    // Customer has a FoodMenu!����仰ʲô��˼���˿���һ���˵���
    // ��ס���Ժ����ܹ�ʹ�� has a �������ģ�ͳһ�����Եķ�ʽ���ڡ�
    // ʵ������������
    // ��������̣�����ӿڱ�̡����ͳ������϶ȣ���߳������չ����
    private FoodMenu foodMenu;

    // �����������д���ͱ�ʾд���ˣ������ˡ�û�пɲ���ˡ���
    // �вͳ�ʦ
    //ChinaCooker cc;

    // ���ͳ�ʦ
    //AmericaCooker ac

    // ���췽��
    public Customer(){
    }
    public Customer(FoodMenu foodMenu){
        this.foodMenu = foodMenu;
    }

    // setter and getter
    public void setFoodMenu(FoodMenu foodMenu){
        this.foodMenu = foodMenu;
    }
    public FoodMenu getFoodMenu(){
        return foodMenu;
    }

    // �ṩһ����˵ķ���
    public void order(){
        // ���õ��˵����ܵ��
        // ����get�����ò˵���
        //FoodMenu fm = this.getFoodMenu();
        // Ҳ���Բ�����get��������Ϊ�ڱ�����˽�е������ǿ��Է���
        foodMenu.shiZiChaoJiDan();
        foodMenu.yuXiangRouSi();
    }
}

/*
	�ӿڣ��˵��������
*/
interface FoodMenu{

    // ����������
    void shiZiChaoJiDan();

    // ������˿
    void yuXiangRouSi();

}

//���ͳ�ʦ
// ʵ�ֲ˵��ϵĲ�
// ��ʦ�ǽӿڵ�ʵ���ߡ�
class AmericaCooker implements FoodMenu{

    // ����������
    public void shiZiChaoJiDan(){
        System.out.println("����ʦ��������������������");
    }

    // ������˿
    public void yuXiangRouSi(){
        System.out.println("����ʦ������������˿��");
    }
}

//�вͳ�ʦ
// ʵ�ֲ˵��ϵĲ�
// ��ʦ�ǽӿڵ�ʵ���ߡ�
class ChinaCooker implements FoodMenu{

    // ����������
    public void shiZiChaoJiDan(){
        System.out.println("�в�ʦ��������������������������ζ��");
    }

    // ������˿
    public void yuXiangRouSi(){
        System.out.println("�в�ʦ������������˿��������ζ��");
    }
}

public class Cook{
    public static void main(String[] args){

        // ������ʦ����
        //FoodMenu cooker1 = new ChinaCooker();
        FoodMenu cooker1 = new AmericaCooker();

        // �����˿Ͷ���
        Customer customer = new Customer(cooker1);

        // �˿͵��
        customer.order();
    }
}


/*
	Cat is a Animal����������is a�ı�ʾ����������Ϊ�̳С�
	Customer has a FoodMenu������������has a�ı�ʾ�������Ե���ʽ���ڡ�
*/



/*
class Address{
	String city;
	String street;
	String zipcode;
}

class User{
	int id;

	// �����һ����
	// String��һ���ࡣ
	// name�Ǳ�������
	// name��һ�����á�
	String name;

	// Address��һ��������
	// �����һ��������
	// ʵ��������
	Address addr; // addr��һ�����á���һ��������

	public static void main(String[] args){
		// �ֲ�����
		//Address addr;
		//addr = new Address();

		// �ϲ���
		Address addr = new Address();

		User u = new User();
		u.id = 100;
		u.name = "zhangsan";
		u.addr = new Address();

		System.out.println(u.addr.city); // null
		System.out.println(u.addr.street); // null
		System.out.println(u.addr.zipcode); // null
	}
}





//���Լ�����
// MySelf has a Friend;
class MySelf{
	// ���������Ӧ����һ�����Ѷ���ĵ绰���롣
	// �绰�������һ��������ڴ��ַ����ϵ�����ѵ�ʱ�򣬴�绰��
	// f��һ�����á�fĬ��ֵ��null����null��ʾ����û�����ѡ�
	Friend f;

	public MySelf(){
	
	}
	//ͨ�����췽���ܲ��ܸ���һ�����Ѷ���
	public MySelf(Friend f){
		this.f = f;
	}

	public static void main(String[] args){
		// �������Ѷ���
		Friend f = new Friend(); //���Ѷ�������

		// ���������ͬʱ�����ѡ�
		MySelf m2 = new MySelf(f);


		// �����Լ�����
		// Ŀǰ��û�н����ѡ�
		MySelf m = new MySelf(); //�Լ�����
		// ������
		m.f = f; // �����ѵĵ�ַ�����㡣
	}
}

// �����ѡ���
class Friend{

}

*/