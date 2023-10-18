/*
 *  test.java, 2021-05-26
 *
 *  Copyright (c) 2021.  ZiDong Zh All Rights Reserved.
 */

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Random random = new Random();

        Scanner s = new Scanner(System.in);

        while (true){
            if(random.nextBoolean()){
                int x = random.nextInt(50);
                int y = random.nextInt(50);
                System.out.println( x + "+" + y + "= ?");
                int result = s.nextInt();
                if(result == x + y){
                    System.out.println("¶Ô");
                }else {
                    System.out.println("´í");
                }
            }else {
                for (int i = 0; i < 3; i++) {
                    int x = random.nextInt(50);
                    int y = random.nextInt(50);
                    if(x > y && (x % 10) >= (y % 10)){
                    }else{
                        continue;
                    }
                    System.out.println(x + "-" + y + "= ?");
                    int result = s.nextInt();;
                    if(result == (x - y)){
                        System.out.println("¶Ô");
                    }else {
                        System.out.println("´í");
                    }

                }
            }
        }
    }
}
