package com.leetcode.k_二分查找;

/**
 * LeetCode #35 - 搜索插入位置 难度: 简单
 *
 * <p>题目描述: 给定一个排序数组和一个目标值，如果找到目标，则返回索引。如果没有，则返回它会被按顺序插入的位置。 你可以假设数组中无重复元素。
 *
 * <p>解题思路: 使用二分查找。标准二分模板，当找不到时，left 指针的位置就是插入位置。
 *
 * <p>时间复杂度: O(log n) 空间复杂度: O(1)
 */
public class T063_P035_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        T063_P035_搜索插入位置 solution = new T063_P035_搜索插入位置();

        // 测试用例
        int[] nums1 = {1, 3, 5, 6};
        System.out.println("测试1: " + solution.searchInsert(nums1, 5) + " (期望: 2)");
        System.out.println("测试2: " + solution.searchInsert(nums1, 2) + " (期望: 1)");
        System.out.println("测试3: " + solution.searchInsert(nums1, 7) + " (期望: 4)");
    }
}
