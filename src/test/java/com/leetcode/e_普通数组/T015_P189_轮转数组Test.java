package com.leetcode.e_普通数组;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T015 - LeetCode #189 轮转数组")
class T015_P189_轮转数组Test {

    private T015_P189_轮转数组 solution;

    @BeforeEach
    void setUp() {
        solution = new T015_P189_轮转数组();
    }

    @Test
    @DisplayName("示例1: [1,2,3,4,5,6,7], k=3 → [5,6,7,1,2,3,4]")
    void testExample1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    @DisplayName("示例2: [-1,-100,3,99], k=2 → [3,99,-1,-100]")
    void testExample2() {
        int[] nums = {-1, -100, 3, 99};
        solution.rotate(nums, 2);
        assertArrayEquals(new int[]{3, 99, -1, -100}, nums);
    }

    @Test
    @DisplayName("k=0 → 数组不变")
    void testKEqualsZero() {
        int[] nums = {1, 2, 3, 4};
        solution.rotate(nums, 0);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    @DisplayName("k等于数组长度 → 数组不变")
    void testKEqualsLength() {
        int[] nums = {1, 2, 3, 4};
        solution.rotate(nums, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    @DisplayName("k大于数组长度（取模）: [1,2,3], k=4 → [3,1,2]")
    void testKGreaterThanLength() {
        int[] nums = {1, 2, 3};
        solution.rotate(nums, 4);
        assertArrayEquals(new int[]{3, 1, 2}, nums);
    }

    @Test
    @DisplayName("单元素数组: [1], k=100 → [1]")
    void testSingleElement() {
        int[] nums = {1};
        solution.rotate(nums, 100);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    @DisplayName("k=1（右移一位）: [1,2,3,4,5] → [5,1,2,3,4]")
    void testKEqualsOne() {
        int[] nums = {1, 2, 3, 4, 5};
        solution.rotate(nums, 1);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, nums);
    }
}
