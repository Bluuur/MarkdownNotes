/*
    do...while循环语句的执行原理及语法机制
        语法机制
            do{
                循环体;
            }while(布尔表达式);
        注意:do...while循环最后要有分号

        执行原理
            限制性循环体中的代码,执行一次循环体之后,判断布尔表达式的结果,如果为true
            则继续执行循环体,如果为false,循环结束

        对于do...while循环来说,循环体至少执行一次,循环体执行的次数是1~n次
        对于while循环来说,循环体执行次数是0~n次
 */

public class DoWhileTest01 {
    public static void main(String[] args) {
//        int i = 0;
//        do {
//            System.out.println(i);
//            i++;
//              temp = i
//        }while (i < 10);
        int i = 0;
        do{
            System.out.println();
            ++i;
        }while(i < 10);

    }
}
