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

    // 对外保留原方法名，默认调用最优解法（方法2）
    public int[][] merge(int[][] intervals) {
        return merge2(intervals);
    }

    // 方法1：两两尝试合并直到稳定（时间 O(n^3)，空间 O(n)）
    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            mergedIntervals.add(new int[]{interval[0], interval[1]});
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int firstIndex = 0; firstIndex < mergedIntervals.size() && !changed; firstIndex++) {
                for (int secondIndex = firstIndex + 1; secondIndex < mergedIntervals.size(); secondIndex++) {
                    int[] firstInterval = mergedIntervals.get(firstIndex);
                    int[] secondInterval = mergedIntervals.get(secondIndex);
                    if (Math.max(firstInterval[0], secondInterval[0]) <= Math.min(firstInterval[1], secondInterval[1])) {
                        firstInterval[0] = Math.min(firstInterval[0], secondInterval[0]);
                        firstInterval[1] = Math.max(firstInterval[1], secondInterval[1]);
                        mergedIntervals.remove(secondIndex);
                        changed = true;
                        break;
                    }
                }
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    // 方法2：排序 + 贪心合并（最优解法，时间 O(n log n)，空间 O(n)）
    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index][0] <= currentInterval[1]) {
                // 与当前区间重叠，直接扩展右边界
                currentInterval[1] = Math.max(currentInterval[1], intervals[index][1]);
            } else {
                currentInterval = intervals[index];
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
