package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T058 - P39 组合总和")
class T058_P039_组合总和Test {

    private T058_P039_组合总和 solution;

    /** 规范化：对每个组合内部排序后整体排序，便于无序比较 */
    private List<List<Integer>> normalize(List<List<Integer>> result) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> combo : result) {
            List<Integer> sorted = new ArrayList<>(combo);
            Collections.sort(sorted);
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
        solution = new T058_P039_组合总和();
    }

    @Test
    @DisplayName("示例1：candidates=[2,3,6,7], target=7")
    void testExample1() {
        List<List<Integer>> result = solution.combinationSum(new int[]{2,3,6,7}, 7);
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(2,2,3), Arrays.asList(7)
        );
        assertEquals(normalize(expected), normalize(result));
    }

    @Test
    @DisplayName("示例2：candidates=[2,3,5], target=8")
    void testExample2() {
        List<List<Integer>> result = solution.combinationSum(new int[]{2,3,5}, 8);
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(2,2,2,2), Arrays.asList(2,3,3), Arrays.asList(3,5)
        );
        assertEquals(normalize(expected), normalize(result));
    }

    @Test
    @DisplayName("目标值不可达，返回空列表")
    void testNoSolution() {
        List<List<Integer>> result = solution.combinationSum(new int[]{5}, 3);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("候选数本身等于目标")
    void testDirectMatch() {
        List<List<Integer>> result = solution.combinationSum(new int[]{1,2,3}, 3);
        assertFalse(result.isEmpty());
        // 至少包含 [3] 和 [1,2] 和 [1,1,1]
        assertTrue(result.stream().anyMatch(c -> c.equals(Arrays.asList(3))));
    }

    @Test
    @DisplayName("无重复组合")
    void testNoDuplicates() {
        List<List<Integer>> result = solution.combinationSum(new int[]{2,3,6,7}, 7);
        Set<List<Integer>> unique = new HashSet<>();
        for (List<Integer> combo : result) {
            List<Integer> sorted = new ArrayList<>(combo);
            Collections.sort(sorted);
            unique.add(sorted);
        }
        assertEquals(result.size(), unique.size());
    }
}
