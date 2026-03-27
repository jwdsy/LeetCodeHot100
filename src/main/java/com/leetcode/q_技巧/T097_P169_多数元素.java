package com.leetcode.q_技巧;

import java.util.*;

/**
 * LeetCode #169 - 多数元素 难度: 简单
 *
 * <p>题目描述: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊n/2⌋ 的元素。
 *
 * <p>示例: 示例 1: 输入: [3,2,3], 输出: 3 示例 2: 输入: [2,2,1,1,1,2,2], 输出: 2
 *
 * <p>解题思路: Boyer-Moore投票法 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T097_P169_多数元素 {

  public static void main(String[] args) {
    T097_P169_多数元素 solution = new T097_P169_多数元素();

    int[] nums = {2, 2, 1, 1, 1, 2, 2};
    int result = solution.majorityElement(nums);
    System.out.println("输入: [2,2,1,1,1,2,2]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public int majorityElement(int[] nums) {
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }
}
