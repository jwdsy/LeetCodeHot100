package com.leetcode.m_堆;

import java.util.*;

/**
 * LeetCode #215 - 数组中的第K个最大元素 难度: 中等
 *
 * <p>题目描述: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * <p>解题思路: 使用最小堆，维护大小为 k 的堆，遍历数组，堆满后每次弹出最小元素，最后堆顶就是第 k 大
 *
 * <p>时间复杂度: O(n log k) 空间复杂度: O(k)
 */
public class T074_P215_数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        // 最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        T074_P215_数组中的第K个最大元素 solution = new T074_P215_数组中的第K个最大元素();

        // 测试用例
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println("测试1: " + solution.findKthLargest(nums1, 2) + " (期望: 5)");

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("测试2: " + solution.findKthLargest(nums2, 4) + " (期望: 4)");
    }
}
