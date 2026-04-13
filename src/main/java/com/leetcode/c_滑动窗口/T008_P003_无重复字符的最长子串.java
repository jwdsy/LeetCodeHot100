package com.leetcode.c_滑动窗口;

import java.util.*;

/**
 * LeetCode #3 - 无重复字符的最长子串 难度: 中等
 *
 * <p>题目描述: 给定字符串s，找出其中不含有重复字符的最长子串的长度。
 *
 * <p>示例: 示例 1: 输入: s = "abcabcbb", 输出: 3 示例 2: 输入: s = "bbbbb", 输出: 1 示例 3: 输入: s = "pwwkew", 输出: 3
 *
 * <p>解题思路: 滑动窗口 + 哈希集合：右指针右移，遇重复左指针右移。 时间复杂度: O(n)，空间复杂度: O(min(m,n))
 */
public class T008_P003_无重复字符的最长子串 {

    public static void main(String[] args) {
        T008_P003_无重复字符的最长子串 solution = new T008_P003_无重复字符的最长子串();

        // 测试示例: s = "abcabcbb"
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("输入: s = \"abcabcbb\"");
        System.out.println("输出: " + result);
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring2(s);
    }

    // 方法1：枚举起点并用集合判重（时间 O(n^2)，空间 O(n)）
    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (seen.contains(c)) {
                    break;
                }
                seen.add(c);
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    // 方法2：滑动窗口 + 哈希集合（最优解法，时间 O(n)，空间 O(min(m,n))）
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                // 左边界不断右移，直到窗口内不再有重复字符
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
