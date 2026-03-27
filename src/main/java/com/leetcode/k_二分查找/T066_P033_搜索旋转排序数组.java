package com.leetcode.k_二分查找;

/**
 * LeetCode #33 - 搜索旋转排序数组 难度: 中等
 *
 * <p>题目描述: 整数数组 nums 按升序排列，数组中的值 互不相同 。 给你旋转后的数组 nums 和一个目标值 target，如果 nums 中存在这个目标值，则返回它的索引，否则返回
 * -1。
 *
 * <p>解题思路: 使用改进的二分查找。关键在于判断哪一半是有序的： - 比较 nums[mid] 和 nums[left] 确定左半部分是否有序 - 然后判断 target 是否在有序的一半中
 *
 * <p>时间复杂度: O(log n) 空间复杂度: O(1)
 */
public class T066_P033_搜索旋转排序数组 {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;

    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      // 判断左半部分是否有序
      if (nums[left] <= nums[mid]) {
        // 左半部分有序
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        // 右半部分有序
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    T066_P033_搜索旋转排序数组 solution = new T066_P033_搜索旋转排序数组();

    // 测试用例
    int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("测试1: " + solution.search(nums1, 0) + " (期望: 4)");
    System.out.println("测试2: " + solution.search(nums1, 3) + " (期望: -1)");
  }
}
