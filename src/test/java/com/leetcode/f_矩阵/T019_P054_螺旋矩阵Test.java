package com.leetcode.f_矩阵;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T019 - LeetCode #54 螺旋矩阵")
class T019_P054_螺旋矩阵Test {

    private T019_P054_螺旋矩阵 solution;

    @BeforeEach
    void setUp() {
        solution = new T019_P054_螺旋矩阵();
    }

    @Test
    @DisplayName("示例1: 3x3矩阵 → [1,2,3,6,9,8,7,4,5]")
    void testExample1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(matrix));
    }

    @Test
    @DisplayName("示例2: 3x4矩阵 → [1,2,3,4,8,12,11,10,9,5,6,7]")
    void testExample2() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), solution.spiralOrder(matrix));
    }

    @Test
    @DisplayName("1x1矩阵 → [1]")
    void testSingleElement() {
        assertEquals(Arrays.asList(1), solution.spiralOrder(new int[][]{{1}}));
    }

    @Test
    @DisplayName("1x4行矩阵 → [1,2,3,4]")
    void testSingleRow() {
        assertEquals(Arrays.asList(1, 2, 3, 4), solution.spiralOrder(new int[][]{{1, 2, 3, 4}}));
    }

    @Test
    @DisplayName("4x1列矩阵 → [1,2,3,4]")
    void testSingleColumn() {
        assertEquals(Arrays.asList(1, 2, 3, 4), solution.spiralOrder(new int[][]{{1}, {2}, {3}, {4}}));
    }

    @Test
    @DisplayName("2x2矩阵 → [1,2,4,3]")
    void test2x2() {
        int[][] matrix = {{1, 2}, {3, 4}};
        assertEquals(Arrays.asList(1, 2, 4, 3), solution.spiralOrder(matrix));
    }

    @Test
    @DisplayName("1x2矩阵 → [1,2]")
    void test1x2() {
        assertEquals(Arrays.asList(1, 2), solution.spiralOrder(new int[][]{{1, 2}}));
    }
}
