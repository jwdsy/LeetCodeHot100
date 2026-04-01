package com.leetcode.a_哈希;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LeetCode #1 - 两数之和 单元测试
 */
@DisplayName("LeetCode #1 - 两数之和")
class T001_P001_两数之和Test {

    private T001_P001_两数之和 solution;

    @BeforeEach
    void setUp() {
        solution = new T001_P001_两数之和();
    }

    @Test
    @DisplayName("示例1: nums=[2,7,11,15], target=9 → [0,1]")
    void testExample1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    @DisplayName("示例2: nums=[3,2,4], target=6 → [1,2]")
    void testExample2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    @DisplayName("示例3: nums=[3,3], target=6 → [0,1]")
    void testExample3() {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    @DisplayName("目标在数组首尾")
    void testFirstAndLast() {
        int[] nums = {1, 5, 3, 8, 2};
        int target = 3;  // nums[0] + nums[4] = 1 + 2 = 3
        int[] result = solution.twoSum(nums, target);
        // 结果应包含两个下标，且对应元素之和为 target
        assertEquals(2, result.length);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("负数情况: nums=[-1,-2,-3,-4,-5], target=-8 → [2,4]")
    void testNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;  // -3 + -5
        int[] result = solution.twoSum(nums, target);
        assertEquals(2, result.length);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    @DisplayName("包含零: nums=[0,4,3,0], target=0 → [0,3]")
    void testWithZero() {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 3}, result);
    }
}
