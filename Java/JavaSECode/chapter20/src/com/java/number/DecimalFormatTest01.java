/*
 *  DecimalFormatTest01.java, 2021-04-14
 *
 *  Copyright (c) 2021.  ZiDong Zh All Rights Reserved.
 */

package com.java.number;

import java.text.DecimalFormat;
/*
    数字格式有哪些：
        # 代表任意数字
        , 代表千分位
        . 代表小数点
        0 不够时补上0
 */
public class DecimalFormatTest01 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###.##");
        String s = df.format(123123.456456);
        System.out.println(s);
    }
}
