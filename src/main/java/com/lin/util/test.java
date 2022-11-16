package com.lin.util;

/**
 * @author liuxiaojia
 * @date 2022/4/9 10:29
 * @Description:
 */
public class test {

    public static void main(String[] args) {
        String s1 = new String("1");
        String string = s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);
        int i = 1;
        int y = i++;
        System.out.println(y);
    }
}
