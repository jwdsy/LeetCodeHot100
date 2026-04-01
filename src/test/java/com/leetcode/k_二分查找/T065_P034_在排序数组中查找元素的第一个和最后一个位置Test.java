package com.leetcode.k_二分查找;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T065 - P34 在排序数组中查找元素的第一个和最后一个位置")
class T065_P034_在排序数组中查找元素的第一个和最后一个位置Test {

    private T065_P034_在排序数组中查找元素的第一个和最后一个位置 solution;

    @BeforeEach
    void setUp() {
        solution = new T065_P034_在排序数组中查找元素的第一个和最后一个位置();
    }

    @Test
    @DisplayName("示例1：目标存在，有范围")
    void testTargetExists() {
        assertArrayEquals(new int[]{3,4}, solution.searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

    @Test
    @DisplayName("示例2：目标不存在，返回[-1,-1]")
    void testTargetNotExists() {
        assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{5,7,7,8,8,10}, 6));
    }

    @Test
    @DisplayName("空数组，返回[-1,-1]")
    void testEmptyArray() {
        assertArrayEquals(new int[]{-1,-1}, solution.searchRange(new int[]{}, 0));
    }

    @Test
    @DisplayName("目标只出现一次")
    void testSingleOccurrence() {
        assertArrayEquals(new int[]{2,2}, solution.searchRange(new int[]{1,2,3,4,5}, 3));
    }

    @Test
    @DisplayName("整个数组都是目标")
    void testAllSame() {
        assertArrayEquals(new int[]{0,4}, solution.searchRange(new int[]{5,5,5,5,5}, 5));
    }

    @Test
    @DisplayName("目标在数组开头")
    void testTargetAtStart() {
        assertArrayEquals(new int[]{0,1}, solution.searchRange(new int[]{2,2,3,5}, 2));
    }

    @Test
    @DisplayName("目标在数组结尾")
    void testTargetAtEnd() {
        assertArrayEquals(new int[]{2,3}, solution.searchRange(new int[]{1,3,5,5}, 5));
    }

    @Test
    @DisplayName("单元素数组，命中")
    void testSingleElementHit() {
        assertArrayEquals(new int[]{0,0}, solution.searchRange(new int[]{1}, 1));
    }
}
