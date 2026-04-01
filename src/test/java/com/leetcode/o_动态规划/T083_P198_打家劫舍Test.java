package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T083 - P198 打家劫舍")
class T083_P198_打家劫舍Test {

    private T083_P198_打家劫舍 solution;

    @BeforeEach
    void setUp() {
        solution = new T083_P198_打家劫舍();
    }

    @Test
    @DisplayName("示例1：[1,2,3,1]，最大金额4")
    void testExample1() {
        assertEquals(4, solution.rob(new int[]{1,2,3,1}));
    }

    @Test
    @DisplayName("示例2：[2,7,9,3,1]，最大金额12")
    void testExample2() {
        assertEquals(12, solution.rob(new int[]{2,7,9,3,1}));
    }

    @Test
    @DisplayName("单元素")
    void testSingleElement() {
        assertEquals(5, solution.rob(new int[]{5}));
    }

    @Test
    @DisplayName("两元素，取较大")
    void testTwoElements() {
        assertEquals(3, solution.rob(new int[]{1,3}));
    }

    @Test
    @DisplayName("相邻房屋不能同时偷")
    void testNotAdjacent() {
        // [3,10,3,1,2] 偷10+2=12 or 10+3? 偷索引1+索引4=12
        assertEquals(12, solution.rob(new int[]{3,10,3,1,2}));
    }

    @Test
    @DisplayName("全零数组，结果为0")
    void testAllZero() {
        assertEquals(0, solution.rob(new int[]{0,0,0}));
    }

    @Test
    @DisplayName("递增数组")
    void testAscending() {
        // [1,2,3,4,5] → 偷1+3+5=9
        assertEquals(9, solution.rob(new int[]{1,2,3,4,5}));
    }
}
