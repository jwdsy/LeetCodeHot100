package com.leetcode.p_多维动态规划;

/**
 * LeetCode #72 - 编辑距离 难度: 困难
 *
 * <p>题目描述: 给你两个单词 word1 和 word2，请你返回将 word1 转换成 word2 所使用的最少操作数。 你可以对一个单词进行如下三种操作： - 插入一个字符 -
 * 删除一个字符 - 替换一个字符
 *
 * <p>解题思路: 动态规划：dp[i][j] 表示 word1[0..i-1] 转换为 word2[0..j-1] 的最少操作数 - 如果 word1[i-1] ==
 * word2[j-1]，dp[i][j] = dp[i-1][j-1] - 否则 dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
 * 分别对应：删除、插入、替换
 *
 * <p>时间复杂度: O(m*n) 空间复杂度: O(m*n)
 */
public class T095_P072_编辑距离 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // dp[i][j]: word1前i个字符转换为word2前j个字符的最少操作数
        int[][] dp = new int[m + 1][n + 1];

        // 初始化：空字符串转换
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] =
                            1
                                    + Math.min(
                                    Math.min(dp[i - 1][j], dp[i][j - 1]), // 删除或插入
                                    dp[i - 1][j - 1] // 替换
                            );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        T095_P072_编辑距离 solution = new T095_P072_编辑距离();

        // 测试用例
        System.out.println("测试1: " + solution.minDistance("horse", "ros") + " (期望: 3)");
        System.out.println("测试2: " + solution.minDistance("intention", "execution") + " (期望: 5)");
    }
}
