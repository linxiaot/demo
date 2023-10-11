package com.lin.util.test;

import java.util.Iterator;
import java.util.List;

/**
 * @author liuxiaojia
 * @date 2022/4/9 10:30
 * @Description:
 */
public class test4 {

    public static void main(String[] args) {
        var list1 = List.of(1,2,3,4);
        var list2 = List.of(2,3,4,5);
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()){
            var i = iterator.next();
            if (i == 2){
                System.out.println(i);
                continue;
            }
            for (int j : list2){
                System.out.println(j);
                if (j == 4) break;
            }
        }
    }
}
