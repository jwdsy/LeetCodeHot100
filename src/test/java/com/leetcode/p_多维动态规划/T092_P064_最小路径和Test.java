package com.leetcode.p_多维动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T092 - P64 最小路径和")
class T092_P064_最小路径和Test {

    private T092_P064_最小路径和 solution;

    @BeforeEach
    void setUp() {
        solution = new T092_P064_最小路径和();
    }

    @Test
    @DisplayName("示例1：3x3网格，最小路径和7")
    void testExample1() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        assertEquals(7, solution.minPathSum(grid));
    }

    @Test
    @DisplayName("示例2：2x3网格，最小路径和12")
    void testExample2() {
        int[][] grid = {{1,2,3},{4,5,6}};
        assertEquals(12, solution.minPathSum(grid));
    }

    @Test
    @DisplayName("1x1网格，路径和等于唯一元素")
    void testSingleCell() {
        assertEquals(5, solution.minPathSum(new int[][]{{5}}));
    }

    @Test
    @DisplayName("1行网格，路径和等于所有元素之和")
    void testSingleRow() {
        assertEquals(6, solution.minPathSum(new int[][]{{1,2,3}}));
    }

    @Test
    @DisplayName("1列网格，路径和等于所有元素之和")
    void testSingleColumn() {
        assertEquals(6, solution.minPathSum(new int[][]{{1},{2},{3}}));
    }

    @Test
    @DisplayName("全零网格，路径和为0")
    void testAllZero() {
        int[][] grid = {{0,0},{0,0}};
        assertEquals(0, solution.minPathSum(grid));
    }

    @Test
    @DisplayName("选择最优路径（不走最大值格子）")
    void testAvoidMaxCell() {
        // [[1,100],[1,1]] → 路径1→1→1=3，而1→100→1=102
        assertEquals(3, solution.minPathSum(new int[][]{{1,100},{1,1}}));
    }
}
