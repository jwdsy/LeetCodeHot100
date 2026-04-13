package com.leetcode.e_普通数组;

import java.util.*;

/**
 * LeetCode #189 - 轮转数组 难度: 中等
 *
 * <p>题目描述: 给定一个数组，将数组中的元素向右轮转 k 个位置。
 *
 * <p>示例: 示例 1: 输入: nums = [1,2,3,4,5,6,7], k = 3, 输出: [5,6,7,1,2,3,4] 示例 2: 输入: nums =
 * [-1,-100,3,99], k = 2, 输出: [3,99,-1,-100]
 *
 * <p>解题思路: 反转法 1. 全部反转 2. 反转前 k 个 3. 反转后 n-k 个 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T015_P189_轮转数组 {

    public static void main(String[] args) {
        T015_P189_轮转数组 solution = new T015_P189_轮转数组();

        // 测试示例: nums = [1,2,3,4,5,6,7], k = 3
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println("输入: nums = [1,2,3,4,5,6,7], k = 3");
        System.out.println("输出: " + Arrays.toString(nums));
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public void rotate(int[] nums, int k) {
        rotate2(nums, k);
    }

    // 方法1：额外数组映射新位置（时间 O(n)，空间 O(n)）
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        int length = nums.length;
        k %= length;
        int[] rotated = new int[length];
        for (int index = 0; index < length; index++) {
            rotated[(index + k) % length] = nums[index];
        }
        for (int index = 0; index < length; index++) {
            nums[index] = rotated[index];
        }
    }

    // 方法2：三次反转（最优解法，时间 O(n)，空间 O(1)）
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int length = nums.length;
        k = k % length;

        // 三次反转：整体 -> 前 k -> 后 n-k
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
