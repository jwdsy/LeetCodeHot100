package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T088 - P152 乘积最大子数组")
class T088_P152_乘积最大子数组Test {

    private T088_P152_乘积最大子数组 solution;

    @BeforeEach
    void setUp() {
        solution = new T088_P152_乘积最大子数组();
    }

    @Test
    @DisplayName("示例1：[2,3,-2,4]，最大乘积6")
    void testExample1() {
        assertEquals(6, solution.maxProduct(new int[]{2,3,-2,4}));
    }

    @Test
    @DisplayName("示例2：[-2,0,-1]，最大乘积0")
    void testExample2() {
        assertEquals(0, solution.maxProduct(new int[]{-2,0,-1}));
    }

    @Test
    @DisplayName("示例3：[-2,3,-4]，负负得正，最大乘积24")
    void testNegativeTimesNegative() {
        assertEquals(24, solution.maxProduct(new int[]{-2,3,-4}));
    }

    @Test
    @DisplayName("单元素正数")
    void testSinglePositive() {
        assertEquals(5, solution.maxProduct(new int[]{5}));
    }

    @Test
    @DisplayName("单元素负数")
    void testSingleNegative() {
        assertEquals(-2, solution.maxProduct(new int[]{-2}));
    }

    @Test
    @DisplayName("全部正数，最大乘积为全数组乘积")
    void testAllPositive() {
        assertEquals(24, solution.maxProduct(new int[]{1,2,3,4}));
    }

    @Test
    @DisplayName("含有0，0将数组分割")
    void testContainsZero() {
        // [2,3,0,4,5] → max(6, 0, 20) = 20
        assertEquals(20, solution.maxProduct(new int[]{2,3,0,4,5}));
    }

    @Test
    @DisplayName("两个负数中间有负数，最大乘积处理")
    void testAlternatingNegatives() {
        // [-2,-3,-4] → 最大乘积 = 12 ([-2,-3]或[-3,-4])
        assertEquals(12, solution.maxProduct(new int[]{-2,-3,-4}));
    }
}
