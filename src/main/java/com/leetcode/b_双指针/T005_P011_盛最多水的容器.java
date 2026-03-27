package com.leetcode.b_双指针;

/**
 * LeetCode #11 - 盛最多水的容器 难度: 中等
 *
 * <p>题目描述: 给定n条垂线的高度，找出两条线与x轴构成的容器能容纳最多的水。
 *
 * <p>示例: 示例 1: 输入: height = [1,8,6,2,5,4,8,3,7], 输出: 49 示例 2: 输入: height = [1,1], 输出: 1
 *
 * <p>解题思路: 双指针法：左右指针从两端向中间移动，移动高度较小的指针。 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T005_P011_盛最多水的容器 {

  public static void main(String[] args) {
    T005_P011_盛最多水的容器 solution = new T005_P011_盛最多水的容器();

    // 测试示例: height = [1,8,6,2,5,4,8,3,7]
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int result = solution.maxArea(height);
    System.out.println("输入: height = [1,8,6,2,5,4,8,3,7]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1, maxArea = 0;
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      maxArea = Math.max(maxArea, area);
      if (height[left] < height[right]) left++;
      else right--;
    }
    return maxArea;
  }
}
