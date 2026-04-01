package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T057 - P17 电话号码的字母组合")
class T057_P017_电话号码的字母组合Test {

    private T057_P017_电话号码的字母组合 solution;

    @BeforeEach
    void setUp() {
        solution = new T057_P017_电话号码的字母组合();
    }

    @Test
    @DisplayName("示例：\"23\" 有9种组合")
    void testTwoDigits() {
        List<String> result = solution.letterCombinations("23");
        assertEquals(9, result.size());
        // 2->abc, 3->def
        List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        assertEquals(new HashSet<>(expected), new HashSet<>(result));
    }

    @Test
    @DisplayName("空字符串返回空列表")
    void testEmptyInput() {
        List<String> result = solution.letterCombinations("");
        assertTrue(result == null || result.isEmpty());
    }

    @Test
    @DisplayName("单个数字 \"2\"：3种组合")
    void testSingleDigit() {
        List<String> result = solution.letterCombinations("2");
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList("a","b","c")));
    }

    @Test
    @DisplayName("数字 \"9\" 对应 wxyz：4种组合")
    void testDigit9() {
        List<String> result = solution.letterCombinations("9");
        assertEquals(4, result.size());
        assertTrue(result.containsAll(Arrays.asList("w","x","y","z")));
    }

    @Test
    @DisplayName("三个数字：组合数正确")
    void testThreeDigits() {
        List<String> result = solution.letterCombinations("234");
        // 2->3, 3->3, 4->3 → 27种
        assertEquals(27, result.size());
    }

    @Test
    @DisplayName("结果中每个字符串长度等于输入数字个数")
    void testCombinationLength() {
        List<String> result = solution.letterCombinations("23");
        for (String s : result) {
            assertEquals(2, s.length());
        }
    }
}
