package com.leetcode.n_贪心算法;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T078 - P55 跳跃游戏")
class T078_P055_跳跃游戏Test {

    private T078_P055_跳跃游戏 solution;

    @BeforeEach
    void setUp() {
        solution = new T078_P055_跳跃游戏();
    }

    @Test
    @DisplayName("示例1：[2,3,1,1,4]，可以到达终点")
    void testCanJump() {
        assertTrue(solution.canJump(new int[]{2,3,1,1,4}));
    }

    @Test
    @DisplayName("示例2：[3,2,1,0,4]，不能到达终点")
    void testCannotJump() {
        assertFalse(solution.canJump(new int[]{3,2,1,0,4}));
    }

    @Test
    @DisplayName("单元素，已在终点")
    void testSingleElement() {
        assertTrue(solution.canJump(new int[]{0}));
    }

    @Test
    @DisplayName("第一步就为0（且不是终点）")
    void testFirstZero() {
        assertFalse(solution.canJump(new int[]{0,1}));
    }

    @Test
    @DisplayName("全是1，可以逐步到达")
    void testAllOnes() {
        assertTrue(solution.canJump(new int[]{1,1,1,1}));
    }

    @Test
    @DisplayName("最后两个为0，无法到达最后一个")
    void testLastZero() {
        // [2,1,0,0]: cover最多到达index=2，无法到达index=3
        assertFalse(solution.canJump(new int[]{2,1,0,0}));
    }

    @Test
    @DisplayName("大步跳过障碍")
    void testBigJump() {
        assertTrue(solution.canJump(new int[]{5,0,0,0,0}));
    }

    @Test
    @DisplayName("中间有0但仍可绕过")
    void testZeroInMiddle() {
        assertTrue(solution.canJump(new int[]{2,0,2,0,1}));
    }
}
