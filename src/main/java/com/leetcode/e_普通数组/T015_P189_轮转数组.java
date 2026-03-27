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

    // 解题代码
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
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
