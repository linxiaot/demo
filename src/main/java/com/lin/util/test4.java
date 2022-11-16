package com.lin.util;

/**
 * @author liuxiaojia
 * @date 2022/4/9 10:30
 * @Description:
 */
public class test4 {

    {
        System.out.println("我是初始化");
    }
    static {
        System.out.println("我是静态初始化");
    }

    public static void main(String[] args) {
        test4 t = new test4();
    }
}
