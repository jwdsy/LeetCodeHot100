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

    // 对外保留原方法名，默认调用最优解法（方法2）
    public int maxArea(int[] height) {
        return maxArea2(height);
    }

    // 方法1：暴力枚举所有左右边界（时间 O(n^2)，空间 O(1)）
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    // 方法2：双指针夹逼（最优解法，时间 O(n)，空间 O(1)）
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            // 移动短板，才有可能在宽度变小的同时让高度变大
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
