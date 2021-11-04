public class Constructor03{
	public static void main(String[] args){
		//调用不同的方法创建对象
		Vip v1 = new Vip();
		Vip v2 = new Vip(11111L, "blur");
		Vip v3 = new Vip(11111L, "Blur", "0906");
		Vip v4 = new Vip(12533L, "zzd", "0826", true);
		
		Constructor03.DaYin(v1);
		System.out.println("---------------");
		Constructor03.DaYin(v2);
		System.out.println("---------------");
		Constructor03.DaYin(v3);
		System.out.println("---------------");
		Constructor03.DaYin(v4);
	}
	
	public static void DaYin(Vip p){
		System.out.println("Vip number:" + p.no);
		System.out.println("Vip name:" + p.name);
		System.out.println("Vip birthday:" + p.birthday);
		System.out.println("Vip gender:" + p.gender);
	}
}