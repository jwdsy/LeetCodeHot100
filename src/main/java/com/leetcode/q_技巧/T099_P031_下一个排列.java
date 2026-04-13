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
    // 解法：从后向前找“下降点”，交换后反转后缀（时间 O(n)，空间 O(1)）
    public void nextPermutation(int[] nums) {
        int pivotIndex = nums.length - 2;
        while (pivotIndex >= 0 && nums[pivotIndex] >= nums[pivotIndex + 1]) {
            pivotIndex--;
        }

        if (pivotIndex >= 0) {
            int successorIndex = nums.length - 1;
            while (successorIndex >= 0 && nums[successorIndex] <= nums[pivotIndex]) {
                successorIndex--;
            }
            int temp = nums[pivotIndex];
            nums[pivotIndex] = nums[successorIndex];
            nums[successorIndex] = temp;
        }

        // 后缀原本是降序，反转后得到最小升序后缀
        reverse(nums, pivotIndex + 1, nums.length - 1);

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
