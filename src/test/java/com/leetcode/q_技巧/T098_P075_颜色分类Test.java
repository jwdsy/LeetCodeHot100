package com.leetcode.q_技巧;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T098 - P75 颜色分类")
class T098_P075_颜色分类Test {

    private T098_P075_颜色分类 solution;

    @BeforeEach
    void setUp() {
        solution = new T098_P075_颜色分类();
    }

    @Test
    @DisplayName("示例1：[2,0,2,1,1,0]，排序后[0,0,1,1,2,2]")
    void testExample1() {
        int[] nums = {2,0,2,1,1,0};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0,0,1,1,2,2}, nums);
    }

    @Test
    @DisplayName("示例2：[2,0,1]，排序后[0,1,2]")
    void testExample2() {
        int[] nums = {2,0,1};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0,1,2}, nums);
    }

    @Test
    @DisplayName("全是0")
    void testAllZero() {
        int[] nums = {0,0,0};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0,0,0}, nums);
    }

    @Test
    @DisplayName("全是1")
    void testAllOne() {
        int[] nums = {1,1,1};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{1,1,1}, nums);
    }

    @Test
    @DisplayName("全是2")
    void testAllTwo() {
        int[] nums = {2,2,2};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{2,2,2}, nums);
    }

    @Test
    @DisplayName("已排好序，不变")
    void testAlreadySorted() {
        int[] nums = {0,0,1,1,2,2};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{0,0,1,1,2,2}, nums);
    }

    @Test
    @DisplayName("单元素")
    void testSingleElement() {
        int[] nums = {1};
        solution.sortColors(nums);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    @DisplayName("原地修改（返回void）")
    void testInPlace() {
        int[] nums = {1,2,0};
        int[] original = nums;
        solution.sortColors(nums);
        assertSame(original, nums);
        assertArrayEquals(new int[]{0,1,2}, nums);
    }
}
