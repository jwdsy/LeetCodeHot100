package com.leetcode.n_贪心算法;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T079 - P45 跳跃游戏 II")
class T079_P045_跳跃游戏IITest {

    private T079_P045_跳跃游戏 solution;

    @BeforeEach
    void setUp() {
        solution = new T079_P045_跳跃游戏();
    }

    @Test
    @DisplayName("示例1：[2,3,1,1,4]，最少2步")
    void testExample1() {
        assertEquals(2, solution.jump(new int[]{2,3,1,1,4}));
    }

    @Test
    @DisplayName("示例2：[2,3,0,1,4]，最少2步")
    void testExample2() {
        assertEquals(2, solution.jump(new int[]{2,3,0,1,4}));
    }

    @Test
    @DisplayName("单元素，0步")
    void testSingleElement() {
        assertEquals(0, solution.jump(new int[]{0}));
    }

    @Test
    @DisplayName("两元素，1步")
    void testTwoElements() {
        assertEquals(1, solution.jump(new int[]{1,1}));
    }

    @Test
    @DisplayName("每步只能走1格")
    void testOneStepEach() {
        assertEquals(4, solution.jump(new int[]{1,1,1,1,1}));
    }

    @Test
    @DisplayName("第一步可以直接到终点")
    void testFirstStepToEnd() {
        assertEquals(1, solution.jump(new int[]{5,1,2,3,4}));
    }

    @Test
    @DisplayName("需要3步")
    void testThreeSteps() {
        assertEquals(3, solution.jump(new int[]{1,1,1,1}));
    }
}
