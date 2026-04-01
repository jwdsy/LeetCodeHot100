package com.leetcode.f_矩阵;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T020 - LeetCode #48 旋转图像")
class T020_P048_旋转图像Test {

    private T020_P048_旋转图像 solution;

    @BeforeEach
    void setUp() {
        solution = new T020_P048_旋转图像();
    }

    @Test
    @DisplayName("示例1: 3x3 → [[7,4,1],[8,5,2],[9,6,3]]")
    void testExample1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        assertArrayEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, matrix);
    }

    @Test
    @DisplayName("示例2: 4x4 → [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]")
    void testExample2() {
        int[][] matrix = {
            {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
        };
        solution.rotate(matrix);
        assertArrayEquals(new int[][]{
            {15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}
        }, matrix);
    }

    @Test
    @DisplayName("1x1矩阵 → 不变")
    void testSingleElement() {
        int[][] matrix = {{5}};
        solution.rotate(matrix);
        assertArrayEquals(new int[][]{{5}}, matrix);
    }

    @Test
    @DisplayName("2x2矩阵: [[1,2],[3,4]] → [[3,1],[4,2]]")
    void test2x2() {
        int[][] matrix = {{1, 2}, {3, 4}};
        solution.rotate(matrix);
        assertArrayEquals(new int[][]{{3, 1}, {4, 2}}, matrix);
    }

    @Test
    @DisplayName("全相同元素: [[1,1],[1,1]] → [[1,1],[1,1]]")
    void testAllSame() {
        int[][] matrix = {{1, 1}, {1, 1}};
        solution.rotate(matrix);
        assertArrayEquals(new int[][]{{1, 1}, {1, 1}}, matrix);
    }

    @Test
    @DisplayName("旋转4次恢复原状")
    void testRotateFourTimes() {
        int[][] original = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 4; i++) {
            solution.rotate(matrix);
        }
        assertArrayEquals(original, matrix);
    }
}
