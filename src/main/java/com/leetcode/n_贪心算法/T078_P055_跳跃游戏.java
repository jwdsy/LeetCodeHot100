package com.leetcode.n_贪心算法;

/**
 * LeetCode #55 - 跳跃游戏 难度: 中等
 *
 * <p>题目描述: 给定一个非负整数数组 nums ，你最初位于数组的第一个下标。 数组中的每个元素代表你在该位置可以跳跃的最大长度。 判断你是否能够到达最后一个下标。
 *
 * <p>解题思路: 贪心：维护一个能够到达的最远位置 cover，遍历数组更新 cover， 如果当前位置超过 cover，说明无法到达当前位置，返回 false
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(1)
 */
public class T078_P055_跳跃游戏 {

  public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) return false;

    int cover = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > cover) {
        return false;
      }
      cover = Math.max(cover, i + nums[i]);
      if (cover >= nums.length - 1) {
        return true;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    T078_P055_跳跃游戏 solution = new T078_P055_跳跃游戏();

    // 测试用例
    int[] nums1 = {2, 3, 1, 1, 4};
    System.out.println("测试1: " + solution.canJump(nums1) + " (期望: true)");

    int[] nums2 = {3, 2, 1, 0, 4};
    System.out.println("测试2: " + solution.canJump(nums2) + " (期望: false)");
  }
}
