package com.leetcode.m_堆;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T074 - P215 数组中的第K个最大元素")
class T074_P215_数组中的第K个最大元素Test {

    private T074_P215_数组中的第K个最大元素 solution;

    @BeforeEach
    void setUp() {
        solution = new T074_P215_数组中的第K个最大元素();
    }

    @Test
    @DisplayName("示例1：[3,2,1,5,6,4]，k=2，返回5")
    void testExample1() {
        assertEquals(5, solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    @Test
    @DisplayName("示例2：[3,2,3,1,2,4,5,5,6]，k=4，返回4")
    void testExample2() {
        assertEquals(4, solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    @Test
    @DisplayName("k=1，返回最大值")
    void testKEquals1() {
        assertEquals(7, solution.findKthLargest(new int[]{1,3,7,2,5}, 1));
    }

    @Test
    @DisplayName("k=n，返回最小值")
    void testKEqualsN() {
        assertEquals(1, solution.findKthLargest(new int[]{1,3,7,2,5}, 5));
    }

    @Test
    @DisplayName("单元素数组")
    void testSingleElement() {
        assertEquals(3, solution.findKthLargest(new int[]{3}, 1));
    }

    @Test
    @DisplayName("含有重复元素")
    void testWithDuplicates() {
        assertEquals(4, solution.findKthLargest(new int[]{4,4,4,4}, 2));
    }

    @Test
    @DisplayName("负数数组")
    void testNegativeNumbers() {
        assertEquals(-2, solution.findKthLargest(new int[]{-1,-2,-3,-4,-5}, 2));
    }
}
