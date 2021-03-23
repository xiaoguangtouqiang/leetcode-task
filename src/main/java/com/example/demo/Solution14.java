package com.example.demo;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        String str = "";
        if (strs.length == 0) {
            return str;
        }
        if (strs.length < 2) {
            return strs[0];
        }
        int i = 0;
        String temp = "";
        Boolean stop = false;
        while (!stop) {
            if (strs[0].length() == 0) {
                return "";
            }
            if (i == strs[0].length()) {
                return strs[0];
            }
            temp = strs[0].charAt(i) + "";
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length()) {
                    stop = true;
                    return strs[0].substring(0, i);
                }
                if (!(strs[j].charAt(i) + "").equals(temp)) {
                    stop = true;
                    return strs[0].substring(0, i );
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
