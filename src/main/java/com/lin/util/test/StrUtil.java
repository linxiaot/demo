package com.lin.util.test;

import java.nio.charset.StandardCharsets;

/**
 * @author liuxiaojia
 * @date 2022/4/9 09:53
 * @Description:
 */
public class StrUtil {

    public static void main(String[] args) {
        String s1 = new String("123".getBytes(StandardCharsets.UTF_8));
        String s2 = new String("123".getBytes(StandardCharsets.UTF_16BE));
        System.out.println(s1.equals(s2));
    }
}
