public class IntTest05{
	public static void main(String[] args){
		
		byte b = (byte)150;	//150超出byte取值范围，不能直接赋值，需要强制类型转换
		System.out.println(b);
		//此处输出-106
	}
}