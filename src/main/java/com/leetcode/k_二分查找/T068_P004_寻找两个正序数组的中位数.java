package com.leetcode.k_二分查找;

/**
 * LeetCode #4 - 寻找两个正序数组的中位数 难度: 困难
 *
 * <p>题目描述: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 请你找出并返回这两个正序数组的中位数。 算法的时间复杂度应该为 O(log (m+n))
 * 。
 *
 * <p>解题思路: 使用二分查找的思路。转换为找第 k 小的数： - 每次排除 k/2 个元素 - 比较两个数组的第 k/2 个元素 - 较小元素所在数组的前 k/2 个元素可以排除
 *
 * <p>时间复杂度: O(log(m+n)) 空间复杂度: O(1)
 */
public class T068_P004_寻找两个正序数组的中位数 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int total = m + n;

    // 如果总长度为奇数，找第 (total+1)/2 小的数
    if (total % 2 == 1) {
      return findKth(nums1, nums2, (total + 1) / 2);
    } else {
      // 如果总长度为偶数，找第 total/2 和 total/2+1 小的数，取平均
      return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2.0;
    }
  }

  private double findKth(int[] nums1, int[] nums2, int k) {
    int m = nums1.length, n = nums2.length;
    int index1 = 0, index2 = 0;

    while (true) {
      // 边界情况
      if (index1 == m) return nums2[index2 + k - 1];
      if (index2 == n) return nums1[index1 + k - 1];
      if (k == 1) return Math.min(nums1[index1], nums2[index2]);

      // 正常情况
      int newIndex1 = Math.min(index1 + k / 2 - 1, m - 1);
      int newIndex2 = Math.min(index2 + k / 2 - 1, n - 1);

      if (nums1[newIndex1] <= nums2[newIndex2]) {
        k -= (newIndex1 - index1 + 1);
        index1 = newIndex1 + 1;
      } else {
        k -= (newIndex2 - index2 + 1);
        index2 = newIndex2 + 1;
      }
    }
  }

  public static void main(String[] args) {
    T068_P004_寻找两个正序数组的中位数 solution = new T068_P004_寻找两个正序数组的中位数();

    // 测试用例
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    System.out.println("测试1: " + solution.findMedianSortedArrays(nums1, nums2) + " (期望: 2.0)");

    int[] nums3 = {1, 2};
    int[] nums4 = {3, 4};
    System.out.println("测试2: " + solution.findMedianSortedArrays(nums3, nums4) + " (期望: 2.5)");
  }
}
