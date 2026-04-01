package com.leetcode.m_堆;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T075 - P347 前K个高频元素")
class T075_P347_前K个高频元素Test {

    private T075_P347_前K个高频元素 solution;

    @BeforeEach
    void setUp() {
        solution = new T075_P347_前K个高频元素();
    }

    @Test
    @DisplayName("示例1：[1,1,1,2,2,3]，k=2，返回[1,2]")
    void testExample1() {
        int[] result = solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1,2}, result);
    }

    @Test
    @DisplayName("示例2：[1]，k=1，返回[1]")
    void testSingleElement() {
        int[] result = solution.topKFrequent(new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    @DisplayName("k=1，返回频率最高的元素")
    void testK1() {
        int[] result = solution.topKFrequent(new int[]{4,1,1,1,2,2,3}, 1);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    @DisplayName("所有元素相同频率，取前k个")
    void testEqualFrequency() {
        int[] result = solution.topKFrequent(new int[]{1,2,3,4}, 2);
        assertEquals(2, result.length);
    }

    @Test
    @DisplayName("结果数量等于k")
    void testResultSizeEqualsK() {
        int[] result = solution.topKFrequent(new int[]{1,1,2,2,3,3,4}, 3);
        assertEquals(3, result.length);
    }

    @Test
    @DisplayName("k等于不同元素数量")
    void testKEqualsDistinctCount() {
        int[] result = solution.topKFrequent(new int[]{1,1,2,3}, 3);
        assertEquals(3, result.length);
    }
}
