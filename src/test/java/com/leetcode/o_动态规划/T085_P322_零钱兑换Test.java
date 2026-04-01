package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T085 - P322 零钱兑换")
class T085_P322_零钱兑换Test {

    private T085_P322_零钱兑换 solution;

    @BeforeEach
    void setUp() {
        solution = new T085_P322_零钱兑换();
    }

    @Test
    @DisplayName("示例1：coins=[1,2,5], amount=11，最少3枚")
    void testExample1() {
        assertEquals(3, solution.coinChange(new int[]{1,2,5}, 11));
    }

    @Test
    @DisplayName("示例2：coins=[2], amount=3，无法凑成返回-1")
    void testExample2() {
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
    }

    @Test
    @DisplayName("amount=0，返回0")
    void testAmountZero() {
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
    }

    @Test
    @DisplayName("只有一种硬币可以整除")
    void testSingleCoin() {
        assertEquals(3, solution.coinChange(new int[]{3}, 9));
    }

    @Test
    @DisplayName("无法凑成（无1分硬币）")
    void testCannotMake() {
        assertEquals(-1, solution.coinChange(new int[]{5,10}, 3));
    }

    @Test
    @DisplayName("多种硬币选最优")
    void testOptimalChoice() {
        // coins=[1,5,10,25], amount=30 → 5+25=2枚（最优）
        assertEquals(2, solution.coinChange(new int[]{1,5,10,25}, 30));
    }

    @Test
    @DisplayName("amount等于硬币面值，1枚")
    void testExactMatch() {
        assertEquals(1, solution.coinChange(new int[]{1,2,5}, 5));
    }
}
