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

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs2(int n) {
        if (n <= 2) return n;
        if (map.containsKey(n)) return map.get(n);
        int result = climbStairs2(n - 1) + climbStairs2(n - 2);
        map.put(n, result);
        return result;
    }

    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int pre = 2;       // dp[i-1]，初始为 dp[2]=2
        int prePre = 1;    // dp[i-2]，初始为 dp[1]=1
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
