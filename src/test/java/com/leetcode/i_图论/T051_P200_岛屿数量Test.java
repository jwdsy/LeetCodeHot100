package com.leetcode.i_图论;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T051 - P200 岛屿数量")
class T051_P200_岛屿数量Test {

    private T051_P200_岛屿数量 solution;

    @BeforeEach
    void setUp() {
        solution = new T051_P200_岛屿数量();
    }

    @Test
    @DisplayName("示例1：多个岛屿")
    void testMultipleIslands() {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("示例2：三个岛屿")
    void testThreeIslands() {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    @DisplayName("全是水")
    void testAllWater() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'}
        };
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    @DisplayName("全是陆地：一个大岛")
    void testAllLand() {
        char[][] grid = {
            {'1','1','1'},
            {'1','1','1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("每个单元格都是独立岛屿（被水隔开）")
    void testCheckerboard() {
        char[][] grid = {
            {'1','0','1'},
            {'0','1','0'},
            {'1','0','1'}
        };
        assertEquals(5, solution.numIslands(grid));
    }

    @Test
    @DisplayName("单行网格")
    void testSingleRow() {
        char[][] grid = {{'1','0','1','1','0','1'}};
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    @DisplayName("单列网格")
    void testSingleColumn() {
        char[][] grid = {{'1'},{'0'},{'1'},{'1'}};
        assertEquals(2, solution.numIslands(grid));
    }

    @Test
    @DisplayName("单个陆地格子")
    void testSingleLand() {
        char[][] grid = {{'1'}};
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("单个水格子")
    void testSingleWater() {
        char[][] grid = {{'0'}};
        assertEquals(0, solution.numIslands(grid));
    }
}
