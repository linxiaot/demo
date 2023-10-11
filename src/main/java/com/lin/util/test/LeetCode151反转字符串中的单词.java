package com.lin.util.test;

/**
 * @author liuxiaojia
 * @date 2023/2/15 11:40
 * @Description:
 */
public class LeetCode151反转字符串中的单词 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = trimSpace(s);
        reverse(sb, 0, sb.length() - 1);
        reverseChar(sb);
        return sb.toString();
    }

    // 反转单词
    public static void reverseChar(StringBuilder sb){
        int start = 0, end = 0, length = sb.length();
        while(start < length){
            // 计算单词的结尾
            while(end < length && sb.charAt(end) != ' '){
                end++;
            }
            // 反转局部单词
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    // 反转整个字符串
    public static void reverse(StringBuilder sb, int left, int right){
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    // 头尾去除空格，以及中间去除多余的空格
    public static StringBuilder trimSpace(String s){
        int left = 0, right = s.length() - 1;
        // 去除头空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        // 去除末尾空格
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            // 去除中间多余的空格
            if (s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }
}
