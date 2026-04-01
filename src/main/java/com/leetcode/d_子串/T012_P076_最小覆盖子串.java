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

    // 解题代码
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        // 计算 t 中不同字符的种数
        int required = 0;
        for (int cnt : need) {
            if (cnt > 0) required++;
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            while (valid == required) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need[d] > 0) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
