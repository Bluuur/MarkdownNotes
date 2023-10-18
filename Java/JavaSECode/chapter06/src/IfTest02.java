/*
	要求：
		1.从键盘上接受一个人的年龄
		2.年龄要求为[0-150]，其他值表示非法，需要提示非法信息
		3.根据人的年龄来动态判断这个人属于生命的哪个阶段
			[0-5]婴幼儿
			[6-10]少儿
			[11-18]少年
			[19-35]青年
			[36-55]中年
			[56-150]老年
*/
public class IfTest02{
	public static void main(String[] args){
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("请输入你的年龄（0-150）：");
		int userAge = s.nextInt();

		if(userAge >= 0 && userAge <=150){
			if(userAge <= 5){
				System.out.println("您处于婴幼儿阶段");
			}else if(userAge <=10){
				System.out.println("您处于少儿阶段");
			}else if(userAge <= 18){
				System.out.println("您处于少年阶段");
			}else if(userAge <= 35){
				System.out.println("您处于青年阶段");
			}else if(userAge <= 55){
				System.out.println("您处于中年阶段");
			}else if(userAge >= 56){
				System.out.println("您处于老年阶段");
			}
		}else{
			System.out.println("您输入的数字非法，请重新运行此程序并输入合法数字");
		}

		//也可以不使用if嵌套
		if(userAge < 0 || userAge >150){
			System.out.println("您输入的数字非法，请重新运行此程序并输入合法数字");
		}else if(userAge <= 5){
			System.out.println("您处于婴幼儿阶段");
		}else if(userAge <=10){
			System.out.println("您处于少儿阶段");
		}else if(userAge <= 18){
			System.out.println("您处于少年阶段");
		}else if(userAge <= 35){
			System.out.println("您处于青年阶段");
		}else if(userAge <= 55){
			System.out.println("您处于中年阶段");
		}else if(userAge >= 56){
			System.out.println("您处于老年阶段");

		}

		//还可以进一步改良
		String str = "老年";
		if(userAge < 0 || userAge >150){
			System.out.println("您输入的数字非法，请重新运行此程序并输入合法数字");
			return;//后面会学到，让程序在这里终止，以免再输出后面的打印
		}else if(userAge <= 5){
			str = "婴幼儿";
		}else if(userAge <=10){
			str = "少儿";
		}else if(userAge <= 18){
			str = "少年";
		}else if(userAge <= 35){
			str = "青年";
		}else if(userAge <= 55){
			str = "中年";
		}
		System.out.println("您处于" + str + "阶段");
	}
}