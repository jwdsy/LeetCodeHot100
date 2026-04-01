package com.leetcode.m_堆;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T076 - P295 数据流的中位数")
class T076_P295_数据流的中位数Test {

    private T076_P295_数据流的中位数 finder;
    private static final double DELTA = 1e-5;

    @BeforeEach
    void setUp() {
        finder = new T076_P295_数据流的中位数();
    }

    @Test
    @DisplayName("示例：addNum(1)/addNum(2)/findMedian/addNum(3)/findMedian")
    void testExample() {
        finder.addNum(1);
        finder.addNum(2);
        assertEquals(1.5, finder.findMedian(), DELTA);
        finder.addNum(3);
        assertEquals(2.0, finder.findMedian(), DELTA);
    }

    @Test
    @DisplayName("单个元素的中位数")
    void testSingleElement() {
        finder.addNum(5);
        assertEquals(5.0, finder.findMedian(), DELTA);
    }

    @Test
    @DisplayName("两个元素，中位数为均值")
    void testTwoElements() {
        finder.addNum(1);
        finder.addNum(3);
        assertEquals(2.0, finder.findMedian(), DELTA);
    }

    @Test
    @DisplayName("乱序插入，中位数正确")
    void testOutOfOrder() {
        finder.addNum(6);
        finder.addNum(1);
        finder.addNum(3);
        // 排序后 [1,3,6] 中位数 = 3
        assertEquals(3.0, finder.findMedian(), DELTA);
    }

    @Test
    @DisplayName("偶数个元素，中位数为中间两数均值")
    void testEvenCount() {
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        finder.addNum(4);
        assertEquals(2.5, finder.findMedian(), DELTA);
    }

    @Test
    @DisplayName("重复元素")
    void testDuplicates() {
        finder.addNum(5);
        finder.addNum(5);
        finder.addNum(5);
        assertEquals(5.0, finder.findMedian(), DELTA);
    }

    @Test
    @DisplayName("负数元素")
    void testNegativeNumbers() {
        finder.addNum(-5);
        finder.addNum(-3);
        finder.addNum(-1);
        assertEquals(-3.0, finder.findMedian(), DELTA);
    }
}
