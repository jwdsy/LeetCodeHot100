package com.leetcode.o_动态规划;

/**
 * LeetCode #279 - 完全平方数 难度: 中等
 *
 * <p>题目描述: 给你一个整数 n，返回和为 n 的完全平方数的最少数量。 完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16
 * 都是完全平方数，而 3 和 11 不是。
 *
 * <p>解题思路: 动态规划，dp[i] = i 之前完全平方数的最少数量。转移方程: dp[i] = min(dp[i], dp[i - j*j] + 1)
 *
 * <p>时间复杂度: O(n*sqrt(n)) 空间复杂度: O(n)
 */
public class T084_P279_完全平方数 {

    public static void main(String[] args) {
        T084_P279_完全平方数 solution = new T084_P279_完全平方数();

        // 测试用例
        System.out.println("测试1: n=12, 结果=" + solution.numSquares(12)); // 3 (4+4+4)
        System.out.println("测试2: n=13, 结果=" + solution.numSquares(13)); // 2 (4+9)
    }

    public int numSquares(int n) {
        // dp[i] 表示和为i的完全平方数的最少数量
        int[] dp = new int[n + 1];
        // 初始化，dp[i] = i 表示最坏情况（全为1）
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        // 动态规划
        for (int i = 1; i <= n; i++) {
            // 遍历所有可能的完全平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
