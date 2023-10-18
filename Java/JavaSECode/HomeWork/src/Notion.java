/*
 *  Notion.java, 2021-04-22
 *
 *  Copyright (c) 2021.  ZiDong Zh All Rights Reserved.
 */

//去掉字符串中的美元符号

import java.util.Scanner;

public class Notion {
    public static void main(String[] args) {
        while (true){
            String in = "";
            System.out.print("输入：");
            Scanner s = new Scanner(System.in);
            in = s.next();

            char[] strs = in.toCharArray();
            String out = "";
            for (int i = 0; i < strs.length; i++) {
                if(strs[i] == ' '){
                    continue;
                }
                out += strs[i];
            }
            System.out.println(out);
        }
    }
}

