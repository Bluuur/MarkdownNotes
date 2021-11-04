/*
    while循环的语法机制以及执行原理
        语法机制
            while(布尔表达式){
                循环体;
            }
        执行原理
            先判断布尔表达式,如果布尔表达式为true则执行循环体
            循环体执行之后,再次判断布尔表达式

        while循环的次数可能为零次

        for循环:
            for(初始表达式; 布尔表达式; 更新表达式){
                循环体;
            }

        while循环可以达到for循环一样的效果:
            while(布尔表达式){
                循环体;
                更新表达式;
            }
 */

public class WhileTest01 {
    public static void main(String[] args) {
        int i = 0;
        while(i < 10){
            System.out.println("i = " + i);
            i++;
        }
    }
}
