package com.leetcode.d_子串;

import java.util.*;

/**
 * LeetCode #560 - 和为 K 的子数组 难度: 中等
 *
 * <p>题目描述: 给定一个整数数组 nums 和一个整数 k，请统计和为 k 的连续子数组的个数。
 *
 * <p>示例: 示例 1: 输入: nums = [1,1,1], k = 2, 输出: 2 示例 2: 输入: nums = [1,2,3], k = 3, 输出: 2
 *
 * <p>解题思路: 前缀和 + 哈希表 1. 遍历数组，用哈希表记录每个前缀和出现的次数 2. 遍历到 i 时，查询 prefix[i] - k 的出现次数 时间复杂度: O(n)，空间复杂度:
 * O(n)
 */
public class T010_P560_和为K的子数组 {

    public static void main(String[] args) {
        T010_P560_和为K的子数组 solution = new T010_P560_和为K的子数组();

        // 测试示例: nums = [1,1,1], k = 2
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = solution.subarraySum(nums, k);
        System.out.println("输入: nums = [1,1,1], k = 2");
        System.out.println("输出: " + result);
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public int subarraySum(int[] nums, int k) {
        return subarraySum2(nums, k);
    }

    // 方法1：枚举所有子数组（时间 O(n^2)，空间 O(1)）
    public int subarraySum1(int[] nums, int k) {
        int subarrayCount = 0;
        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            int windowSum = 0;
            for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                windowSum += nums[endIndex];
                if (windowSum == k) {
                    subarrayCount++;
                }
            }
        }
        return subarrayCount;
    }

    // 方法2：前缀和 + 哈希表（最优解法，时间 O(n)，空间 O(n)）
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int subarrayCount = 0;

        for (int num : nums) {
            prefixSum += num;
            // 之前若存在 prefixSum-k，则该位置到当前下标构成和为 k 的子数组
            subarrayCount += prefixCount.getOrDefault(prefixSum - k, 0);
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return subarrayCount;
    }
}
