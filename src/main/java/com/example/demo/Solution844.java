package com.example.demo;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Solution844 {
    public static boolean backspaceCompare(String S, String T) {
        return removeBuild(S).equals(removeBuild(T));
    }

    private static String removeBuild(String S) {
        Stack<Character> stack = new Stack<>();
        for (Character character : S.toCharArray()) {
            if (character != '#') {
                stack.push(character);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        String S = "#", T = "a#";
        System.out.println(backspaceCompare(S, T));
    }
}
