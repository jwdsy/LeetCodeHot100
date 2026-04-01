package com.leetcode.k_二分查找;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T066 - P33 搜索旋转排序数组")
class T066_P033_搜索旋转排序数组Test {

    private T066_P033_搜索旋转排序数组 solution;

    @BeforeEach
    void setUp() {
        solution = new T066_P033_搜索旋转排序数组();
    }

    @Test
    @DisplayName("示例1：目标存在")
    void testTargetExists() {
        assertEquals(4, solution.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    @Test
    @DisplayName("示例2：目标不存在")
    void testTargetNotExists() {
        assertEquals(-1, solution.search(new int[]{4,5,6,7,0,1,2}, 3));
    }

    @Test
    @DisplayName("单元素，命中")
    void testSingleElementFound() {
        assertEquals(0, solution.search(new int[]{1}, 1));
    }

    @Test
    @DisplayName("单元素，未命中")
    void testSingleElementNotFound() {
        assertEquals(-1, solution.search(new int[]{1}, 0));
    }

    @Test
    @DisplayName("数组未旋转，目标存在")
    void testNotRotated() {
        assertEquals(2, solution.search(new int[]{1,2,3,4,5}, 3));
    }

    @Test
    @DisplayName("目标在旋转点之前")
    void testBeforePivot() {
        assertEquals(1, solution.search(new int[]{3,4,5,1,2}, 4));
    }

    @Test
    @DisplayName("目标在旋转点之后")
    void testAfterPivot() {
        assertEquals(4, solution.search(new int[]{3,4,5,1,2}, 2));
    }

    @Test
    @DisplayName("目标是最小值（旋转点）")
    void testTargetIsPivot() {
        assertEquals(3, solution.search(new int[]{4,5,6,1,2,3}, 1));
    }

    @Test
    @DisplayName("目标是最大值")
    void testTargetIsMax() {
        assertEquals(2, solution.search(new int[]{4,5,6,1,2,3}, 6));
    }
}
