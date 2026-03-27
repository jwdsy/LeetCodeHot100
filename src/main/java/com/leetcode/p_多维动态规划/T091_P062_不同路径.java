package com.leetcode.p_多维动态规划;

/**
 * LeetCode #62 - 不同路径 难度: 中等
 *
 * <p>题目描述: 一个机器人位于一个 m x n 网格的左上角。机器人每次只能向下或者向右移动一步。 机器人试图达到网格的右下角。问总共有多少条不同的路径？
 *
 * <p>解题思路: 动态规划：dp[i][j] 表示到达位置 (i,j) 的路径数 dp[i][j] = dp[i-1][j] + dp[i][j-1] 空间优化：使用一维数组
 *
 * <p>时间复杂度: O(m*n) 空间复杂度: O(n)
 */
public class T091_P062_不同路径 {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        T091_P062_不同路径 solution = new T091_P062_不同路径();

        // 测试用例
        System.out.println("测试1: " + solution.uniquePaths(3, 7) + " (期望: 28)");
        System.out.println("测试2: " + solution.uniquePaths(3, 2) + " (期望: 3)");
    }
}
