package com.lin.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaojia
 * @date 2022/11/15 15:07
 * @Description:
 */
public class LeetCode78子集 {
    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

}
