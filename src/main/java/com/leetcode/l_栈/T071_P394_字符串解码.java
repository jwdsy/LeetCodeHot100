package com.leetcode.l_栈;

import java.util.Stack;

/**
 * LeetCode #394 - 字符串解码 难度: 中等
 *
 * <p>题目描述: 给定一个经过编码的字符串，返回它解码后的字符串。 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k
 * 次。
 *
 * <p>解题思路: 使用栈，遇到数字累积，遇到'['入栈保存当前字符串和数字，遇到']'出栈解码
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(n)
 */
public class T071_P394_字符串解码 {

    public static void main(String[] args) {
        T071_P394_字符串解码 solution = new T071_P394_字符串解码();

        // 测试用例
        System.out.println("测试1: " + solution.decodeString("3[a2[c]]")); // accaccacc
        System.out.println("测试2: " + solution.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
        System.out.println("测试3: " + solution.decodeString("abc3[cd]xyz")); // abccdcdcdxyz
    }

    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 累积数字
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // 入栈
                numStack.push(currentNum);
                strStack.push(currentStr);
                currentNum = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                // 出栈解码
                int repeatTimes = numStack.pop();
                StringBuilder temp = currentStr;
                currentStr = strStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    currentStr.append(temp);
                }
            } else {
                // 普通字符
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}
