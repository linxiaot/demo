package com.lin.util;

import java.util.Arrays;

/**
 * @author liuxiaojia
 * @date 2022/11/15 09:39
 * @Description:
 */
public class LeetCode75颜色分类 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length - 1;
        int i = 0;
        while(i <= two){
            if(nums[i] == 0){
                zero++;
                swap(nums, i ,zero);
                i++;
            }else if(nums[i] == 1){
                i++;
            }else {
                swap(nums, i, two);
                two--;
            }
        }
    }

    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
