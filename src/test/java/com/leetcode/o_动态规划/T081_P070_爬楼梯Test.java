package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T081 - P70 爬楼梯")
class T081_P070_爬楼梯Test {

    private T081_P070_爬楼梯 solution;

    @BeforeEach
    void setUp() {
        solution = new T081_P070_爬楼梯();
    }

    @Test
    @DisplayName("n=1：1种方法")
    void testN1() {
        assertEquals(1, solution.climbStairs(1));
    }

    @Test
    @DisplayName("n=2：2种方法")
    void testN2() {
        assertEquals(2, solution.climbStairs(2));
    }

    @Test
    @DisplayName("n=3：3种方法")
    void testN3() {
        assertEquals(3, solution.climbStairs(3));
    }

    @Test
    @DisplayName("n=5：8种方法（斐波那契数列）")
    void testN5() {
        assertEquals(8, solution.climbStairs(5));
    }

    @Test
    @DisplayName("n=10：89种方法")
    void testN10() {
        assertEquals(89, solution.climbStairs(10));
    }

    @Test
    @DisplayName("三种解法结果一致")
    void testThreeMethodsConsistent() {
        for (int n = 1; n <= 10; n++) {
            int r1 = solution.climbStairs(n);
            int r2 = solution.climbStairs2(n);
            int r3 = solution.climbStairs3(n);
            assertEquals(r1, r2, "climbStairs2 与 climbStairs 不一致，n=" + n);
            assertEquals(r1, r3, "climbStairs3 与 climbStairs 不一致，n=" + n);
        }
    }
}
