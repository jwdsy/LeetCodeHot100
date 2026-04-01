package com.leetcode.k_二分查找;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T067 - P153 寻找旋转排序数组中的最小值")
class T067_P153_寻找旋转排序数组中的最小值Test {

    private T067_P153_寻找旋转排序数组中的最小值 solution;

    @BeforeEach
    void setUp() {
        solution = new T067_P153_寻找旋转排序数组中的最小值();
    }

    @Test
    @DisplayName("示例1：[3,4,5,1,2]，最小值为1")
    void testExample1() {
        assertEquals(1, solution.findMin(new int[]{3,4,5,1,2}));
    }

    @Test
    @DisplayName("示例2：[4,5,6,7,0,1,2]，最小值为0")
    void testExample2() {
        assertEquals(0, solution.findMin(new int[]{4,5,6,7,0,1,2}));
    }

    @Test
    @DisplayName("示例3：[11,13,15,17]，未旋转，最小值为11")
    void testNotRotated() {
        assertEquals(11, solution.findMin(new int[]{11,13,15,17}));
    }

    @Test
    @DisplayName("单元素数组")
    void testSingleElement() {
        assertEquals(1, solution.findMin(new int[]{1}));
    }

    @Test
    @DisplayName("两元素数组，旋转")
    void testTwoElementsRotated() {
        assertEquals(1, solution.findMin(new int[]{2,1}));
    }

    @Test
    @DisplayName("两元素数组，未旋转")
    void testTwoElementsNotRotated() {
        assertEquals(1, solution.findMin(new int[]{1,2}));
    }

    @Test
    @DisplayName("旋转一位")
    void testRotateByOne() {
        assertEquals(1, solution.findMin(new int[]{2,3,4,5,1}));
    }

    @Test
    @DisplayName("旋转到最后一位是最小值")
    void testMinAtEnd() {
        assertEquals(0, solution.findMin(new int[]{1,2,3,4,0}));
    }
}
