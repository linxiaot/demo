package com.lin.util.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxiaojia
 * @date 2023/2/16 11:03
 * @Description:
 */
public class LeetCode76最小覆盖子串 {

    public static void main(String[] args) {
        String s = "EBBANCF";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        int left = 0, right = 0, start = 0, len = Integer.MAX_VALUE, vaild = 0;
        // 将t的字符都放到need中计数
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while(right < s.length()){
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内的更新操作
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))){
                    vaild++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(vaild == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        vaild--;
                    }
                    if(window.containsKey(d)){
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
