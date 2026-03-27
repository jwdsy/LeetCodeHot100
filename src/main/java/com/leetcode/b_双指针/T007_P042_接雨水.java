package com.leetcode.b_双指针;

/**
 * LeetCode #42 - 接雨水 难度: 困难
 *
 * <p>题目描述: 给定n个非负整数表示柱子高度，计算下雨后能接多少雨水。
 *
 * <p>示例: 示例 1: 输入: height = [0,1,0,2,1,0,1,3,2,1,2,1], 输出: 6 示例 2: 输入: height = [4,2,0,3,2,5], 输出:
 * 9
 *
 * <p>解题思路: 双指针法：维护左右最大值，移动较小高度的指针。 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T007_P042_接雨水 {

  public static void main(String[] args) {
    T007_P042_接雨水 solution = new T007_P042_接雨水();

    // 测试示例: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int result = solution.trap(height);
    System.out.println("输入: height = [0,1,0,2,1,0,1,3,2,1,2,1]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) leftMax = height[left];
        else water += leftMax - height[left];
        left++;
      } else {
        if (height[right] >= rightMax) rightMax = height[right];
        else water += rightMax - height[right];
        right--;
      }
    }
    return water;
  }
}
