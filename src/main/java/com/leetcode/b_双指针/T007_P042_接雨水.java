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

    // 对外保留原方法名，默认调用最优解法（方法3）
    public int trap(int[] height) {
        return trap3(height);
    }

    // 方法1：按列计算（时间 O(n^2)，空间 O(1)）
    public int trap1(int[] height) {
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l <= i; l++) leftMax = Math.max(leftMax, height[l]);
            for (int r = i; r < height.length; r++) rightMax = Math.max(rightMax, height[r]);
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }

    // 方法2：前后缀最大值数组（时间 O(n)，空间 O(n)）
    public int trap2(int[] height) {
        if (height.length == 0) return 0;
        int length = height.length;
        int[] maxLeftHeight = new int[length];
        int[] maxRightHeight = new int[length];
        maxLeftHeight[0] = height[0];
        for (int index = 1; index < length; index++) {
            maxLeftHeight[index] = Math.max(maxLeftHeight[index - 1], height[index]);
        }
        maxRightHeight[length - 1] = height[length - 1];
        for (int index = length - 2; index >= 0; index--) {
            maxRightHeight[index] = Math.max(maxRightHeight[index + 1], height[index]);
        }
        int trappedWater = 0;
        for (int index = 1; index < length - 1; index++) {
            trappedWater += Math.min(maxLeftHeight[index], maxRightHeight[index]) - height[index];
        }
        return trappedWater;
    }

    // 方法3：双指针（最优解法，时间 O(n)，空间 O(1)）
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeftHeight = 0;
        int maxRightHeight = 0;
        int trappedWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeftHeight) maxLeftHeight = height[left];
                else trappedWater += maxLeftHeight - height[left]; // 当前列左侧更高，可接水
                left++;
            } else {
                if (height[right] >= maxRightHeight) maxRightHeight = height[right];
                else trappedWater += maxRightHeight - height[right]; // 当前列右侧更高，可接水
                right--;
            }
        }
        return trappedWater;
    }
}
