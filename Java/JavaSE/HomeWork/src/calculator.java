import java.util.Scanner;

public class calculator {
    static Scanner s = new Scanner(System.in);
    static float[] data;
    static boolean flag = true;
    public static void main(String[] args) {
        float result = 0.0F;
        System.out.println("计算平均值请输入： \"Aver\"");
        System.out.println("计算A类标准不确定度请输入： \"A\"");
        System.out.println("计算B类标准不确定度请输入： \"B\"");
        System.out.println("计算合成标准不确定度请输入： \"M\"");
        while(flag){
            System.out.print("请输入需要使用的公式：");
            String tar = s.nextLine();

            System.out.print("请输入需要处理的数据个数：");
            int num = s.nextInt();
            System.out.println("依次输入需要计算的数据");
            for(int i = 1; i <= num; i++){
                System.out.print("输入数据"+i+":");
                float[] temp = new float[data.length+1];
                for (int j = 0; j < data.length; j++){
                    temp[j] = data[j];
                }
                temp[data.length+1] = s.nextFloat();
                data = temp;
            }
            for(int i = 0; i < data.length; i++){
                System.out.println(data[i]);
            }

            switch(tar){
                case "Aver":
                    result = aver();
                    System.out.println("平均值为:" + result);
                    break;
                case "A":
                    break;
                case "b":
                    break;
                case "M":
                    break;
                default:
                    System.out.println("找不到该命令,请输入正确命令!");
                    System.out.println("计算平均值请输入： \"Aver\"");
                    System.out.println("计算A类标准不确定度请输入： \"A\"");
                    System.out.println("计算B类标准不确定度请输入： \"B\"");
                    System.out.println("计算合成标准不确定度请输入： \"M\"");
            }
            ask();
        }
    }

    public static float aver(){
        int sum = 0;
        System.out.print("数据个数：");
        int num = s.nextInt();
        System.out.println("依次输入需要计算的数据");
        for(int i = 1; i <= num; i++){
            System.out.print("输入数据"+i+":");
            sum += s.nextFloat();
        }
        float result = sum / num;
        return result;
    }

    public static boolean ask(){
        System.out.print("是否继续进行计算？(Y/N):");
        switch (s.nextLine()){
            case "Y":
                flag = true;
                break;
            case "N":
                flag = false;
            default:
                System.out.println("请输入Y或N!");
        }
        return flag;
    }
}


