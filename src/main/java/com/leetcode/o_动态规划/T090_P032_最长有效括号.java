package com.leetcode.o_动态规划;

import java.util.Stack;

/**
 * LeetCode #32 - 最长有效括号 难度: 困难
 *
 * <p>题目描述: 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * <p>解题思路: 使用栈或动态规划。这里使用栈的方法：栈中保存上一个未匹配的')'的索引
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(n)
 */
public class T090_P032_最长有效括号 {

    public static void main(String[] args) {
        T090_P032_最长有效括号 solution = new T090_P032_最长有效括号();

        // 测试用例1
        System.out.println("测试1: " + solution.longestValidParentheses("(()")); // 2

        // 测试用例2
        System.out.println("测试2: " + solution.longestValidParentheses(")()())")); // 4

        // 测试用例3
        System.out.println("测试3: " + solution.longestValidParentheses("")); // 0

        // 测试用例4
        System.out.println("测试4: " + solution.longestValidParentheses("()(()")); // 2
    }

    /**
     * 使用栈的方法
     *
     * @param s 括号字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        // 初始位置-1，表示无效的起始位置
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 遇到')'，弹出栈顶
                stack.pop();
                if (stack.isEmpty()) {
                    // 栈为空，说明当前')'无法匹配，记录位置
                    stack.push(i);
                } else {
                    // 计算有效括号长度
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    /**
     * 动态规划方法
     *
     * @param s 括号字符串
     * @return 最长有效括号长度
     */
    public int longestValidParenthesesDP(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int maxLen = 0;
        // dp[i] 表示以 i 结尾的最长有效括号长度
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 情况1: "...()" 形式
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 情况2: "...))" 形式
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }
}
