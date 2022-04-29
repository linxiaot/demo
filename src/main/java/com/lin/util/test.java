package com.lin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxiaojia
 * @date 2022/4/9 10:29
 * @Description:
 */
public class test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> integers = list.stream().filter(it -> it.equals(2))
            .collect(Collectors.toList());
        list.add(4);
    }
}
