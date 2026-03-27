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

  // 解题代码
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length()) return result;

    int[] pCount = new int[26];
    int[] sCount = new int[26];

    // 统计 p 中字符频率
    for (char c : p.toCharArray()) {
      pCount[c - 'a']++;
    }

    int pLen = p.length();
    for (int i = 0; i < s.length(); i++) {
      // 加入窗口
      sCount[s.charAt(i) - 'a']++;

      // 移除窗口外的字符
      if (i >= pLen) {
        sCount[s.charAt(i - pLen) - 'a']--;
      }

      // 比较频率
      if (i >= pLen - 1 && Arrays.equals(pCount, sCount)) {
        result.add(i - pLen + 1);
      }
    }
    return result;
  }
}
