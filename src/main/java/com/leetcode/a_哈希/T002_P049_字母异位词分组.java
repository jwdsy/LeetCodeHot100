package com.leetcode.a_哈希;

import java.util.*;

/**
 * LeetCode #49 - 字母异位词分组 难度: 中等
 *
 * <p>题目描述: 给定一个字符串数组 strs，将其中所有的字母异位词（由相同字母重排列形成的字符串）组合在一起。
 *
 * <p>示例: 示例 1: 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"], 输出: [["bat"], ["nat", "tan"],
 * ["ate", "eat", "tea"]]
 *
 * <p>解题思路: 字母异位词排序后相同。 1. 创建哈希表，键为排序后的字符串 2. 遍历字符串数组，对每个字符串排序 时间复杂度: O(n*k*log k)，空间复杂度: O(n*k)
 */
public class T002_P049_字母异位词分组 {

    public static void main(String[] args) {
        T002_P049_字母异位词分组 solution = new T002_P049_字母异位词分组();

        // 测试示例: strs = ["eat","tea","tan","ate","nat","bat"]
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println("输入: strs = [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]");
        System.out.println("输出: " + result);
    }

    // 解题代码
    public List<List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, List<String>> map = new java.util.HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            java.util.Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            map.computeIfAbsent(sortedStr, k -> new java.util.ArrayList<>()).add(str);
        }
        return new java.util.ArrayList<>(map.values());
    }
}
