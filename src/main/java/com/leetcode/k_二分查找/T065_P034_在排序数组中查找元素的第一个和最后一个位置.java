package com.leetcode.k_二分查找;

/**
 * LeetCode #34 - 在排序数组中查找元素的第一个和最后一个位置 难度: 中等
 *
 * <p>题目描述: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 如果数组中不存在目标值 target，返回 [-1,
 * -1]。
 *
 * <p>解题思路: 使用两次二分查找： - 第一次找左边界：找到第一个 >= target 的位置 - 第二次找右边界：找到第一个 > target 的位置，然后减 1
 *
 * <p>时间复杂度: O(log n) 空间复杂度: O(1)
 */
public class T065_P034_在排序数组中查找元素的第一个和最后一个位置 {

  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    if (nums == null || nums.length == 0) return result;

    // 找左边界
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    if (nums[left] == target) {
      result[0] = left;
    } else {
      return result;
    }

    // 找右边界
    right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left + 1) / 2;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    result[1] = left;

    return result;
  }

  public static void main(String[] args) {
    T065_P034_在排序数组中查找元素的第一个和最后一个位置 solution = new T065_P034_在排序数组中查找元素的第一个和最后一个位置();

    // 测试用例
    int[] nums1 = {5, 7, 7, 8, 8, 10};
    System.out.println(
        "测试1: " + java.util.Arrays.toString(solution.searchRange(nums1, 8)) + " (期望: [3, 4])");
    System.out.println(
        "测试2: " + java.util.Arrays.toString(solution.searchRange(nums1, 6)) + " (期望: [-1, -1])");
  }
}
