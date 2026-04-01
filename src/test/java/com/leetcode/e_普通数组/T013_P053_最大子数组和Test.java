package com.leetcode.e_普通数组;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T013 - LeetCode #53 最大子数组和")
class T013_P053_最大子数组和Test {

    private T013_P053_最大子数组和 solution;

    @BeforeEach
    void setUp() {
        solution = new T013_P053_最大子数组和();
    }

    @Test
    @DisplayName("示例1: [-2,1,-3,4,-1,2,1,-5,4] → 6")
    void testExample1() {
        assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    @DisplayName("示例2: [1] → 1（单元素）")
    void testSingleElement() {
        assertEquals(1, solution.maxSubArray(new int[]{1}));
    }

    @Test
    @DisplayName("示例3: [5,4,-1,7,8] → 23（全选最优）")
    void testAllPositive() {
        assertEquals(23, solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    @Test
    @DisplayName("全为负数: [-3,-1,-2] → -1（最大负数）")
    void testAllNegative() {
        assertEquals(-1, solution.maxSubArray(new int[]{-3, -1, -2}));
    }

    @Test
    @DisplayName("单个负数: [-5] → -5")
    void testSingleNegative() {
        assertEquals(-5, solution.maxSubArray(new int[]{-5}));
    }

    @Test
    @DisplayName("全为正数: [1,2,3,4,5] → 15")
    void testAllPositiveSequential() {
        assertEquals(15, solution.maxSubArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("交替正负: [-1,2,-1,2,-1] → 3")
    void testAlternating() {
        assertEquals(3, solution.maxSubArray(new int[]{-1, 2, -1, 2, -1}));
    }

    @Test
    @DisplayName("最大子数组在末尾: [-2,-1,3,4] → 7")
    void testMaxAtEnd() {
        assertEquals(7, solution.maxSubArray(new int[]{-2, -1, 3, 4}));
    }
}
