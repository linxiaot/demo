package com.lin.util;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liuxiaojia
 * @date 2022/4/9 10:29
 * @Description:
 */
public class test2 {

    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6);
        var listq = List.of(7,8,9,10,11,12);
        for (int i : list){
            System.out.println(i);
            if (i == 5) continue;
            for (int j : listq){
                if (j == 9){
                    break;
                }
            }
        }
    }
}
