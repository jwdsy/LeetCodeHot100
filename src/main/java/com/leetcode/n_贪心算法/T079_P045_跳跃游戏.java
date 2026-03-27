package com.leetcode.n_贪心算法;

/**
 * LeetCode #45 - 跳跃游戏 II 难度: 中等
 *
 * <p>题目描述: 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。 返回到达 nums[n -
 * 1] 的最小跳跃次数。
 *
 * <p>解题思路: 贪心：在每次可跳跃范围内，选择能跳得最远的位置作为下一次跳跃的起点 维护当前跳跃范围的边界 end 和能够跳到的最远位置 maxPos
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(1)
 */
public class T079_P045_跳跃游戏 {

  public int jump(int[] nums) {
    if (nums == null || nums.length <= 1) return 0;

    int jumps = 0;
    int currentEnd = 0;
    int farthest = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      farthest = Math.max(farthest, i + nums[i]);

      if (i == currentEnd) {
        jumps++;
        currentEnd = farthest;
        if (currentEnd >= nums.length - 1) {
          break;
        }
      }
    }

    return jumps;
  }

  public static void main(String[] args) {
    T079_P045_跳跃游戏 solution = new T079_P045_跳跃游戏();

    // 测试用例
    int[] nums1 = {2, 3, 1, 1, 4};
    System.out.println("测试1: " + solution.jump(nums1) + " (期望: 2)");

    int[] nums2 = {2, 3, 0, 1, 4};
    System.out.println("测试2: " + solution.jump(nums2) + " (期望: 2)");
  }
}
