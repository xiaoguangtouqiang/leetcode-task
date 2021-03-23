package com.example.demo;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
        示例 1：输入: "babad"
        输出: "bab"
        注意: "aba" 也是一个有效答案。
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        int begin = 0;
        int maxLength = 1;
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLength && isHuiWen(s, i, j)) {
                    begin = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    private boolean isHuiWen(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("cbbd"));
    }

}
