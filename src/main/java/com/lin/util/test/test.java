package com.lin.util.test;

import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        List<person> list = new ArrayList<>();
        list.add(new person(1L, null));
        list.add(new person(2L, "1"));
        list.add(new person(1L, "2"));
        List<String> names = list.stream().map(person::getName).collect(Collectors.toList());
        System.out.println(names);

        var num = BigDecimal.ONE.divide(new BigDecimal(7), 11, RoundingMode.HALF_UP);
        System.out.println(num);
        var num2 = num.multiply(new BigDecimal(7)).setScale(10, RoundingMode.HALF_UP);
        System.out.println(num2);

        var person = new person(1L,"22");
        var immutableList = ImmutableList.of(person);
    }

    static class person{
        private Long id;

        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public person(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
