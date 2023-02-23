package com.lin.util;

import java.util.Stack;

/**
 * @author liuxiaojia
 * @date 2023/2/17 11:31
 * @Description:
 */
public class LeetCode316去除重复字母 {

    public static void main(String[] args) {
        String s = "bccdda";
        String res = removeDuplicateLetters(s);
        System.out.println(res);
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];
        for(char c : s.toCharArray()){
            count[c]--;
            if(inStack[c]) continue;
            while(!stack.isEmpty() && stack.peek() > c){
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
