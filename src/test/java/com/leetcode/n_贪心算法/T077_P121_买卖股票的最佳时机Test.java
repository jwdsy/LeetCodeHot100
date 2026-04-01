package com.leetcode.n_贪心算法;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T077 - P121 买卖股票的最佳时机")
class T077_P121_买卖股票的最佳时机Test {

    private T077_P121_买卖股票的最佳时机 solution;

    @BeforeEach
    void setUp() {
        solution = new T077_P121_买卖股票的最佳时机();
    }

    @Test
    @DisplayName("示例1：[7,1,5,3,6,4]，最大利润5")
    void testExample1() {
        assertEquals(5, solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    @Test
    @DisplayName("示例2：[7,6,4,3,1]，价格持续下跌，利润0")
    void testNoProfit() {
        assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
    }

    @Test
    @DisplayName("单元素，利润0")
    void testSingleElement() {
        assertEquals(0, solution.maxProfit(new int[]{5}));
    }

    @Test
    @DisplayName("两元素递增，利润=差值")
    void testTwoAscending() {
        assertEquals(3, solution.maxProfit(new int[]{1,4}));
    }

    @Test
    @DisplayName("两元素递减，利润0")
    void testTwoDescending() {
        assertEquals(0, solution.maxProfit(new int[]{4,1}));
    }

    @Test
    @DisplayName("价格先跌后涨再跌，取最大差值")
    void testDownThenUp() {
        assertEquals(9, solution.maxProfit(new int[]{3,1,10,2}));
    }

    @Test
    @DisplayName("全部价格相同，利润0")
    void testAllSame() {
        assertEquals(0, solution.maxProfit(new int[]{5,5,5,5}));
    }
}
