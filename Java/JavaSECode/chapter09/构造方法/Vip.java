public class Vip{
	
	//会员号
	long no;
	
	//会员姓名
	String name;
	
	//生日
	String birthday;
	
	//性别
	boolean gender;
	
	//无参数构造方法
	public Vip(){
		
	}

	//有参数构造方法
	public Vip(long huiYuanHao, String xingMing){
		//给实例变量赋值（初始化）
		no = huiYuanHao;
		name = xingMing;
		//这里只有两个形参
		//剩余没有手动赋值的都会赋默认值

	}

	//有参数构造方法
	public Vip(long huiYuanHao, String xingMing, String shengRi){
		no = huiYuanHao;
		name = xingMing;
		birthday = shengRi;
	}

	public Vip(long huiYuanHao, String xingMing, String shengRi, boolean xingBie){
		no = huiYuanHao;
		name = xingMing;
		birthday = shengRi;
		gender = xingBie;
	}
}