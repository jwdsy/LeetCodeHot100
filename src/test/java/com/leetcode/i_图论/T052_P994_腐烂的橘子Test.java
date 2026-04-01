package com.leetcode.i_图论;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T052 - P994 腐烂的橘子")
class T052_P994_腐烂的橘子Test {

    private T052_P994_腐烂的橘子 solution;

    @BeforeEach
    void setUp() {
        solution = new T052_P994_腐烂的橘子();
    }

    @Test
    @DisplayName("示例1：需要4分钟")
    void testExample1() {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        assertEquals(4, solution.orangesRotting(grid));
    }

    @Test
    @DisplayName("示例2：不可能全部腐烂")
    void testImpossible() {
        int[][] grid = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    @DisplayName("示例3：没有新鲜橘子，返回0")
    void testNoFresh() {
        int[][] grid = {{0,2}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    @DisplayName("全是新鲜橘子，无腐烂源，返回-1")
    void testAllFreshNoRotten() {
        int[][] grid = {{1,1},{1,1}};
        assertEquals(-1, solution.orangesRotting(grid));
    }

    @Test
    @DisplayName("全是腐烂橘子，返回0")
    void testAllRotten() {
        int[][] grid = {{2,2},{2,2}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    @DisplayName("空格子，返回0")
    void testAllEmpty() {
        int[][] grid = {{0,0},{0,0}};
        assertEquals(0, solution.orangesRotting(grid));
    }

    @Test
    @DisplayName("多个腐烂源同时扩散")
    void testMultipleRottenSources() {
        int[][] grid = {
            {2,1,1},
            {1,1,2},
            {1,1,1}
        };
        assertEquals(2, solution.orangesRotting(grid));
    }

    @Test
    @DisplayName("一行橘子逐步腐烂")
    void testSingleRowChain() {
        int[][] grid = {{2,1,1,1,1}};
        assertEquals(4, solution.orangesRotting(grid));
    }
}
