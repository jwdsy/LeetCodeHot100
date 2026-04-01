package com.leetcode.k_二分查找;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T068 - P4 寻找两个正序数组的中位数")
class T068_P004_寻找两个正序数组的中位数Test {

    private T068_P004_寻找两个正序数组的中位数 solution;
    private static final double DELTA = 1e-5;

    @BeforeEach
    void setUp() {
        solution = new T068_P004_寻找两个正序数组的中位数();
    }

    @Test
    @DisplayName("示例1：[1,3] 和 [2]，中位数为2.0")
    void testOddTotal() {
        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), DELTA);
    }

    @Test
    @DisplayName("示例2：[1,2] 和 [3,4]，中位数为2.5")
    void testEvenTotal() {
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), DELTA);
    }

    @Test
    @DisplayName("一个空数组")
    void testOneEmpty() {
        assertEquals(1.0, solution.findMedianSortedArrays(new int[]{}, new int[]{1}), DELTA);
        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1,2,3}, new int[]{}), DELTA);
    }

    @Test
    @DisplayName("两个单元素数组")
    void testBothSingleElement() {
        assertEquals(1.5, solution.findMedianSortedArrays(new int[]{1}, new int[]{2}), DELTA);
    }

    @Test
    @DisplayName("不交叉的两个数组")
    void testNoOverlap() {
        // [1,2] 和 [3,4] → 合并[1,2,3,4] 中位数2.5
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), DELTA);
    }

    @Test
    @DisplayName("第一个数组全部小于第二个")
    void testFirstAllSmaller() {
        assertEquals(3.0, solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4,5}), DELTA);
    }

    @Test
    @DisplayName("相同元素")
    void testSameElements() {
        assertEquals(1.0, solution.findMedianSortedArrays(new int[]{1,1}, new int[]{1,1}), DELTA);
    }

    @Test
    @DisplayName("较大长度差异")
    void testLargeAndSmall() {
        // [1,2,3,4,5] 和 [6] → 合并[1,2,3,4,5,6] 中位数3.5
        assertEquals(3.5, solution.findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[]{6}), DELTA);
    }
}
