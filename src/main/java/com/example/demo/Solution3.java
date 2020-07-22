package com.example.demo;

import java.util.HashSet;
import java.util.Set;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:

        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {


    public static int lengthOfLongestSubstring1(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<String> valueSets = new HashSet<>();
            valueSets.add(String.valueOf(s.charAt(i)));
            int length = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (valueSets.contains(String.valueOf(s.charAt(j)))) {
                    break;
                } else {
                    valueSets.add(String.valueOf(s.charAt(j)));
                    length += 1;
                }

            }
            maxLength = maxLength > length ? maxLength : length;
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        Set<String> valueSets = new HashSet<>();
        int rk = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                valueSets.remove(String.valueOf(s.charAt(i-1)));
            }
            while (rk < s.length() && !valueSets.contains(String.valueOf(s.charAt(rk)))) {
                valueSets.add(String.valueOf(s.charAt(rk)));
                rk++;
            }
            length = rk - i;
            maxLength = maxLength > length ? maxLength : length;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(Solution3.lengthOfLongestSubstring("pwwkew"));
    }
}
