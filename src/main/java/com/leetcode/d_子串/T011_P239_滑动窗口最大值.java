package com.leetcode.d_子串;

import java.util.*;

/**
 * LeetCode #239 - 滑动窗口最大值 难度: 困难
 *
 * <p>题目描述: 给定一个整数数组 nums 和一个大小为 k 的滑动窗口，返回每个滑动窗口中的最大值。
 *
 * <p>示例: 示例 1: 输入: nums = [1,3,-1,-3,5,3,6,7], k = 3, 输出: [3,3,5,5,6,7] 示例 2: 输入: nums = [1], k =
 * 1, 输出: [1]
 *
 * <p>解题思路: 单调队列（双端队列） 1. 队列中保存元素下标，保持递减顺序 2. 队首始终是当前窗口的最大值 时间复杂度: O(n)，空间复杂度: O(k)
 */
public class T011_P239_滑动窗口最大值 {

  public static void main(String[] args) {
    T011_P239_滑动窗口最大值 solution = new T011_P239_滑动窗口最大值();

    // 测试示例: nums = [1,3,-1,-3,5,3,6,7], k = 3
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] result = solution.maxSlidingWindow(nums, k);
    System.out.println("输入: nums = [1,3,-1,-3,5,3,6,7], k = 3");
    System.out.println("输出: " + Arrays.toString(result));
  }

  // 解题代码
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) return new int[0];

    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      // 移除不在窗口内的元素
      while (!deque.isEmpty() && deque.peek() < i - k + 1) {
        deque.poll();
      }

      // 保持队列递减，移除比当前元素小的
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }

      deque.offer(i);

      // 记录窗口最大值
      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peek()];
      }
    }

    return result;
  }
}
