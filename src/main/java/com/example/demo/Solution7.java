package com.example.demo;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution7 {
    public static int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int yushu = x % 10;
            if (r > Integer.MAX_VALUE / 10 || r == Integer.MAX_VALUE / 10 && yushu > 7) {
                return 0;
            }
            if (r < Integer.MIN_VALUE / 10 || r == Integer.MIN_VALUE / 10 && yushu < -8) {
                return 0;
            }
            r = r * 10 + yushu;
            x = x / 10;
        }
        return r;
    }

    public static void main(String[] args) {
        int i = 1;
        long result = 1;
        while (i < 32) {
            result = result * 2;
            i++;
        }
        System.out.println(result - 1);
        System.out.println(reverse(1534236469));
        System.out.println("ttt");
    }
}
