//使用for循环,实现1~100所有奇数求和
public class ForTest04 {
    public static void main(String[] args) {
        //方案1
//        int u = 0;
//        for (int i = 1; i < 100; i += 2){
//            u = u + i;
//        }
//        System.out.println(u);

        //方案2
        //先找出100以内全部奇数
        //奇数的特点:对2求余数结果为1
        int sum = 0;
        for (int i =0; i <= 100; i++){
            if(i % 2 == 1){
                sum += i;
            }
        }
        System.out.println(sum);
    }//方案1循环次数少,效率更高
}
