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
    // 对外保留原方法名，默认调用最优解法（方法2）。
    public int climbStairs(int n) {
        return climbStairs2(n);
    }

    private final Map<Integer, Integer> memoizedWays = new HashMap<>();

    // 方法1：记忆化搜索（时间 O(n)，空间 O(n)）
    public int climbStairs1(int n) {
        if (n <= 2) return n;
        if (memoizedWays.containsKey(n)) return memoizedWays.get(n);
        // 状态转移：f(n)=f(n-1)+f(n-2)
        int result = climbStairs1(n - 1) + climbStairs1(n - 2);
        memoizedWays.put(n, result);
        return result;
    }

    // 方法2：动态规划滚动变量（最优解法，时间 O(n)，空间 O(1)）
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int waysOneStepBefore = 2;   // 到达 i-1 阶的方法数
        int waysTwoStepsBefore = 1;  // 到达 i-2 阶的方法数
        for (int currentStep = 3; currentStep <= n; currentStep++) {
            // 当前阶的方法数 = 前一阶 + 前两阶
            int currentWays = waysOneStepBefore + waysTwoStepsBefore;
            waysTwoStepsBefore = waysOneStepBefore;
            waysOneStepBefore = currentWays;
        }
        return waysOneStepBefore;

    }
}
