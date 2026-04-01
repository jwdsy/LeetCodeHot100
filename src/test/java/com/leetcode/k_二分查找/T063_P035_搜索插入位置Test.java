package com.leetcode.k_二分查找;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T063 - P35 搜索插入位置")
class T063_P035_搜索插入位置Test {

    private T063_P035_搜索插入位置 solution;

    @BeforeEach
    void setUp() {
        solution = new T063_P035_搜索插入位置();
    }

    @Test
    @DisplayName("示例1：目标存在，返回索引")
    void testTargetExists() {
        assertEquals(2, solution.searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    @DisplayName("示例2：目标不存在，插入中间位置")
    void testInsertMiddle() {
        assertEquals(1, solution.searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    @DisplayName("示例3：目标不存在，插入尾部")
    void testInsertEnd() {
        assertEquals(4, solution.searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    @DisplayName("目标小于所有元素，插入头部")
    void testInsertHead() {
        assertEquals(0, solution.searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    @DisplayName("单元素数组，目标存在")
    void testSingleElementFound() {
        assertEquals(0, solution.searchInsert(new int[]{1}, 1));
    }

    @Test
    @DisplayName("单元素数组，目标不存在（插入后）")
    void testSingleElementInsertAfter() {
        assertEquals(1, solution.searchInsert(new int[]{1}, 2));
    }

    @Test
    @DisplayName("目标在数组第一个位置")
    void testTargetAtFirst() {
        assertEquals(0, solution.searchInsert(new int[]{1,3,5,6}, 1));
    }

    @Test
    @DisplayName("目标在数组最后一个位置")
    void testTargetAtLast() {
        assertEquals(3, solution.searchInsert(new int[]{1,3,5,6}, 6));
    }
}
