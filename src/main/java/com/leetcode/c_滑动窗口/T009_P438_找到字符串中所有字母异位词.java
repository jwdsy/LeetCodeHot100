package com.leetcode.c_滑动窗口;

import java.util.*;

/**
 * LeetCode #438 - 找到字符串中所有字母异位词 难度: 中等
 *
 * <p>题目描述: 给定两个字符串 s 和 p，在 s 中找出所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * <p>示例: 示例 1: 输入: s = "cbaebabacd", p = "abc", 输出: [0, 6] 示例 2: 输入: s = "abab", p = "ab", 输出: [0,
 * 1, 2]
 *
 * <p>解题思路: 滑动窗口 + 数组统计字符频率 1. 统计 p 中每个字符的出现次数 2. 使用固定长度的滑动窗口，窗口长度等于 p 的长度 3. 比较窗口内字符频率与 p 的字符频率
 * 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T009_P438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        T009_P438_找到字符串中所有字母异位词 solution = new T009_P438_找到字符串中所有字母异位词();

        // 测试示例: s = "cbaebabacd", p = "abc"
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println("输入: s = \"cbaebabacd\", p = \"abc\"");
        System.out.println("输出: " + result);
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public List<Integer> findAnagrams(String s, String p) {
        return findAnagrams2(s, p);
    }

    // 方法1：对子串排序后比较（时间 O((n-m+1)*m*logm)，空间 O(m)）
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> startIndices = new ArrayList<>();
        if (s.length() < p.length()) return startIndices;
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String sortedP = new String(pChars);
        int windowLength = p.length();
        for (int windowStart = 0; windowStart <= s.length() - windowLength; windowStart++) {
            char[] windowChars = s.substring(windowStart, windowStart + windowLength).toCharArray();
            Arrays.sort(windowChars);
            if (sortedP.equals(new String(windowChars))) {
                startIndices.add(windowStart);
            }
        }
        return startIndices;
    }

    // 方法2：滑动窗口 + 频次数组（最优解法，时间 O(n)，空间 O(1)）
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> startIndices = new ArrayList<>();
        if (s.length() < p.length()) return startIndices;

        int[] targetFrequency = new int[26];
        int[] windowFrequency = new int[26];

        // 统计 p 中字符频率
        for (char c : p.toCharArray()) {
            targetFrequency[c - 'a']++;
        }

        int patternLength = p.length();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            // 加入窗口
            windowFrequency[s.charAt(windowEnd) - 'a']++;

            // 移除窗口外的字符
            if (windowEnd >= patternLength) {
                int windowStart = windowEnd - patternLength;
                windowFrequency[s.charAt(windowStart) - 'a']--;
            }

            // 26 个字母的频次数组相同，说明当前窗口是一个异位词
            if (windowEnd >= patternLength - 1 && Arrays.equals(targetFrequency, windowFrequency)) {
                startIndices.add(windowEnd - patternLength + 1);
            }
        }
        return startIndices;
    }
}
