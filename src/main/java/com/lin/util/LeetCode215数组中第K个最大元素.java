package com.lin.util;

/**
 * @author liuxiaojia
 * @date 2023/2/22 10:19
 * @Description:
 */
public class LeetCode215数组中第K个最大元素 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int num = findKthLargest(nums, 2);
        System.out.println(num);
    }

    public static int findKthLargest(int[] nums, int k) {
        // 快速排序
        quickSort(nums, 0 ,nums.length - 1);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int lo, int hi){
        if(lo >= hi) return;
        int p = partition(nums, lo, hi);
        quickSort(nums, lo, p - 1);
        quickSort(nums, p + 1, hi);
    }

    public static int partition(int[] nums, int lo, int hi){
        int pivot = nums[lo];
        int left = lo + 1, right = hi;
        while(left <= right){
            while(left < hi && nums[left] < pivot){
                left++;
            }
            while(right > lo && nums[right] > pivot){
                right--;
            }
            if(left >= right) break;
            swap(nums, left, right);
        }
        swap(nums, lo, right);
        return right;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
