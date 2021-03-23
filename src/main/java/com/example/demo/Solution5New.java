package com.example.demo;

/**
 * 最长回文子串，使用动态规划思路解决
 */
public class Solution5New {
    public String longestPalindrome(String s) {
        boolean[][] aa = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            aa[i][i] = true;
        }
        int begin = 0;
        int maxLength = 1;
        if (s.length() < 2) {
            return s;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    aa[i][j] = false;
                    //长度小于3，是回文字符串
                } else if (j - i <= 2 || aa[i + 1][j - 1]) {
                    aa[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLength );
    }

    public static void main(String[] args) {
        Solution5New solution5New = new Solution5New();
        System.out.println(solution5New.longestPalindrome("aa"));
        System.out.println("aaa");
    }
}