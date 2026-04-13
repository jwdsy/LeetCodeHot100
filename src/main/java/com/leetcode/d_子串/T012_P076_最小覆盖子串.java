package com.leetcode.d_子串;

import java.util.*;

/**
 * LeetCode #76 - 最小覆盖子串 难度: 困难
 *
 * <p>题目描述: 给你两个字符串 s 和 t，找出 s 中包含 t 所有字符的最小子串。
 *
 * <p>示例: 示例 1: 输入: s = "ADOBECODEBANC", t = "ABC", 输出: "BANC" 示例 2: 输入: s = "a", t = "a", 输出: "a"
 * 示例 3: 输入: s = "a", t = "aa", 输出: ""
 *
 * <p>解题思路: 滑动窗口 1. 哈希表记录 t 中字符的需求 2. 双指针扩展右窗口直到满足条件 3. 收缩左窗口寻找最小解 时间复杂度: O(m+n)，空间复杂度: O(1)
 */
public class T012_P076_最小覆盖子串 {

    public static void main(String[] args) {
        T012_P076_最小覆盖子串 solution = new T012_P076_最小覆盖子串();

        // 测试示例: s = "ADOBECODEBANC", t = "ABC"
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println("输入: s = \"ADOBECODEBANC\", t = \"ABC\"");
        System.out.println("输出: \"" + result + "\"");
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public String minWindow(String s, String t) {
        return minWindow2(s, t);
    }

    // 方法1：枚举左端点并扩展右端点（时间 O(n^2)，空间 O(1)）
    public String minWindow1(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        int[] requiredCount = new int[128];
        for (char c : t.toCharArray()) {
            requiredCount[c]++;
        }
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;
        for (int left = 0; left < s.length(); left++) {
            int[] windowCount = new int[128];
            for (int right = left; right < s.length(); right++) {
                windowCount[s.charAt(right)]++;
                if (containsAll(windowCount, requiredCount)) {
                    if (right - left + 1 < bestLen) {
                        bestLen = right - left + 1;
                        bestStart = left;
                    }
                    break;
                }
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    // 方法2：滑动窗口（最优解法，时间 O(m+n)，空间 O(1)）
    public String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] requiredCount = new int[128];
        int[] windowCount = new int[128];

        for (char c : t.toCharArray()) {
            requiredCount[c]++;
        }

        // 计算 t 中不同字符的种数
        int requiredTypes = 0;
        for (int count : requiredCount) {
            if (count > 0) requiredTypes++;
        }

        int left = 0;
        int right = 0;
        int matchedTypes = 0;
        int bestStart = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            if (requiredCount[rightChar] > 0) {
                windowCount[rightChar]++;
                if (windowCount[rightChar] == requiredCount[rightChar]) {
                    matchedTypes++;
                }
            }

            while (matchedTypes == requiredTypes) {
                if (right - left < minLen) {
                    bestStart = left;
                    minLen = right - left;
                }

                char leftChar = s.charAt(left);
                left++;

                if (requiredCount[leftChar] > 0) {
                    // 当前字符即将移出窗口，先判断是否会破坏覆盖条件
                    if (windowCount[leftChar] == requiredCount[leftChar]) {
                        matchedTypes--;
                    }
                    windowCount[leftChar]--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + minLen);
    }

    private boolean containsAll(int[] windowCount, int[] requiredCount) {
        for (int index = 0; index < requiredCount.length; index++) {
            if (windowCount[index] < requiredCount[index]) {
                return false;
            }
        }
        return true;
    }
}
