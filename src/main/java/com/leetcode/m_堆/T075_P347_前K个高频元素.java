package com.leetcode.m_堆;

import java.util.*;

/**
 * LeetCode #347 - 前 K 个高频元素 难度: 中等
 *
 * <p>题目描述: 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按任意顺序返回答案。
 *
 * <p>解题思路: 1. 统计每个元素的频率（使用哈希表） 2. 使用最小堆维护频率最高的 k 个元素 3. 遍历哈希表，将元素加入堆，堆满后弹出频率最小的
 *
 * <p>时间复杂度: O(n log k) 空间复杂度: O(n)
 */
public class T075_P347_前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        // 统计频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 最小堆，按频率排序
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }

    public static void main(String[] args) {
        T075_P347_前K个高频元素 solution = new T075_P347_前K个高频元素();

        // 测试用例
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println("测试1: " + Arrays.toString(solution.topKFrequent(nums1, 2)) + " (期望: [1,2])");

        int[] nums2 = {1};
        System.out.println("测试2: " + Arrays.toString(solution.topKFrequent(nums2, 1)) + " (期望: [1])");
    }
}
