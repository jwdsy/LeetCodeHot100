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

    // 对外保留原方法名，默认调用最优解法（方法2）
    public int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindow2(nums, k);
    }

    // 方法1：每个窗口单独扫描最大值（时间 O(n*k)，空间 O(1)）
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int length = nums.length;
        int[] result = new int[length - k + 1];
        for (int windowStart = 0; windowStart <= length - k; windowStart++) {
            int windowMax = nums[windowStart];
            for (int index = windowStart + 1; index < windowStart + k; index++) {
                windowMax = Math.max(windowMax, nums[index]);
            }
            result[windowStart] = windowMax;
        }
        return result;
    }

    // 方法2：单调队列（最优解法，时间 O(n)，空间 O(k)）
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int length = nums.length;
        int[] result = new int[length - k + 1];
        Deque<Integer> decreasingQueue = new LinkedList<>();

        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            // 移除不在窗口内的元素
            while (!decreasingQueue.isEmpty() && decreasingQueue.peek() < currentIndex - k + 1) {
                decreasingQueue.poll();
            }

            // 保持队列递减，移除比当前元素小的
            while (!decreasingQueue.isEmpty() && nums[decreasingQueue.peekLast()] < nums[currentIndex]) {
                decreasingQueue.pollLast();
            }

            decreasingQueue.offer(currentIndex);

            // 记录窗口最大值
            if (currentIndex >= k - 1) {
                result[currentIndex - k + 1] = nums[decreasingQueue.peek()];
            }
        }

        return result;
    }
}
