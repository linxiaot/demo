package com.lin.util;

import java.math.BigDecimal;

/**
 * @author liuxiaojia
 * @date 2022/4/9 10:29
 * @Description:
 */
public class test2 {

    public static void main(String[] args) {
        BigDecimal one = BigDecimal.ONE;
        one.multiply(BigDecimal.ONE.add(BigDecimal.ONE));
        System.out.println(one);
    }
}
