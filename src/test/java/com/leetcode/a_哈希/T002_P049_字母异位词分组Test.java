package com.leetcode.a_哈希;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LeetCode #49 - 字母异位词分组 单元测试
 */
@DisplayName("LeetCode #49 - 字母异位词分组")
class T002_P049_字母异位词分组Test {

    private T002_P049_字母异位词分组 solution;

    @BeforeEach
    void setUp() {
        solution = new T002_P049_字母异位词分组();
    }

    /** 辅助方法：将结果规范化后比较（忽略组内顺序和组间顺序）*/
    private List<List<String>> normalize(List<List<String>> groups) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups) {
            List<String> sorted = new ArrayList<>(group);
            Collections.sort(sorted);
            result.add(sorted);
        }
        result.sort(Comparator.comparing(g -> g.get(0)));
        return result;
    }

    @Test
    @DisplayName("示例1: [eat,tea,tan,ate,nat,bat] → 3组")
    void testExample1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(3, result.size());

        // 规范化后验证内容
        List<List<String>> normalized = normalize(result);
        assertTrue(normalized.contains(Arrays.asList("ate", "eat", "tea")));
        assertTrue(normalized.contains(Arrays.asList("nat", "tan")));
        assertTrue(normalized.contains(Collections.singletonList("bat")));
    }

    @Test
    @DisplayName("单个空字符串")
    void testEmptyString() {
        String[] strs = {""};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(Collections.singletonList(""), result.get(0));
    }

    @Test
    @DisplayName("单个字母")
    void testSingleChar() {
        String[] strs = {"a"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("所有字符串都是异位词")
    void testAllSameGroup() {
        String[] strs = {"abc", "bca", "cab", "acb"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(4, result.get(0).size());
    }

    @Test
    @DisplayName("所有字符串各不相同组")
    void testAllDifferentGroups() {
        String[] strs = {"abc", "def", "ghi"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(3, result.size());
        for (List<String> group : result) {
            assertEquals(1, group.size());
        }
    }

    @Test
    @DisplayName("包含重复字符的异位词: [aab, aba, baa]")
    void testDuplicateChars() {
        String[] strs = {"aab", "aba", "baa"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).size());
    }
}
