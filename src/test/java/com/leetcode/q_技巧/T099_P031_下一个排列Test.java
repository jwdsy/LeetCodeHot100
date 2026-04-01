package com.leetcode.q_技巧;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T099 - P31 下一个排列")
class T099_P031_下一个排列Test {

    private T099_P031_下一个排列 solution;

    @BeforeEach
    void setUp() {
        solution = new T099_P031_下一个排列();
    }

    @Test
    @DisplayName("示例1：[1,2,3]，下一个排列为[1,3,2]")
    void testExample1() {
        int[] nums = {1,2,3};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1,3,2}, nums);
    }

    @Test
    @DisplayName("示例2：[3,2,1]，最大排列，循环到[1,2,3]")
    void testDescending() {
        int[] nums = {3,2,1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1,2,3}, nums);
    }

    @Test
    @DisplayName("示例3：[1,1,5]，下一个排列为[1,5,1]")
    void testExample3() {
        int[] nums = {1,1,5};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1,5,1}, nums);
    }

    @Test
    @DisplayName("单元素，不变")
    void testSingleElement() {
        int[] nums = {1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    @DisplayName("[1,3,2]，下一个排列为[2,1,3]")
    void testExample4() {
        int[] nums = {1,3,2};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{2,1,3}, nums);
    }

    @Test
    @DisplayName("[2,3,1]，下一个排列为[3,1,2]")
    void testExample5() {
        int[] nums = {2,3,1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{3,1,2}, nums);
    }

    @Test
    @DisplayName("原地修改（返回void）")
    void testInPlace() {
        int[] nums = {1,2};
        int[] original = nums;
        solution.nextPermutation(nums);
        assertSame(original, nums);
    }
}
