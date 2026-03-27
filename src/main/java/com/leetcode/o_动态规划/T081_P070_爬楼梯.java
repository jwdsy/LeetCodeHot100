package com.leetcode.o_动态规划;

import java.util.*;

/**
 * LeetCode #70 - 爬楼梯 难度: 简单
 *
 * <p>题目描述: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶？
 *
 * <p>示例: 示例 1: 输入: n = 2, 输出: 2 示例 2: 输入: n = 3, 输出: 3
 *
 * <p>解题思路: DP：dp[n] = dp[n-1] + dp[n-2] 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T081_P070_爬楼梯 {

    public static void main(String[] args) {
        T081_P070_爬楼梯 solution = new T081_P070_爬楼梯();

        int n = 3;
        int result = solution.climbStairs(n);
        System.out.println("n = " + n + ", 输出: " + result);
    }

    // 解题代码
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev1 = 2, prev2 = 1;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
