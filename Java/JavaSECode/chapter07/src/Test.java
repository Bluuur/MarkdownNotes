import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        double first = 0;

        double third = 0;

        double num;
        for (first = 1; first <= 9; first++) {
            for (third = 0; third <= 9; third++) {
                if (first == third) {
                    continue;
                } else {
                    num = first * 1100 + third * 11;
                    System.out.println(num);
                    for (int i = 1; i < 100; i++) {
                        if ((num / i) == i) {
                            System.out.println(i);
                            System.out.println(num);
                            return;
                        }
                    }
                }
            }
        }
    }
}




