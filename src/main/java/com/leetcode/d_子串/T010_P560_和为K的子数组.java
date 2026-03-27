package com.leetcode.d_子串;

import java.util.*;

/**
 * LeetCode #560 - 和为 K 的子数组 难度: 中等
 *
 * <p>题目描述: 给定一个整数数组 nums 和一个整数 k，请统计和为 k 的连续子数组的个数。
 *
 * <p>示例: 示例 1: 输入: nums = [1,1,1], k = 2, 输出: 2 示例 2: 输入: nums = [1,2,3], k = 3, 输出: 2
 *
 * <p>解题思路: 前缀和 + 哈希表 1. 遍历数组，用哈希表记录每个前缀和出现的次数 2. 遍历到 i 时，查询 prefix[i] - k 的出现次数 时间复杂度: O(n)，空间复杂度:
 * O(n)
 */
public class T010_P560_和为K的子数组 {

  public static void main(String[] args) {
    T010_P560_和为K的子数组 solution = new T010_P560_和为K的子数组();

    // 测试示例: nums = [1,1,1], k = 2
    int[] nums = {1, 1, 1};
    int k = 2;
    int result = solution.subarraySum(nums, k);
    System.out.println("输入: nums = [1,1,1], k = 2");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);

    int prefix = 0;
    int count = 0;

    for (int num : nums) {
      prefix += num;
      count += prefixCount.getOrDefault(prefix - k, 0);
      prefixCount.put(prefix, prefixCount.getOrDefault(prefix, 0) + 1);
    }

    return count;
  }
}
