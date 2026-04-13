package com.leetcode.q_技巧;

import java.util.*;

/**
 * LeetCode #136 - 只出现一次的数字 难度: 简单
 *
 * <p>题目描述: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * <p>示例: 示例 1: 输入: [2,2,1], 输出: 1 示例 2: 输入: [4,1,2,1,2], 输出: 4
 *
 * <p>解题思路: 异或运算：相同数字异或为0，0异或任何数为自身 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T096_P136_只出现一次的数字 {

    public static void main(String[] args) {
        T096_P136_只出现一次的数字 solution = new T096_P136_只出现一次的数字();

        int[] nums = {4, 1, 2, 1, 2};
        int result = solution.singleNumber(nums);
        System.out.println("输入: [4,1,2,1,2]");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;

    }
}
