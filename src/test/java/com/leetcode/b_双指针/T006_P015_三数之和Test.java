package com.leetcode.b_双指针;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T006 - LeetCode #15 三数之和")
class T006_P015_三数之和Test {

    private T006_P015_三数之和 solution;

    @BeforeEach
    void setUp() {
        solution = new T006_P015_三数之和();
    }

    /** 将结果规范化，便于无序比较 */
    private List<List<Integer>> normalize(List<List<Integer>> result) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> triplet : result) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            copy.add(sorted);
        }
        copy.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        return copy;
    }

    @Test
    @DisplayName("示例1: [-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]")
    void testExample1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        assertEquals(normalize(expected), normalize(result));
    }

    @Test
    @DisplayName("示例2: [0,0,0] → [[0,0,0]]")
    void testAllZeros() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = solution.threeSum(nums);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0));
        assertEquals(normalize(expected), normalize(result));
    }

    @Test
    @DisplayName("无满足条件的三元组: [1,2,3] → []")
    void testNoResult() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("所有元素相同且非零: [1,1,1] → []")
    void testAllSameNonZero() {
        int[] nums = {1, 1, 1};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("包含重复元素: [-2,0,0,2,2] → [[-2,0,2]]")
    void testWithDuplicates() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> result = solution.threeSum(nums);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-2, 0, 2));
        assertEquals(normalize(expected), normalize(result));
    }

    @Test
    @DisplayName("多组结果: [-4,-1,-1,0,1,2] → [[-1,-1,2],[-1,0,1]]")
    void testMultipleResults() {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("元素数量不足3个: [1,2] → []")
    void testTooFewElements() {
        int[] nums = {1, 2};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("全为负数: [-3,-2,-1] → []")
    void testAllNegative() {
        int[] nums = {-3, -2, -1};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }
}
