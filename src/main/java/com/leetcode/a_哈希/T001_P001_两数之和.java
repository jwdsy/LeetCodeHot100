package com.leetcode.a_哈希;

import java.util.*;

/**
 * LeetCode #1 - 两数之和 难度: 简单
 *
 * <p>题目描述: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target
 * 的那两个整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * <p>示例: 示例 1: 输入: nums = [2,7,11,15], target = 9, 输出: [0,1] 示例 2: 输入: nums = [3,2,4], target = 6,
 * 输出: [1,2] 示例 3: 输入: nums = [3,3], target = 6, 输出: [0,1]
 *
 * <p>解题思路: 方法一：暴力枚举 - 双重循环，时间复杂度 O(n²) 方法二：哈希表 - 遍历一次，时间复杂度 O(n)，空间复杂度 O(n) 推荐使用哈希表方法
 */
public class T001_P001_两数之和 {

  public static void main(String[] args) {
    T001_P001_两数之和 solution = new T001_P001_两数之和();

    // 测试示例: nums = [2,7,11,15], target = 9
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = solution.twoSum(nums, target);
    System.out.println("输入: nums = [2,7,11,15], target = 9");
    System.out.println("输出: " + java.util.Arrays.toString(result));
  }

  // 解题代码
  public int[] twoSum(int[] nums, int target) {
    java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
