package com.leetcode.b_双指针;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LeetCode #283 - 移动零 单元测试
 */
@DisplayName("LeetCode #283 - 移动零")
class T004_P283_移动零Test {

    private T004_P283_移动零 solution;

    @BeforeEach
    void setUp() {
        solution = new T004_P283_移动零();
    }

    @Test
    @DisplayName("示例1: [0,1,0,3,12] → [1,3,12,0,0]")
    void testExample1() {
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    @DisplayName("示例2: [0] → [0]")
    void testSingleZero() {
        int[] nums = {0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    @DisplayName("无零元素: [1,2,3] → [1,2,3]")
    void testNoZeros() {
        int[] nums = {1, 2, 3};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    @DisplayName("全是零: [0,0,0] → [0,0,0]")
    void testAllZeros() {
        int[] nums = {0, 0, 0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{0, 0, 0}, nums);
    }

    @Test
    @DisplayName("零在末尾: [1,2,3,0,0] → [1,2,3,0,0]")
    void testZerosAtEnd() {
        int[] nums = {1, 2, 3, 0, 0};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, nums);
    }

    @Test
    @DisplayName("零在开头: [0,0,1,2,3] → [1,2,3,0,0]")
    void testZerosAtBeginning() {
        int[] nums = {0, 0, 1, 2, 3};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, nums);
    }

    @Test
    @DisplayName("非零元素相对顺序不变: [3,0,1,0,2] → [3,1,2,0,0]")
    void testRelativeOrderPreserved() {
        int[] nums = {3, 0, 1, 0, 2};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{3, 1, 2, 0, 0}, nums);
    }

    @Test
    @DisplayName("包含负数: [-1,0,-2,0,3] → [-1,-2,3,0,0]")
    void testWithNegatives() {
        int[] nums = {-1, 0, -2, 0, 3};
        solution.moveZeroes(nums);
        assertArrayEquals(new int[]{-1, -2, 3, 0, 0}, nums);
    }

    @Test
    @DisplayName("原地修改验证: 数组引用不变")
    void testInPlace() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] original = nums; // 同一引用
        solution.moveZeroes(nums);
        assertSame(original, nums, "moveZeroes 应原地修改数组，不返回新数组");
    }
}
