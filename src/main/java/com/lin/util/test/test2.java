package com.lin.util.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxiaojia
 * @date 2022/4/9 10:29
 * @Description:
 */
public class test2 {

    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6);
        var r = list.stream().filter(it -> {
            if (it == 2){
                return true;
            }else if (it == 4){
                return true;
            }else return false;
        }).collect(Collectors.toList());
        System.out.println(r);
    }
}
