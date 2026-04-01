package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T056 - P78 子集")
class T056_P078_子集Test {

    private T056_P078_子集 solution;

    @BeforeEach
    void setUp() {
        solution = new T056_P078_子集();
    }

    @Test
    @DisplayName("示例：[1,2,3] 有8个子集")
    void testThreeElements() {
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 3});
        assertEquals(8, result.size());
    }

    @Test
    @DisplayName("包含空集")
    void testContainsEmptySet() {
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 3});
        assertTrue(result.contains(new ArrayList<>()));
    }

    @Test
    @DisplayName("包含全集")
    void testContainsFullSet() {
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 3});
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("单元素：2个子集（空集和自身）")
    void testSingleElement() {
        List<List<Integer>> result = solution.subsets(new int[]{0});
        assertEquals(2, result.size());
        assertTrue(result.contains(new ArrayList<>()));
        assertTrue(result.contains(Arrays.asList(0)));
    }

    @Test
    @DisplayName("[1,2] 有4个子集")
    void testTwoElements() {
        List<List<Integer>> result = solution.subsets(new int[]{1, 2});
        assertEquals(4, result.size());
    }

    @Test
    @DisplayName("结果中无重复子集")
    void testNoDuplicates() {
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 3});
        Set<List<Integer>> unique = new HashSet<>(result);
        assertEquals(result.size(), unique.size());
    }
}
