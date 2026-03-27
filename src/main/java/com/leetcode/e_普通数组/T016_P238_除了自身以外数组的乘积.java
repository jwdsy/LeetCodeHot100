package com.leetcode.e_普通数组;

import java.util.*;

/**
 * LeetCode #238 - 除了自身以外数组的乘积 难度: 中等
 *
 * <p>题目描述: 给定一个整数数组 nums，返回 answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余元素的乘积。
 *
 * <p>示例: 示例 1: 输入: nums = [1,2,3,4], 输出: [24,12,8,6] 示例 2: 输入: nums = [-1,1,0,-3,3], 输出:
 * [0,0,9,0,0]
 *
 * <p>解题思路: 左右乘积数组 1. 先用输出数组存储前缀积 2. 再用变量累乘后缀积 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T016_P238_除了自身以外数组的乘积 {

    public static void main(String[] args) {
        T016_P238_除了自身以外数组的乘积 solution = new T016_P238_除了自身以外数组的乘积();

        // 测试示例: nums = [1,2,3,4]
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.println("输入: nums = [1,2,3,4]");
        System.out.println("输出: " + Arrays.toString(result));
    }

    // 解题代码
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 计算前缀积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 乘上后缀积
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}
