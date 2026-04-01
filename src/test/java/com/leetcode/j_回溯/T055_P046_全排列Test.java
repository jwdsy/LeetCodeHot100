package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T055 - P46 全排列")
class T055_P046_全排列Test {

    private T055_P046_全排列 solution;

    /** 规范化：对每个排列排序后再整体排序，便于无序比较 */
    private List<List<Integer>> normalize(List<List<Integer>> result) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> perm : result) {
            List<Integer> sorted = new ArrayList<>(perm);
            copy.add(sorted);
        }
        copy.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) return a.get(i) - b.get(i);
            }
            return a.size() - b.size();
        });
        return copy;
    }

    @BeforeEach
    void setUp() {
        solution = new T055_P046_全排列();
    }

    @Test
    @DisplayName("示例：[1,2,3] 有6种排列")
    void testThreeElements() {
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        assertEquals(6, result.size());
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1,2,3), Arrays.asList(1,3,2),
            Arrays.asList(2,1,3), Arrays.asList(2,3,1),
            Arrays.asList(3,1,2), Arrays.asList(3,2,1)
        );
        assertEquals(normalize(expected), normalize(result));
    }

    @Test
    @DisplayName("单元素数组：只有一种排列")
    void testSingleElement() {
        List<List<Integer>> result = solution.permute(new int[]{0});
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(0), result.get(0));
    }

    @Test
    @DisplayName("[0,1] 有两种排列")
    void testTwoElements() {
        List<List<Integer>> result = solution.permute(new int[]{0, 1});
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("结果中无重复排列")
    void testNoDuplicates() {
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        Set<List<Integer>> unique = new HashSet<>(result);
        assertEquals(result.size(), unique.size());
    }

    @Test
    @DisplayName("每个排列包含全部元素")
    void testAllElementsPresent() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        for (List<Integer> perm : result) {
            assertEquals(nums.length, perm.size());
            List<Integer> sorted = new ArrayList<>(perm);
            Collections.sort(sorted);
            assertEquals(Arrays.asList(1, 2, 3), sorted);
        }
    }
}
