package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution22 {

    public static List<String> generateParenthesis(int n) {
        Set<String> stringSet = fun1(n);
        return new ArrayList<>(stringSet);
    }

    public static Set<String> fun1(int n){
        Set<String> set = new HashSet<>();
        if (n == 1) {
            set.add("()");
            return set;
        } else {
            Set<String> strings = fun1(n - 1);
            for(String str:strings){
                set.add("()" + str);
                set.add(str + "()");
                set.add("(" + str + ")");
            }
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4).size());
    }
}
