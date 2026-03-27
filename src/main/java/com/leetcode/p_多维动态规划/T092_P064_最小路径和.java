package com.leetcode.p_多维动态规划;

/**
 * LeetCode #64 - 最小路径和 难度: 中等
 *
 * <p>题目描述: 给定一个包含非负整数的 m x n 网格 grid ，请计算从左上角到右下角的路径上的数字总和。 备注：每次只能向下或者向右移动一步。
 *
 * <p>解题思路: 动态规划：dp[i][j] 表示到达位置 (i,j) 的最小路径和 dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
 * 空间优化：使用一维数组
 *
 * <p>时间复杂度: O(m*n) 空间复杂度: O(n)
 */
public class T092_P064_最小路径和 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        T092_P064_最小路径和 solution = new T092_P064_最小路径和();

        // 测试用例
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("测试1: " + solution.minPathSum(grid1) + " (期望: 7)");

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("测试2: " + solution.minPathSum(grid2) + " (期望: 12)");
    }
}
