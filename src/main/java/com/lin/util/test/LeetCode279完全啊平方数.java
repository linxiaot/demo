package com.lin.util.test;

/**
 * @author liuxiaojia
 * @date 2022/11/29 10:29
 * @Description:
 */
public class LeetCode279完全啊平方数 {

    public static void main(String[] args) {
        int res = numSquares(5);
        System.out.println(res);
    }

    public static int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

}
