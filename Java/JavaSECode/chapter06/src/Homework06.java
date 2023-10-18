//小明的妈妈每天给他2.5元,他都会存起来;但是,没定这一台你是存钱的第5天或者5的背书的话
//他都会去花掉6元,请问,经过多少天,小明次啊可以存到100元?
public class Homework06 {
    public static void main(String[] args) {
        double moneySum = 0;
        int day = 1;
        for(; moneySum < 100.0; day++){
            moneySum += 2.5;
            if(day % 5 == 0){
                moneySum -= 6.0;
            }
        }
        System.out.println(day);
    }
}
