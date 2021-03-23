package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution17 {
    public static List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String c = digits.charAt(i) + "";
            String s = map.get(c);
            if (result.size() == 0) {
                for (Character strtemp : s.toCharArray()) {
                    result.add(strtemp + "");
                }
            } else {
                List<String> result1 = new ArrayList<>();
                for (String str : result) {
                    for (Character strtemp : s.toCharArray()) {
                        result1.add(str + strtemp);
                    }
                }
                result = result1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }
}
