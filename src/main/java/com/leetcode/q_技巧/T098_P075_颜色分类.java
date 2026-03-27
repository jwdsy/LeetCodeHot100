package com.leetcode.q_技巧;

import java.util.*;

/**
 * LeetCode #75 - 颜色分类 难度: 中等
 *
 * <p>题目描述: 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums，原地对它们进行排序，使得相同颜色的元素相邻，并按红色、白色、蓝色顺序排列。
 *
 * <p>示例: 示例 1: 输入: nums = [2,0,2,1,1,0], 输出: [0,0,1,1,2,2]
 *
 * <p>解题思路: 三路快排：使用三个指针 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T098_P075_颜色分类 {

    public static void main(String[] args) {
        T098_P075_颜色分类 solution = new T098_P075_颜色分类();

        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println("输入: [2,0,2,1,1,0]");
        System.out.println("输出: " + Arrays.toString(nums));
    }

    // 解题代码
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, curr = 0;

        while (curr <= right) {
            if (nums[curr] == 0) {
                nums[curr] = nums[left];
                nums[left] = 0;
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                curr++;
            }
        }
    }
}
