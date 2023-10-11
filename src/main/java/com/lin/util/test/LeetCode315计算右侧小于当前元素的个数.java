package com.lin.util.test;

import java.util.Arrays;

/**
 * @author liuxiaojia
 * @date 2023/2/21 10:43
 * @Description:
 */
public class LeetCode315计算右侧小于当前元素的个数 {

    public static class Pair{
        private int val;
        private int index;
        Pair(){

        }

        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    static Pair[] temp;
    static int[] count;

    public static void sort(int[] nums){
        temp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] arr = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(nums[i], i);
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Pair[] arr, int lo, int hi){
        if(lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public static void merge(Pair[] arr, int lo, int mid, int hi){
        for(int i = lo; i <= hi; i++){
            temp[i] = arr[i];
        }
        int left = lo, right = mid + 1;
        for(int i = lo; i <= hi; i++){
            if(left == mid + 1){
                arr[i] = temp[right++];
            }else if(right == hi + 1){
                arr[i] = temp[left++];
                count[arr[i].index] += right - mid - 1;
            }else if(temp[left].val > temp[right].val){
                arr[i] = temp[right++];
            }else{
                arr[i] = temp[left++];
                count[arr[i].index] += right - mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        sort(nums);
        System.out.println(Arrays.toString(count));
    }
}
