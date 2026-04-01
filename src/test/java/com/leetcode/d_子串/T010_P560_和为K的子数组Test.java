package com.leetcode.d_子串;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T010 - LeetCode #560 和为K的子数组")
class T010_P560_和为K的子数组Test {

    private T010_P560_和为K的子数组 solution;

    @BeforeEach
    void setUp() {
        solution = new T010_P560_和为K的子数组();
    }

    @Test
    @DisplayName("示例1: nums=[1,1,1], k=2 → 2")
    void testExample1() {
        assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
    }

    @Test
    @DisplayName("示例2: nums=[1,2,3], k=3 → 2")
    void testExample2() {
        assertEquals(2, solution.subarraySum(new int[]{1, 2, 3}, 3));
    }

    @Test
    @DisplayName("单个元素等于k: [5], k=5 → 1")
    void testSingleElement() {
        assertEquals(1, solution.subarraySum(new int[]{5}, 5));
    }

    @Test
    @DisplayName("单个元素不等于k: [5], k=3 → 0")
    void testSingleElementNoMatch() {
        assertEquals(0, solution.subarraySum(new int[]{5}, 3));
    }

    @Test
    @DisplayName("含负数: [1,-1,1], k=1 → 3")
    void testWithNegativeNumbers() {
        assertEquals(3, solution.subarraySum(new int[]{1, -1, 1}, 1));
    }

    @Test
    @DisplayName("k=0: [0,0,0], k=0 → 6")
    void testKEqualsZero() {
        assertEquals(6, solution.subarraySum(new int[]{0, 0, 0}, 0));
    }

    @Test
    @DisplayName("整个数组之和等于k: [1,2,3], k=6 → 1")
    void testEntireArraySum() {
        assertEquals(1, solution.subarraySum(new int[]{1, 2, 3}, 6));
    }

    @Test
    @DisplayName("无满足条件的子数组: [1,2,3], k=7 → 0")
    void testNoMatch() {
        assertEquals(0, solution.subarraySum(new int[]{1, 2, 3}, 7));
    }
}
