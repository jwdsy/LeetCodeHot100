package com.leetcode.o_动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode #139 - 单词拆分 难度: 中等
 *
 * <p>题目描述: 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * <p>解题思路: 完全背包问题，dp[i] 表示 s 的前 i 个字符是否可以被拆分。转移方程: dp[i] = dp[i] || (dp[j] && set.contains(s.substring(j, i)))
 *
 * <p>时间复杂度: O(n^2) 空间复杂度: O(n)
 */
public class T086_P139_单词拆分 {

    public static void main(String[] args) {
        T086_P139_单词拆分 solution = new T086_P139_单词拆分();

        // 测试用例1
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("测试1: s=leetcode, 结果=" + solution.wordBreak("leetcode", wordDict1)); // true

        // 测试用例2
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("测试2: s=applepenapple, 结果=" + solution.wordBreak("applepenapple", wordDict2)); // true

        // 测试用例3
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("测试3: s=catsandog, 结果=" + solution.wordBreak("catsandog", wordDict3)); // false
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] 表示 s 的前 i 个字符是否可以被拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果前 j 个字符可以拆分，且 s[j,i) 在字典中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
