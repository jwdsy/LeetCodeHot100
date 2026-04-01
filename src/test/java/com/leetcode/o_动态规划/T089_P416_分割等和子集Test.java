package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T089 - P416 分割等和子集")
class T089_P416_分割等和子集Test {

    private T089_P416_分割等和子集 solution;

    @BeforeEach
    void setUp() {
        solution = new T089_P416_分割等和子集();
    }

    @Test
    @DisplayName("示例1：[1,5,11,5]，可以分割")
    void testExample1() {
        assertTrue(solution.canPartition(new int[]{1,5,11,5}));
    }

    @Test
    @DisplayName("示例2：[1,2,3,5]，总和11奇数，不可分割")
    void testExample2() {
        assertFalse(solution.canPartition(new int[]{1,2,3,5}));
    }

    @Test
    @DisplayName("总和为偶数但无法分割：[1,2,3] 可以分割为[1,2]和[3]")
    void testOddSum() {
        // [1,2,3] 总和=6，target=3，1+2=3 ✓，可以分割
        assertTrue(solution.canPartition(new int[]{1,2,3}));
    }

    @Test
    @DisplayName("两个相同元素，可以分割")
    void testTwoSameElements() {
        assertTrue(solution.canPartition(new int[]{3,3}));
    }

    @Test
    @DisplayName("一个元素大于总和一半，不可分割")
    void testOneElementTooLarge() {
        assertFalse(solution.canPartition(new int[]{1,2,10}));
    }

    @Test
    @DisplayName("[2,2,3,5]，总和12目标6，无法凑出6，不可分割")
    void testCombinedPartition() {
        // [2,2,3,5] 总和=12，target=6，所有组合均无法凑出6
        assertFalse(solution.canPartition(new int[]{2,2,3,5}));
    }

    @Test
    @DisplayName("[1,1]，可以分割")
    void testMinimal() {
        assertTrue(solution.canPartition(new int[]{1,1}));
    }

    @Test
    @DisplayName("全相同偶数个元素，可以分割")
    void testAllSameEven() {
        assertTrue(solution.canPartition(new int[]{4,4,4,4}));
    }
}
