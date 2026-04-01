package com.leetcode.q_技巧;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T100 - P287 寻找重复数")
class T100_P287_寻找重复数Test {

    private T100_P287_寻找重复数 solution;

    @BeforeEach
    void setUp() {
        solution = new T100_P287_寻找重复数();
    }

    @Test
    @DisplayName("示例1：[1,3,4,2,2]，重复数为2")
    void testExample1() {
        assertEquals(2, solution.findDuplicate(new int[]{1,3,4,2,2}));
    }

    @Test
    @DisplayName("示例2：[3,1,3,4,2]，重复数为3")
    void testExample2() {
        assertEquals(3, solution.findDuplicate(new int[]{3,1,3,4,2}));
    }

    @Test
    @DisplayName("两元素，只有一个重复")
    void testTwoElements() {
        assertEquals(1, solution.findDuplicate(new int[]{1,1}));
    }

    @Test
    @DisplayName("重复数在首位")
    void testDuplicateAtStart() {
        assertEquals(2, solution.findDuplicate(new int[]{2,2,1,3,4}));
    }

    @Test
    @DisplayName("重复数在末位")
    void testDuplicateAtEnd() {
        assertEquals(4, solution.findDuplicate(new int[]{1,2,3,4,4}));
    }

    @Test
    @DisplayName("重复数为1")
    void testDuplicateIsOne() {
        assertEquals(1, solution.findDuplicate(new int[]{1,1,2,3,4}));
    }

    @Test
    @DisplayName("重复数多次出现")
    void testMultipleOccurrences() {
        // [1,2,2,2,3] → 重复数为2
        assertEquals(2, solution.findDuplicate(new int[]{1,2,2,2,3}));
    }

    @Test
    @DisplayName("较大数组")
    void testLargerArray() {
        // 1..5中3重复: [1,3,4,3,2,5]
        assertEquals(3, solution.findDuplicate(new int[]{1,3,4,3,2,5}));
    }
}
