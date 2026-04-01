package com.leetcode.e_普通数组;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T016 - LeetCode #238 除了自身以外数组的乘积")
class T016_P238_除了自身以外数组的乘积Test {

    private T016_P238_除了自身以外数组的乘积 solution;

    @BeforeEach
    void setUp() {
        solution = new T016_P238_除了自身以外数组的乘积();
    }

    @Test
    @DisplayName("示例1: [1,2,3,4] → [24,12,8,6]")
    void testExample1() {
        assertArrayEquals(new int[]{24, 12, 8, 6},
                solution.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    @Test
    @DisplayName("示例2: [-1,1,0,-3,3] → [0,0,9,0,0]（含零）")
    void testWithZero() {
        assertArrayEquals(new int[]{0, 0, 9, 0, 0},
                solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    @Test
    @DisplayName("含两个零: [0,0,1,2] → [0,0,0,0]")
    void testTwoZeros() {
        assertArrayEquals(new int[]{0, 0, 0, 0},
                solution.productExceptSelf(new int[]{0, 0, 1, 2}));
    }

    @Test
    @DisplayName("两个元素: [3,4] → [4,3]")
    void testTwoElements() {
        assertArrayEquals(new int[]{4, 3},
                solution.productExceptSelf(new int[]{3, 4}));
    }

    @Test
    @DisplayName("全为1: [1,1,1,1] → [1,1,1,1]")
    void testAllOnes() {
        assertArrayEquals(new int[]{1, 1, 1, 1},
                solution.productExceptSelf(new int[]{1, 1, 1, 1}));
    }

    @Test
    @DisplayName("含负数: [-1,-2,-3,-4] → [-24,-12,-8,-6]")
    void testAllNegative() {
        assertArrayEquals(new int[]{-24, -12, -8, -6},
                solution.productExceptSelf(new int[]{-1, -2, -3, -4}));
    }

    @Test
    @DisplayName("含大数: [2,3,5,7] → [105,70,42,30]")
    void testLargerNumbers() {
        assertArrayEquals(new int[]{105, 70, 42, 30},
                solution.productExceptSelf(new int[]{2, 3, 5, 7}));
    }
}
