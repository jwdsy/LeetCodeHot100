package com.leetcode.o_动态规划;

/**
 * LeetCode #152 - 乘积最大子数组 难度: 中等
 *
 * <p>题目描述: 给你一个整数数组 nums，找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * <p>解题思路: 由于存在负数，负负得正，所以需要同时维护最大值和最小值。maxProd[i] = max(nums[i], maxProd[i-1]*nums[i], minProd[i-1]*nums[i])
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(1)
 */
public class T088_P152_乘积最大子数组 {

    public static void main(String[] args) {
        T088_P152_乘积最大子数组 solution = new T088_P152_乘积最大子数组();

        // 测试用例1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("测试1: " + solution.maxProduct(nums1)); // 6

        // 测试用例2
        int[] nums2 = {-2, 0, -1};
        System.out.println("测试2: " + solution.maxProduct(nums2)); // 0

        // 测试用例3
        int[] nums3 = {-2, 3, -4};
        System.out.println("测试3: " + solution.maxProduct(nums3)); // 24
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // 维护当前最大值和最小值
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            // 当 nums[i] 为负数时，最大值和最小值交换
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // 更新最大值和最小值
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            // 更新结果
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
