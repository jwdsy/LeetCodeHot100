package com.leetcode.e_普通数组;

import java.util.*;

/**
 * LeetCode #56 - 合并区间 难度: 中等
 *
 * <p>题目描述: 给定一个区间的集合，合并所有重叠的区间。
 *
 * <p>示例: 示例 1: 输入: intervals = [[1,3],[2,6],[8,10],[15,18]], 输出: [[1,6],[8,10],[15,18]] 示例 2: 输入:
 * intervals = [[1,4],[4,5]], 输出: [[1,5]]
 *
 * <p>解题思路: 排序 + 贪心合并 1. 按区间起始位置排序 2. 遍历合并重叠区间 时间复杂度: O(n log n)，空间复杂度: O(n)
 */
public class T014_P056_合并区间 {

    public static void main(String[] args) {
        T014_P056_合并区间 solution = new T014_P056_合并区间();

        // 测试示例: intervals = [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);
        System.out.println("输入: intervals = [[1,3],[2,6],[8,10],[15,18]]");
        System.out.println("输出: " + Arrays.deepToString(result));
    }

    // 解题代码
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                current = intervals[i];
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
