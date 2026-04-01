package com.leetcode.a_哈希;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LeetCode #128 - 最长连续序列 单元测试
 */
@DisplayName("LeetCode #128 - 最长连续序列")
class T003_P128_最长连续序列Test {

    private T003_P128_最长连续序列 solution;

    @BeforeEach
    void setUp() {
        solution = new T003_P128_最长连续序列();
    }

    @Test
    @DisplayName("示例1: [100,4,200,1,3,2] → 4")
    void testExample1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assertEquals(4, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("示例2: [0,3,7,2,5,8,4,6,0,1] → 9")
    void testExample2() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertEquals(9, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("空数组 → 0")
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(0, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("单元素数组 → 1")
    void testSingleElement() {
        int[] nums = {5};
        assertEquals(1, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("全部重复元素 [1,1,1,1] → 1")
    void testAllDuplicates() {
        int[] nums = {1, 1, 1, 1};
        assertEquals(1, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("已排序连续序列 [1,2,3,4,5] → 5")
    void testSortedConsecutive() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(5, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("逆序连续序列 [5,4,3,2,1] → 5")
    void testReverseSorted() {
        int[] nums = {5, 4, 3, 2, 1};
        assertEquals(5, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("包含负数: [-5,-4,-3,0,1,2,3] → 4 (0到3)")
    void testWithNegativeNumbers() {
        int[] nums = {-5, -4, -3, 0, 1, 2, 3};
        // 序列：-5,-4,-3 (长度3) 和 0,1,2,3 (长度4)
        assertEquals(4, solution.longestConsecutive(nums));
    }

    @Test
    @DisplayName("无连续序列: [1,3,5,7] → 1")
    void testNoConsecutive() {
        int[] nums = {1, 3, 5, 7};
        assertEquals(1, solution.longestConsecutive(nums));
    }
}
