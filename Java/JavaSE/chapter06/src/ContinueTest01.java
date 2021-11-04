/*
    continue语句的作用:终止当前本次循环,直接进入下一循环

    与break一样,continue也可以指定循环
 */

public class ContinueTest01 {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++){
            if(i == 5){
                break;
            }
            System.out.println(i);
        }

        System.out.println("-----------------------------");

        for(int i = 0; i < 10; i++){
            if(i == 5){
                continue;//表示本次循环只会执行到此，continue语句后的程序不再执行，直接跳到下一次循环
            }
            System.out.println(i);
        }

    }
}
