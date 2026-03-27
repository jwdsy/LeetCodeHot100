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

    // 解题代码
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        java.util.Set<Integer> numSet = new java.util.HashSet<>();
        for (int num : nums) numSet.add(num);
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num, currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
