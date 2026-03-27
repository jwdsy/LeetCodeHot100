package com.leetcode.j_回溯;

import java.util.*;

/**
 * LeetCode #131 - 分割回文串 难度: 中等
 *
 * <p>题目描述: 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。 返回 s 所有可能的分割方案。
 *
 * <p>解题思路: 使用回溯算法。枚举每个起始位置，尝试向右扩展， 如果当前子串是回文，则加入路径并递归处理剩余部分。
 *
 * <p>时间复杂度: O(n * 2^n) - 最多 2^n 种分割方式，每种需要 O(n) 判断 空间复杂度: O(n) - 递归深度
 */
public class T061_P131_分割回文串 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        result.clear();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int start, List<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        T061_P131_分割回文串 solution = new T061_P131_分割回文串();

        // 测试用例
        List<List<String>> result1 = solution.partition("aab");
        System.out.println("测试1: " + result1.size() + " 种分割 (期望: 2)");

        List<List<String>> result2 = solution.partition("a");
        System.out.println("测试2: " + result2 + " (期望: [[a]])");
    }
}
