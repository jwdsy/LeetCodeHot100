package com.leetcode.l_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T073 - P84 柱状图中最大的矩形")
class T073_P084_柱状图中最大的矩形Test {

    private T073_P084_柱状图中最大的矩形 solution;

    @BeforeEach
    void setUp() {
        solution = new T073_P084_柱状图中最大的矩形();
    }

    @Test
    @DisplayName("示例1：[2,1,5,6,2,3]，最大面积10")
    void testExample1() {
        assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    @Test
    @DisplayName("示例2：[2,4]，最大面积4")
    void testExample2() {
        assertEquals(4, solution.largestRectangleArea(new int[]{2,4}));
    }

    @Test
    @DisplayName("单个柱子")
    void testSingleBar() {
        assertEquals(5, solution.largestRectangleArea(new int[]{5}));
    }

    @Test
    @DisplayName("所有高度相同")
    void testAllSameHeight() {
        assertEquals(12, solution.largestRectangleArea(new int[]{3,3,3,3}));
    }

    @Test
    @DisplayName("递增序列")
    void testAscending() {
        assertEquals(6, solution.largestRectangleArea(new int[]{1,2,3,4}));
    }

    @Test
    @DisplayName("递减序列")
    void testDescending() {
        assertEquals(6, solution.largestRectangleArea(new int[]{4,3,2,1}));
    }

    @Test
    @DisplayName("中间有低柱子分隔")
    void testValley() {
        // [6,2,5,4,5,1,6] - 最大矩形是 [5,4,5] 高度4×宽度3=12
        assertEquals(12, solution.largestRectangleArea(new int[]{6,2,5,4,5,1,6}));
    }

    @Test
    @DisplayName("高度为零")
    void testZeroHeight() {
        assertEquals(2, solution.largestRectangleArea(new int[]{0,1,2,0}));
    }
}
