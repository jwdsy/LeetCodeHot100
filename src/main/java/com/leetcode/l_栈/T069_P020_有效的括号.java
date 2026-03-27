package com.leetcode.l_栈;

import java.util.*;

/**
 * LeetCode #20 - 有效的括号 难度: 简单
 *
 * <p>题目描述: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s，判断字符串是否有效。
 *
 * <p>示例: 示例 1: 输入: s = "()", 输出: true 示例 2: 输入: s = "()[]{}", 输出: true
 *
 * <p>解题思路: 栈：遇到左括号入栈，遇到右括号与栈顶匹配 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T069_P020_有效的括号 {

    public static void main(String[] args) {
        T069_P020_有效的括号 solution = new T069_P020_有效的括号();

        String s = "()[]{}";
        boolean result = solution.isValid(s);
        System.out.println("输入: s = \"()[]{}\"");
        System.out.println("输出: " + result);
    }

    // 解题代码
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
