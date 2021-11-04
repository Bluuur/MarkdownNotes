public class gpaevaluate{
	public static void main(String[] args){
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("请输入你的成绩：");
		double score = s.nextDouble();
		if (score >= 0 && score <= 100){
			if (score <= 59){
				System.out.println("你的成绩等级为F");
				System.out.println("GPA为0.00");
			}else if (score <=63){
				System.out.println("你的成绩等级为D");
				System.out.println("GPA为1.00");
			}else if (score <= 67){
				System.out.println("你的成绩等级为C-");
				System.out.println("GPA为1.50");
			}else if (score <= 71){
				System.out.println("你的成绩等级为C");
				System.out.println("GPA为2.00");
			}else if (score <= 74){
				System.out.println("你的成绩等级为C+");
				System.out.println("GPA为2.30");
			}else if (score <= 77){
				System.out.println("你的成绩等级为B-");
				System.out.println("GPA为2.70");
			}else if (score <= 81){
				System.out.println("你的成绩等级为B");
				System.out.println("GPA为3.00");
			}else if (score <= 84){
				System.out.println("你的成绩等级为B+");
				System.out.println("GPA为3.30");
			}else if (score <= 89){
				System.out.println("你的成绩等级为A-");
				System.out.println("GPA为3.70");
			}else if (score <= 100){
				System.out.println("你的成绩等级为A");
				System.out.println("GPA为4.00");
				if(score >90){
					System.out.println("多考" + (int)(score - 90) + "分浪费 雾");
				}else{
					System.out.println("多考1分浪费 少考1分受罪 雾");
					}
			}
		}else{
			System.out.println("你输入的成绩不合法，请重新运行此程序并输入合法成绩");
		}

	}
}