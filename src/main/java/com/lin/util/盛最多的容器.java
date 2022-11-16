package com.lin.util;

/**
 * @author liuxiaojia
 * @date 2022/9/2 10:18
 * @Description:
 */
public class 盛最多的容器 {

    public static void main(String[] args) {
        int[] ints = {1, 4, 5, 7, 9, 9, 6};
        int area = maxArea(ints);
        System.out.println(area);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left < right){
            int area = Math.min(height[left] , height[right]) * (right - left);
            ans = Math.max(ans , area);
            if(height[left] <= height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return ans;
    }

}
