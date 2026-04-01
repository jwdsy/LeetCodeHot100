package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T084 - P279 完全平方数")
class T084_P279_完全平方数Test {

    private T084_P279_完全平方数 solution;

    @BeforeEach
    void setUp() {
        solution = new T084_P279_完全平方数();
    }

    @Test
    @DisplayName("示例1：n=12，最少3个（4+4+4）")
    void testExample1() {
        assertEquals(3, solution.numSquares(12));
    }

    @Test
    @DisplayName("示例2：n=13，最少2个（4+9）")
    void testExample2() {
        assertEquals(2, solution.numSquares(13));
    }

    @Test
    @DisplayName("n=1，1个")
    void testN1() {
        assertEquals(1, solution.numSquares(1));
    }

    @Test
    @DisplayName("n=4，1个（本身是完全平方数）")
    void testPerfectSquare() {
        assertEquals(1, solution.numSquares(4));
    }

    @Test
    @DisplayName("n=9，1个")
    void testN9() {
        assertEquals(1, solution.numSquares(9));
    }

    @Test
    @DisplayName("n=2，2个（1+1）")
    void testN2() {
        assertEquals(2, solution.numSquares(2));
    }

    @Test
    @DisplayName("n=3，3个（1+1+1）")
    void testN3() {
        assertEquals(3, solution.numSquares(3));
    }

    @Test
    @DisplayName("n=7，4个（4+1+1+1）")
    void testN7() {
        assertEquals(4, solution.numSquares(7));
    }
}
