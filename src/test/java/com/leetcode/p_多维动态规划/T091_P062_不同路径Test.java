package com.leetcode.p_多维动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T091 - P62 不同路径")
class T091_P062_不同路径Test {

    private T091_P062_不同路径 solution;

    @BeforeEach
    void setUp() {
        solution = new T091_P062_不同路径();
    }

    @Test
    @DisplayName("示例1：m=3, n=7，28条路径")
    void testExample1() {
        assertEquals(28, solution.uniquePaths(3, 7));
    }

    @Test
    @DisplayName("示例2：m=3, n=2，3条路径")
    void testExample2() {
        assertEquals(3, solution.uniquePaths(3, 2));
    }

    @Test
    @DisplayName("m=1, n=1，只有1条路径（原地即终点）")
    void testOneByOne() {
        assertEquals(1, solution.uniquePaths(1, 1));
    }

    @Test
    @DisplayName("m=1，单行，只有1条路径")
    void testSingleRow() {
        assertEquals(1, solution.uniquePaths(1, 10));
    }

    @Test
    @DisplayName("n=1，单列，只有1条路径")
    void testSingleColumn() {
        assertEquals(1, solution.uniquePaths(10, 1));
    }

    @Test
    @DisplayName("m=2, n=2，2条路径")
    void testTwoByTwo() {
        assertEquals(2, solution.uniquePaths(2, 2));
    }

    @Test
    @DisplayName("m=3, n=3，6条路径")
    void testThreeByThree() {
        assertEquals(6, solution.uniquePaths(3, 3));
    }
}
