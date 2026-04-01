package com.leetcode.k_二分查找;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T064 - P74 搜索二维矩阵")
class T064_P074_搜索二维矩阵Test {

    private T064_P074_搜索二维矩阵 solution;

    @BeforeEach
    void setUp() {
        solution = new T064_P074_搜索二维矩阵();
    }

    @Test
    @DisplayName("示例1：目标存在")
    void testTargetExists() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        assertTrue(solution.searchMatrix(matrix, 3));
    }

    @Test
    @DisplayName("示例2：目标不存在")
    void testTargetNotExists() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        assertFalse(solution.searchMatrix(matrix, 13));
    }

    @Test
    @DisplayName("目标在矩阵左上角")
    void testTopLeft() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20}};
        assertTrue(solution.searchMatrix(matrix, 1));
    }

    @Test
    @DisplayName("目标在矩阵右下角")
    void testBottomRight() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20}};
        assertTrue(solution.searchMatrix(matrix, 20));
    }

    @Test
    @DisplayName("小于所有元素，不存在")
    void testSmallerThanAll() {
        int[][] matrix = {{2,4},{6,8}};
        assertFalse(solution.searchMatrix(matrix, 1));
    }

    @Test
    @DisplayName("大于所有元素，不存在")
    void testLargerThanAll() {
        int[][] matrix = {{2,4},{6,8}};
        assertFalse(solution.searchMatrix(matrix, 9));
    }

    @Test
    @DisplayName("单元素矩阵，目标存在")
    void testSingleElement() {
        assertTrue(solution.searchMatrix(new int[][]{{5}}, 5));
    }

    @Test
    @DisplayName("单元素矩阵，目标不存在")
    void testSingleElementNotFound() {
        assertFalse(solution.searchMatrix(new int[][]{{5}}, 3));
    }
}
