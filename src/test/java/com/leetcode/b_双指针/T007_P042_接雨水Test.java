package com.leetcode.b_双指针;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T007 - LeetCode #42 接雨水")
class T007_P042_接雨水Test {

    private T007_P042_接雨水 solution;

    @BeforeEach
    void setUp() {
        solution = new T007_P042_接雨水();
    }

    @Test
    @DisplayName("示例1: [0,1,0,2,1,0,1,3,2,1,2,1] → 6")
    void testExample1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6, solution.trap(height));
    }

    @Test
    @DisplayName("示例2: [4,2,0,3,2,5] → 9")
    void testExample2() {
        int[] height = {4, 2, 0, 3, 2, 5};
        assertEquals(9, solution.trap(height));
    }

    @Test
    @DisplayName("无法接水（单调递增）: [1,2,3] → 0")
    void testMonotonicallyIncreasing() {
        int[] height = {1, 2, 3};
        assertEquals(0, solution.trap(height));
    }

    @Test
    @DisplayName("无法接水（单调递减）: [3,2,1] → 0")
    void testMonotonicallyDecreasing() {
        int[] height = {3, 2, 1};
        assertEquals(0, solution.trap(height));
    }

    @Test
    @DisplayName("所有高度相同: [2,2,2,2] → 0")
    void testAllSameHeight() {
        int[] height = {2, 2, 2, 2};
        assertEquals(0, solution.trap(height));
    }

    @Test
    @DisplayName("中间凹陷: [3,0,3] → 3")
    void testSingleValley() {
        int[] height = {3, 0, 3};
        assertEquals(3, solution.trap(height));
    }

    @Test
    @DisplayName("W形状: [0,1,0,1,0] → 1")
    void testWShape() {
        int[] height = {0, 1, 0, 1, 0};
        assertEquals(1, solution.trap(height));
    }

    @Test
    @DisplayName("边界全为0: [0,1,0] → 0（边界无法蓄水）")
    void testZeroBoundary() {
        int[] height = {0, 1, 0};
        assertEquals(0, solution.trap(height));
    }

    @Test
    @DisplayName("最小输入（长度1）: [5] → 0")
    void testSingleElement() {
        int[] height = {5};
        assertEquals(0, solution.trap(height));
    }
}
