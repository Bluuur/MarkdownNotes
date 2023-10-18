/*
 *  DecimalFormatTest01.java, 2021-04-14
 *
 *  Copyright (c) 2021.  ZiDong Zh All Rights Reserved.
 */

package com.java.number;

import java.text.DecimalFormat;
/*
    ���ָ�ʽ����Щ��
        # ������������
        , ����ǧ��λ
        . ����С����
        0 ����ʱ����0
 */
public class DecimalFormatTest01 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###.##");
        String s = df.format(123123.456456);
        System.out.println(s);
    }
}
