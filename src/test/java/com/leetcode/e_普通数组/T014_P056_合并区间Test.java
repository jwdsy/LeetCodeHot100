package com.leetcode.e_普通数组;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T014 - LeetCode #56 合并区间")
class T014_P056_合并区间Test {

    private T014_P056_合并区间 solution;

    @BeforeEach
    void setUp() {
        solution = new T014_P056_合并区间();
    }

    @Test
    @DisplayName("示例1: [[1,3],[2,6],[8,10],[15,18]] → [[1,6],[8,10],[15,18]]")
    void testExample1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, result);
    }

    @Test
    @DisplayName("示例2: [[1,4],[4,5]] → [[1,5]]（端点相接）")
    void testTouchingIntervals() {
        int[][] result = solution.merge(new int[][]{{1, 4}, {4, 5}});
        assertArrayEquals(new int[][]{{1, 5}}, result);
    }

    @Test
    @DisplayName("单个区间 → 原区间")
    void testSingleInterval() {
        int[][] result = solution.merge(new int[][]{{1, 5}});
        assertArrayEquals(new int[][]{{1, 5}}, result);
    }

    @Test
    @DisplayName("所有区间完全重叠 → 一个大区间")
    void testAllOverlapping() {
        int[][] result = solution.merge(new int[][]{{1, 4}, {2, 3}, {1, 6}});
        assertArrayEquals(new int[][]{{1, 6}}, result);
    }

    @Test
    @DisplayName("无重叠区间 → 各自独立")
    void testNoOverlap() {
        int[][] result = solution.merge(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}, {5, 6}}, result);
    }

    @Test
    @DisplayName("输入未排序 → 正确合并")
    void testUnsortedInput() {
        int[][] result = solution.merge(new int[][]{{15, 18}, {1, 3}, {2, 6}, {8, 10}});
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, result);
    }

    @Test
    @DisplayName("所有区间合并为一个: [[1,4],[3,6],[5,8]] → [[1,8]]")
    void testMergeIntoOne() {
        int[][] result = solution.merge(new int[][]{{1, 4}, {3, 6}, {5, 8}});
        assertArrayEquals(new int[][]{{1, 8}}, result);
    }
}
