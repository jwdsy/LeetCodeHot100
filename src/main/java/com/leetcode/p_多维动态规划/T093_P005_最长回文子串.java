package com.leetcode.p_多维动态规划;

/**
 * LeetCode #5 - 最长回文子串 难度: 中等
 *
 * <p>题目描述: 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * <p>解题思路: 方法1：中心扩展法。遍历每个位置，向两边扩展，检查是否为回文 方法2：动态规划。dp[i][j] 表示 s[i..j] 是否为回文 这里使用方法1（中心扩展）更简洁
 *
 * <p>时间复杂度: O(n^2) 空间复杂度: O(1)
 */
public class T093_P005_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // 奇数长度回文
            int len1 = expandAroundCenter(s, i, i);
            // 偶数长度回文
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        T093_P005_最长回文子串 solution = new T093_P005_最长回文子串();

        // 测试用例
        System.out.println("测试1: " + solution.longestPalindrome("babad") + " (期望: bab 或 ada)");
        System.out.println("测试2: " + solution.longestPalindrome("cbbd") + " (期望: bb)");
    }
}
