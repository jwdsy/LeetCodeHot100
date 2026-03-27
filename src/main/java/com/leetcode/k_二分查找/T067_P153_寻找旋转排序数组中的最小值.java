package com.leetcode.k_二分查找;

/**
 * LeetCode #153 - 寻找旋转排序数组中的最小值 难度: 中等
 *
 * <p>题目描述: 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次旋转后，得到输入数组。 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到： -
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2] - 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7] 注意，数组 [a[0], a[1], a[2], ...,
 * a[n-1]] 旋转一次的结果为数组 [a[n-1], a[0], a[1], ..., a[n-2]]。 给你旋转后的数组 nums ，请你找出其中最小值。
 *
 * <p>解题思路: 使用二分查找。关键观察： - 旋转后的数组，最小元素一定是数组的分界点，左侧元素 >= 右侧元素 - 比较 nums[mid] 和
 * nums[right]，判断最小值在左半部分还是右半部分
 *
 * <p>时间复杂度: O(log n) 空间复杂度: O(1)
 */
public class T067_P153_寻找旋转排序数组中的最小值 {

  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) return -1;

    int left = 0, right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] > nums[right]) {
        // 最小值在右半部分
        left = mid + 1;
      } else {
        // 最小值在左半部分（含mid）
        right = mid;
      }
    }

    return nums[left];
  }

  public static void main(String[] args) {
    T067_P153_寻找旋转排序数组中的最小值 solution = new T067_P153_寻找旋转排序数组中的最小值();

    // 测试用例
    int[] nums1 = {3, 4, 5, 1, 2};
    System.out.println("测试1: " + solution.findMin(nums1) + " (期望: 1)");

    int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("测试2: " + solution.findMin(nums2) + " (期望: 0)");
  }
}
