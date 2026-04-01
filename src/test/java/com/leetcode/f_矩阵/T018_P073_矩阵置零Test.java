package com.leetcode.f_矩阵;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T018 - LeetCode #73 矩阵置零")
class T018_P073_矩阵置零Test {

    private T018_P073_矩阵置零 solution;

    @BeforeEach
    void setUp() {
        solution = new T018_P073_矩阵置零();
    }

    @Test
    @DisplayName("示例1: [[1,1,1],[1,0,1],[1,1,1]] → [[1,0,1],[0,0,0],[1,0,1]]")
    void testExample1() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, matrix);
    }

    @Test
    @DisplayName("示例2: [[0,1,2,0],[3,4,5,2],[1,3,1,5]] → [[0,0,0,0],[0,4,5,0],[0,3,1,0]]")
    void testExample2() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, matrix);
    }

    @Test
    @DisplayName("无零元素 → 矩阵不变")
    void testNoZero() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, matrix);
    }

    @Test
    @DisplayName("全为零 → 全为零")
    void testAllZero() {
        int[][] matrix = {{0, 0}, {0, 0}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0, 0}, {0, 0}}, matrix);
    }

    @Test
    @DisplayName("单行矩阵: [[1,0,1]] → [[0,0,0]]")
    void testSingleRow() {
        int[][] matrix = {{1, 0, 1}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0, 0, 0}}, matrix);
    }

    @Test
    @DisplayName("单列矩阵: [[1],[0],[1]] → [[0],[0],[0]]")
    void testSingleCol() {
        int[][] matrix = {{1}, {0}, {1}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0}, {0}, {0}}, matrix);
    }

    @Test
    @DisplayName("零在角落: [[0,1],[1,1]] → [[0,0],[0,1]]")
    void testZeroAtCorner() {
        int[][] matrix = {{0, 1}, {1, 1}};
        solution.setZeroes(matrix);
        assertArrayEquals(new int[][]{{0, 0}, {0, 1}}, matrix);
    }
}
