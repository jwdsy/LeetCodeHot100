package com.leetcode.d_子串;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T011 - LeetCode #239 滑动窗口最大值")
class T011_P239_滑动窗口最大值Test {

    private T011_P239_滑动窗口最大值 solution;

    @BeforeEach
    void setUp() {
        solution = new T011_P239_滑动窗口最大值();
    }

    @Test
    @DisplayName("示例1: nums=[1,3,-1,-3,5,3,6,7], k=3 → [3,3,5,5,6,7]")
    void testExample1() {
        int[] result = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, result);
    }

    @Test
    @DisplayName("示例2: nums=[1], k=1 → [1]")
    void testSingleElement() {
        assertArrayEquals(new int[]{1}, solution.maxSlidingWindow(new int[]{1}, 1));
    }

    @Test
    @DisplayName("k等于数组长度 → [最大值]")
    void testKEqualsLength() {
        assertArrayEquals(new int[]{5}, solution.maxSlidingWindow(new int[]{1, 3, 5, 2}, 4));
    }

    @Test
    @DisplayName("递减数组: [5,4,3,2,1], k=2 → [5,4,3,2]")
    void testDecreasingArray() {
        assertArrayEquals(new int[]{5, 4, 3, 2}, solution.maxSlidingWindow(new int[]{5, 4, 3, 2, 1}, 2));
    }

    @Test
    @DisplayName("递增数组: [1,2,3,4,5], k=2 → [2,3,4,5]")
    void testIncreasingArray() {
        assertArrayEquals(new int[]{2, 3, 4, 5}, solution.maxSlidingWindow(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    @DisplayName("含负数: [-1,-3,-5,-2,-4], k=2 → [-1,-3,-2,-2]")
    void testAllNegative() {
        assertArrayEquals(new int[]{-1, -3, -2, -2}, solution.maxSlidingWindow(new int[]{-1, -3, -5, -2, -4}, 2));
    }

    @Test
    @DisplayName("所有元素相同: [2,2,2,2], k=2 → [2,2,2]")
    void testAllSame() {
        assertArrayEquals(new int[]{2, 2, 2}, solution.maxSlidingWindow(new int[]{2, 2, 2, 2}, 2));
    }

    @Test
    @DisplayName("空数组 → []")
    void testEmptyArray() {
        assertArrayEquals(new int[]{}, solution.maxSlidingWindow(new int[]{}, 1));
    }
}
