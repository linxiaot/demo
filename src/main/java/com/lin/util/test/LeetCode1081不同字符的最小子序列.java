package com.lin.util.test;

import java.util.Stack;

/**
 * @author liuxiaojia
 * @date 2023/4/19 17:05
 * @Description:
 */
public class LeetCode1081不同字符的最小子序列 {

    public static void main(String[] args) {
        String res = smallestSubsequence("bcbca");
        System.out.println(res);
    }

    public static String smallestSubsequence(String s) {
        // 定义一个栈
        Stack<Character> stack = new Stack<>();
        // 定义一个计数器
        int[] count = new int[256];
        // 计算每个字母出现的次数
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        // 定义一个数组，用来查看字母是否在栈内
        boolean[] inStack = new boolean[256];
        for(char c : s.toCharArray()){
            // 每次循环都让次数减1
            count[c]--;
            // 如果在栈中就跳过本次
            if(inStack[c]) continue;
            // 如果栈不为空，且栈顶元素大于当前字符，则将栈顶元素出栈
            while(!stack.isEmpty() && stack.peek() > c){
                // 如果数量都为0，则说明已经循环过进栈了，则不做处理
                if(count[stack.peek()] == 0){
                    break;
                }
                char d = stack.pop();
                inStack[d] = false;
            }
            stack.add(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
