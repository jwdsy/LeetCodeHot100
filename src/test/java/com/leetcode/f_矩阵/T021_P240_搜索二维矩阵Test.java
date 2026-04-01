package com.leetcode.f_矩阵;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T021 - LeetCode #240 搜索二维矩阵 II")
class T021_P240_搜索二维矩阵Test {

    private T021_P240_搜索二维矩阵 solution;

    private final int[][] matrix = {
        {1,  4,  7,  11, 15},
        {2,  5,  8,  12, 19},
        {3,  6,  9,  16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };

    @BeforeEach
    void setUp() {
        solution = new T021_P240_搜索二维矩阵();
    }

    @Test
    @DisplayName("示例1: 搜索5 → true")
    void testFound5() {
        assertTrue(solution.searchMatrix(matrix, 5));
    }

    @Test
    @DisplayName("示例2: 搜索20 → false")
    void testNotFound20() {
        assertFalse(solution.searchMatrix(matrix, 20));
    }

    @Test
    @DisplayName("搜索最小值1 → true")
    void testFindMin() {
        assertTrue(solution.searchMatrix(matrix, 1));
    }

    @Test
    @DisplayName("搜索最大值30 → true")
    void testFindMax() {
        assertTrue(solution.searchMatrix(matrix, 30));
    }

    @Test
    @DisplayName("搜索不存在的值（小于最小）: 0 → false")
    void testBelowMin() {
        assertFalse(solution.searchMatrix(matrix, 0));
    }

    @Test
    @DisplayName("搜索不存在的值（大于最大）: 31 → false")
    void testAboveMax() {
        assertFalse(solution.searchMatrix(matrix, 31));
    }

    @Test
    @DisplayName("1x1矩阵 目标等于唯一元素 → true")
    void testSingleElementFound() {
        assertTrue(solution.searchMatrix(new int[][]{{5}}, 5));
    }

    @Test
    @DisplayName("1x1矩阵 目标不存在 → false")
    void testSingleElementNotFound() {
        assertFalse(solution.searchMatrix(new int[][]{{5}}, 3));
    }

    @Test
    @DisplayName("空矩阵 → false")
    void testEmptyMatrix() {
        assertFalse(solution.searchMatrix(new int[][]{}, 1));
    }
}
