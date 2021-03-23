package com.example.demo;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String a[][] = new String[numRows][s.length()];
        int i = 0, j = 0;
        int current = 0;
        boolean isShuzhe = true;
        while (current < s.length()) {
            a[i][j] = s.charAt(current) + "";
            current++;
            if (isShuzhe) {
                if (i + 1 == numRows) {
                    isShuzhe = false;
                    i--;
                    j++;
                } else {
                    i++;
                }
            } else {
                if (i == 0) {
                    isShuzhe = true;
                    i++;
                } else {
                    i--;
                    j++;
                }
            }
        }
        String result = "";
        for (int t = 0; t < numRows; t++) {
            for (int k = 0; k < j + 1; k++) {
                if (null != a[t][k]) {
                    result += a[t][k];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
