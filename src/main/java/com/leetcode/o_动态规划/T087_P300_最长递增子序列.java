package com.leetcode.o_动态规划;

/**
 * LeetCode #300 - 最长递增子序列 难度: 中等
 *
 * <p>题目描述: 给你一个整数数组 nums，找到其中最长严格递增子序列的长度。 子序列是由数组派生而来的序列，删除或不删除其中的数元素而不改变其余元素的顺序。
 *
 * <p>解题思路: 动态规划 + 二分查找优化。这里使用二分查找优化，时间复杂度 O(nlogn)。维护一个有序数组 d，d[i] 表示长度为 i+1 的递增子序列的最小结尾元素
 *
 * <p>时间复杂度: O(nlogn) 空间复杂度: O(n)
 */
public class T087_P300_最长递增子序列 {

    public static void main(String[] args) {
        T087_P300_最长递增子序列 solution = new T087_P300_最长递增子序列();

        // 测试用例1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("测试1: " + solution.lengthOfLIS(nums1)); // 4 (2,3,7,101 或 2,3,7,18)

        // 测试用例2
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("测试2: " + solution.lengthOfLIS(nums2)); // 4

        // 测试用例3
        int[] nums3 = {7, 7, 7, 7, 7};
        System.out.println("测试3: " + solution.lengthOfLIS(nums3)); // 1
    }

    /**
     * 二分查找优化版本
     *
     * @param nums 数组
     * @return 最长递增子序列长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] d = new int[n];
        int length = 0;

        for (int num : nums) {
            // 二分查找找到插入位置
            int left = 0, right = length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (d[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 插入或替换
            d[left] = num;
            if (left == length) {
                length++;
            }
        }

        return length;
    }

    /**
     * 动态规划版本（O(n^2)）
     *
     * @param nums 数组
     * @return 最长递增子序列长度
     */
    public int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
