package com.leetcode.o_动态规划;

import java.util.*;

/**
 * LeetCode #198 - 打家劫舍 难度: 中等
 *
 * <p>题目描述:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * <p>示例: 示例 1: 输入: [1,2,3,1], 输出: 4
 *
 * <p>解题思路: DP：dp[i] = max(dp[i-1], dp[i-2] + nums[i]) 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T083_P198_打家劫舍 {

    public static void main(String[] args) {
        T083_P198_打家劫舍 solution = new T083_P198_打家劫舍();

        int[] nums = {1, 2, 3, 1};
        int result = solution.rob(nums);
        System.out.println("输入: [1,2,3,1], 输出: " + result);
    }

    // 解题代码
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0, prev1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
