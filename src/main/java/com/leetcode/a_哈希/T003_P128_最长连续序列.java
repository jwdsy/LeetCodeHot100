package com.leetcode.a_哈希;

import java.util.*;

/**
 * LeetCode #128 - 最长连续序列 难度: 中等
 *
 * <p>题目描述: 给定一个未排序的整数数组 nums，找出数字连续的最长序列的长度。请设计并实现时间复杂度为 O(n) 的算法。
 *
 * <p>示例: 示例 1: 输入: nums = [100,4,200,1,3,2], 输出: 4 示例 2: 输入: nums = [0,3,7,2,5,8,4,6,0,1], 输出: 9
 *
 * <p>解题思路: 使用哈希集合： 1. 将所有数字加入HashSet 2. 遍历每个数字，如果num-1不存在，则num是序列起点 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T003_P128_最长连续序列 {

    public static void main(String[] args) {
        T003_P128_最长连续序列 solution = new T003_P128_最长连续序列();

        // 测试示例: nums = [100,4,200,1,3,2]
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = solution.longestConsecutive(nums);
        System.out.println("输入: nums = [100,4,200,1,3,2]");
        System.out.println("输出: " + result);
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public int longestConsecutive(int[] nums) {
        return longestConsecutive2(nums);
    }

    // 方法1：先排序再统计连续段（时间 O(n log n)，空间 O(1) 或 O(log n)）
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int longestLength = 1;
        int currentLength = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                continue;
            }
            if (nums[index] == nums[index - 1] + 1) {
                currentLength++;
            } else {
                longestLength = Math.max(longestLength, currentLength);
                currentLength = 1;
            }
        }
        return Math.max(longestLength, currentLength);
    }

    // 方法2：哈希集合找连续起点（最优解法，时间 O(n)，空间 O(n)）
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : nums) uniqueNumbers.add(number);
        int longestLength = 0;
        for (int number : uniqueNumbers) {
            // 仅从连续段起点开始扩展，确保每个数字最多被访问一次
            if (!uniqueNumbers.contains(number - 1)) {
                int currentNumber = number;
                int currentLength = 1;
                while (uniqueNumbers.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentLength++;
                }
                longestLength = Math.max(longestLength, currentLength);
            }
        }
        return longestLength;
    }
}
