package com.leetcode.b_双指针;

import java.util.*;

/**
 * LeetCode #15 - 三数之和 难度: 中等
 *
 * <p>题目描述: 给定整数数组nums，判断是否存在三元组和为0，返回所有不重复的三元组。
 *
 * <p>示例: 示例 1: 输入: nums = [-1,0,1,2,-1,-4], 输出: [[-1,-1,2],[-1,0,1]] 示例 2: 输入: nums = [0,0,0], 输出:
 * [[0,0,0]]
 *
 * <p>解题思路: 排序 + 双指针：排序后固定第一个数，双指针找后两数。 时间复杂度: O(n²)，空间复杂度: O(log n)
 */
public class T006_P015_三数之和 {

  public static void main(String[] args) {
    T006_P015_三数之和 solution = new T006_P015_三数之和();

    // 测试示例: nums = [-1,0,1,2,-1,-4]
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = solution.threeSum(nums);
    System.out.println("输入: nums = [-1,0,1,2,-1,-4]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new java.util.ArrayList<>();
    java.util.Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          res.add(java.util.Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;
          left++;
          right--;
        } else if (sum < 0) left++;
        else right--;
      }
    }
    return res;
  }
}
