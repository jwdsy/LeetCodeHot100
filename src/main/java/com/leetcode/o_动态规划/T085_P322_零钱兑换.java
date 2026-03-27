package com.leetcode.o_动态规划;

/**
 * LeetCode #322 - 零钱兑换 难度: 中等
 *
 * <p>题目描述: 给你一个整数数组 coins，表示不同面额的硬币和一个整数 amount，表示总金额。 返回凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
 * -1。 你可以认为每种硬币的数量是无限的。
 *
 * <p>解题思路: 完全背包问题，dp[i] = 凑成金额i所需的最少硬币数。转移方程: dp[i] = min(dp[i], dp[i - coin] + 1)
 *
 * <p>时间复杂度: O(amount * n) 空间复杂度: O(amount)
 */
public class T085_P322_零钱兑换 {

    public static void main(String[] args) {
        T085_P322_零钱兑换 solution = new T085_P322_零钱兑换();

        // 测试用例
        int[] coins1 = {1, 2, 5};
        System.out.println("测试1: amount=11, 结果=" + solution.coinChange(coins1, 11)); // 3 (5+5+1)

        int[] coins2 = {2};
        System.out.println("测试2: amount=3, 结果=" + solution.coinChange(coins2, 3)); // -1

        int[] coins3 = {1};
        System.out.println("测试3: amount=0, 结果=" + solution.coinChange(coins3, 0)); // 0
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // dp[i] 表示凑成金额i所需的最少硬币数
        int[] dp = new int[amount + 1];
        // 初始化为最大值（表示不可达）
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        // 完全背包
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
