package com.lin.util.test;

/**
 * @author liuxiaojia
 * @date 2023/3/14 17:06
 * @Description:
 */
public class LeetCode698划分为k个相等的子集 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        boolean res = canPartitionKSubsets(nums, 4);
        System.out.println(res);
    }

    static int[] buck;
    static int target;
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        buck = new int[k];
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        // 结果必须除的尽，否则必不可平均分配
        if(sum % k != 0) return false;
        target = sum / k;
        return backtrack(nums, 0);
    }

    public static boolean backtrack(int[] nums, int index){
        if (index == nums.length){
            for (int j : buck) {
                if (j != target) {
                    return false;
                }
            }
            return true;
        }
        for(int i = 0; i < buck.length; i++){
            if (buck[i] + nums[index] > target){
                continue;
            }
            buck[i] += nums[index];
            if (backtrack(nums, index + 1)){
                return true;
            }
            buck[i] -= nums[index];
        }
        return false;
    }

}
