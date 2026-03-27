package com.leetcode.n_贪心算法;

import java.util.*;

/**
 * LeetCode #763 - 划分字母区间 难度: 中等
 *
 * <p>题目描述: 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段， 同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * <p>解题思路: 两遍扫描： 1. 第一遍：记录每个字符最后出现的位置 2. 第二遍：遍历字符串，维护当前片段的右边界，当到达右边界时划分片段
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(1) - 26个字符
 */
public class T080_P763_划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        // 记录每个字符最后出现的位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // 到达当前片段的右边界
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        T080_P763_划分字母区间 solution = new T080_P763_划分字母区间();

        // 测试用例
        System.out.println(
                "测试1: " + solution.partitionLabels("ababcbacadefegdehijhklij") + " (期望: [9,7,8])");
        System.out.println("测试2: " + solution.partitionLabels("eccbbbbdec") + " (期望: [10])");
    }
}
