package com.leetcode.q_技巧;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T096 - P136 只出现一次的数字")
class T096_P136_只出现一次的数字Test {

    private T096_P136_只出现一次的数字 solution;

    @BeforeEach
    void setUp() {
        solution = new T096_P136_只出现一次的数字();
    }

    @Test
    @DisplayName("示例1：[2,2,1]，返回1")
    void testExample1() {
        assertEquals(1, solution.singleNumber(new int[]{2,2,1}));
    }

    @Test
    @DisplayName("示例2：[4,1,2,1,2]，返回4")
    void testExample2() {
        assertEquals(4, solution.singleNumber(new int[]{4,1,2,1,2}));
    }

    @Test
    @DisplayName("示例3：[1]，单元素，返回1")
    void testSingleElement() {
        assertEquals(1, solution.singleNumber(new int[]{1}));
    }

    @Test
    @DisplayName("出现一次的数字在首位")
    void testSingleAtStart() {
        assertEquals(7, solution.singleNumber(new int[]{7,3,3,5,5}));
    }

    @Test
    @DisplayName("出现一次的数字在末位")
    void testSingleAtEnd() {
        assertEquals(9, solution.singleNumber(new int[]{1,1,2,2,9}));
    }

    @Test
    @DisplayName("含有负数")
    void testNegativeNumber() {
        assertEquals(-1, solution.singleNumber(new int[]{-1,2,2}));
    }

    @Test
    @DisplayName("含有零")
    void testZero() {
        assertEquals(0, solution.singleNumber(new int[]{0,1,1}));
    }
}
