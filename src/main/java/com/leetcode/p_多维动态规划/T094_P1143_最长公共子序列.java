package com.leetcode.p_多维动态规划;

/**
 * LeetCode #1143 - 最长公共子序列 难度: 中等
 *
 * <p>题目描述: 给定两个字符串 text1 和 text2 ，返回这两个字符串的最长 公共子序列 的长度。 如果不存在公共子序列 ，返回 0 。
 *
 * <p>解题思路: 动态规划：dp[i][j] 表示 text1[0..i-1] 和 text2[0..j-1] 的最长公共子序列长度 - 如果 text1[i-1] ==
 * text2[j-1]，dp[i][j] = dp[i-1][j-1] + 1 - 否则 dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 *
 * <p>时间复杂度: O(m*n) 空间复杂度: O(m*n)
 */
public class T094_P1143_最长公共子序列 {

  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    T094_P1143_最长公共子序列 solution = new T094_P1143_最长公共子序列();

    // 测试用例
    System.out.println("测试1: " + solution.longestCommonSubsequence("abcde", "ace") + " (期望: 3)");
    System.out.println("测试2: " + solution.longestCommonSubsequence("abc", "abc") + " (期望: 3)");
    System.out.println("测试3: " + solution.longestCommonSubsequence("abc", "def") + " (期望: 0)");
  }
}
