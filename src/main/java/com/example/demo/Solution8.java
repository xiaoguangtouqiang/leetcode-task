package com.example.demo;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution8 {
    public static int myAtoi(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        String a = "-+0123456789";
        String b = "0123456789";
        int k = 1;
        int result = 0;
        boolean neg = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (k == 1 && c == ' ') {
                continue;
            } else if (k == 1) {
                if (a.indexOf(c) == -1) {
                    return 0;
                } else if (c == '-') {
                    neg = true;
                } else if (c == '+') {
                    neg = false;
                } else {
                    neg = false;
                    result = Integer.parseInt(c + "");
                }
                k++;
            } else if (b.indexOf(c) == -1) {
                return result;
            } else {
                if (!neg) {
                    if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && Integer.parseInt(c + "") >= 7)
                        return Integer.MAX_VALUE;
                    else {
                        result = 10 * result + Integer.parseInt(c + "") * 1;
                    }
                } else {
                    if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && Integer.parseInt(c + "") > 8)
                        return Integer.MIN_VALUE;
                    else {
                        result = 10 * result + Integer.parseInt(c + "") * -1;
                    }
                }
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
