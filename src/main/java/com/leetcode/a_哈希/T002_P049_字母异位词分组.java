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

    // 对外保留原方法名，默认调用最优解法（方法2）
    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagrams2(strs);
    }

    // 方法1：排序后作为 key（时间 O(n*k*logk)，空间 O(n*k)）
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> sortedKeyToGroup = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            sortedKeyToGroup.computeIfAbsent(sortedWord, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(sortedKeyToGroup.values());
    }

    // 方法2：字符频次数组编码（最优解法，时间 O(n*k)，空间 O(n*k)）
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> frequencyKeyToGroup = new HashMap<>();
        for (String str : strs) {
            int[] characterFrequency = new int[26];
            for (int index = 0; index < str.length(); index++) {
                characterFrequency[str.charAt(index) - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
                // 使用分隔符避免频次拼接歧义，例如 1|11 与 11|1
                keyBuilder.append('#').append(characterFrequency[letterIndex]);
            }
            String frequencyKey = keyBuilder.toString();
            frequencyKeyToGroup.computeIfAbsent(frequencyKey, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(frequencyKeyToGroup.values());
    }
}
