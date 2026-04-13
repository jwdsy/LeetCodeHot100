package com.leetcode.e_普通数组;

import java.util.*;

/**
 * LeetCode #41 - 缺失的第一个正数 难度: 困难
 *
 * <p>题目描述: 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * <p>示例: 示例 1: 输入: nums = [1,2,0], 输出: 3 示例 2: 输入: nums = [3,4,-1,1], 输出: 2 示例 3: 输入: nums =
 * [7,8,9,11,12], 输出: 1
 *
 * <p>解题思路: 原地哈希 1. 将数值 x 放到索引 x-1 的位置 2. 再次遍历找到第一个不满足 nums[i] != i+1 的位置 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T017_P041_缺失的第一个正数 {

    public static void main(String[] args) {
        T017_P041_缺失的第一个正数 solution = new T017_P041_缺失的第一个正数();

        // 测试示例: nums = [3,4,-1,1]
        int[] nums = {3, 4, -1, 1};
        int result = solution.firstMissingPositive(nums);
        System.out.println("输入: nums = [3,4,-1,1]");
        System.out.println("输出: " + result);
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public int firstMissingPositive(int[] nums) {
        return firstMissingPositive2(nums);
    }

    // 方法1：哈希集合（时间 O(n)，空间 O(n)）
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> positiveSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveSet.add(num);
            }
        }
        int candidate = 1;
        while (positiveSet.contains(candidate)) {
            candidate++;
        }
        return candidate;
    }

    // 方法2：原地哈希（最优解法，时间 O(n)，空间 O(1)）
    public int firstMissingPositive2(int[] nums) {
        int length = nums.length;

        for (int index = 0; index < length; index++) {
            while (nums[index] >= 1 && nums[index] <= length && nums[nums[index] - 1] != nums[index]) {
                // 把值 x 放到索引 x-1 的位置
                int targetIndex = nums[index] - 1;
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[index];
                nums[index] = temp;
            }
        }

        for (int index = 0; index < length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        return length + 1;
    }
}
