package com.leetcode.e_普通数组;

/**
 * LeetCode #53 - 最大子数组和 难度: 中等
 *
 * <p>题目描述: 给定一个整数数组 nums，找出具有最大和的连续子数组，返回其最大和。
 *
 * <p>示例: 示例 1: 输入: nums = [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 示例 2: 输入: nums = [1], 输出: 1 示例 3: 输入: nums
 * = [5,4,-1,7,8], 输出: 23
 *
 * <p>解题思路: 动态规划（Kadane算法） 1. currentSum 表示以当前元素结尾的最大子数组和 2. maxSum 记录全局最大和 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T013_P053_最大子数组和 {

  public static void main(String[] args) {
    T013_P053_最大子数组和 solution = new T013_P053_最大子数组和();

    // 测试示例: nums = [-2,1,-3,4,-1,2,1,-5,4]
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int result = solution.maxSubArray(nums);
    System.out.println("输入: nums = [-2,1,-3,4,-1,2,1,-5,4]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }
}
