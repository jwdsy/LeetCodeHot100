package com.leetcode.q_技巧;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T097 - P169 多数元素")
class T097_P169_多数元素Test {

    private T097_P169_多数元素 solution;

    @BeforeEach
    void setUp() {
        solution = new T097_P169_多数元素();
    }

    @Test
    @DisplayName("示例1：[3,2,3]，多数元素为3")
    void testExample1() {
        assertEquals(3, solution.majorityElement(new int[]{3,2,3}));
    }

    @Test
    @DisplayName("示例2：[2,2,1,1,1,2,2]，多数元素为2")
    void testExample2() {
        assertEquals(2, solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    @Test
    @DisplayName("单元素，本身是多数元素")
    void testSingleElement() {
        assertEquals(5, solution.majorityElement(new int[]{5}));
    }

    @Test
    @DisplayName("全相同元素")
    void testAllSame() {
        assertEquals(4, solution.majorityElement(new int[]{4,4,4,4}));
    }

    @Test
    @DisplayName("多数元素出现超过n/2次")
    void testMajorityAtHalf() {
        // [1,1,2,2,1] → 1出现3次 > 5/2
        assertEquals(1, solution.majorityElement(new int[]{1,1,2,2,1}));
    }

    @Test
    @DisplayName("含有负数的多数元素")
    void testNegativeMajority() {
        assertEquals(-1, solution.majorityElement(new int[]{-1,-1,2}));
    }
}
