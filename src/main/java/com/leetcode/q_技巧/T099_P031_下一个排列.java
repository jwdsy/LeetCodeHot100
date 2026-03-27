package com.leetcode.q_技巧;

import java.util.*;

/**
 * LeetCode #31 - 下一个排列 难度: 中等
 *
 * <p>题目描述: 给你一个整数数组 nums，请你找出数列的下一个排列。下一个排列是字典序中大于原序列的序列。
 *
 * <p>示例: 示例 1: 输入: nums = [1,2,3], 输出: [1,3,2] 示例 2: 输入: nums = [3,2,1], 输出: [1,2,3]
 *
 * <p>解题思路: 1. 从后往前找第一个降序的位置 2. 从后往前找第一个比该位置大的数 3. 交换两数 4. 反转该位置后的数组 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T099_P031_下一个排列 {

    public static void main(String[] args) {
        T099_P031_下一个排列 solution = new T099_P031_下一个排列();

        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println("输入: [1,2,3]");
        System.out.println("输出: " + Arrays.toString(nums));
    }

    // 解题代码
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        reverse(nums, i + 1, nums.length - 1);
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
