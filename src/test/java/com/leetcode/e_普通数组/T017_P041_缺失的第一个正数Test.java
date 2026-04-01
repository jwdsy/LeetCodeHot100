package com.leetcode.e_普通数组;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T017 - LeetCode #41 缺失的第一个正数")
class T017_P041_缺失的第一个正数Test {

    private T017_P041_缺失的第一个正数 solution;

    @BeforeEach
    void setUp() {
        solution = new T017_P041_缺失的第一个正数();
    }

    @Test
    @DisplayName("示例1: [1,2,0] → 3")
    void testExample1() {
        assertEquals(3, solution.firstMissingPositive(new int[]{1, 2, 0}));
    }

    @Test
    @DisplayName("示例2: [3,4,-1,1] → 2")
    void testExample2() {
        assertEquals(2, solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    @Test
    @DisplayName("示例3: [7,8,9,11,12] → 1（从1开始缺失）")
    void testMissingOne() {
        assertEquals(1, solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    @DisplayName("连续正整数: [1,2,3,4,5] → 6")
    void testConsecutive() {
        assertEquals(6, solution.firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("单元素[1] → 2")
    void testSingleOne() {
        assertEquals(2, solution.firstMissingPositive(new int[]{1}));
    }

    @Test
    @DisplayName("单元素[2] → 1")
    void testSingleTwo() {
        assertEquals(1, solution.firstMissingPositive(new int[]{2}));
    }

    @Test
    @DisplayName("全为负数: [-1,-2,-3] → 1")
    void testAllNegative() {
        assertEquals(1, solution.firstMissingPositive(new int[]{-1, -2, -3}));
    }

    @Test
    @DisplayName("包含重复元素: [1,1,2,2] → 3")
    void testWithDuplicates() {
        assertEquals(3, solution.firstMissingPositive(new int[]{1, 1, 2, 2}));
    }
}
