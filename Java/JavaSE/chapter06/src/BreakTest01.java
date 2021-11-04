/*
    break语句：
        break是由一个单词构成的一个完整java语句
        break只能用在两个地方
            第一个位置:switch语句中,用来终止switch语句的执行
            第二个位置:在循环语句中,用来终止循环的执行
                for
                while
                do...while
        break语句的执行不会让整个方法结束,只会让距离它最近的那一个循环语句结束
 */

public class BreakTest01 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            if(i == 5){
                //break语句会终止距离break最近的一个循环
                break;
            }
            System.out.println("i = " + i);
        }

        //以下语法在实际开发中很少用到
        //下面两个for魂环的嵌套中,如果想要里层for循环中的break语句结束外层的for循环,可以给每个循环起名字
        a:for (int k = 0; k < 2; k++){
            b:for (int i = 0; i < 10; i++){
                if(i == 5){
                    break a;//终止指定的循环
                }
                System.out.println(i);
            }
        }
    }
}
