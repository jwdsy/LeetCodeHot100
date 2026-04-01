package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T059 - P22 括号生成")
class T059_P022_括号生成Test {

    private T059_P022_括号生成 solution;

    /** 验证括号字符串是否合法 */
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    @BeforeEach
    void setUp() {
        solution = new T059_P022_括号生成();
    }

    @Test
    @DisplayName("n=3：5种组合")
    void testN3() {
        List<String> result = solution.generateParenthesis(3);
        assertEquals(5, result.size());
    }

    @Test
    @DisplayName("n=1：只有一种组合 \"()\"")
    void testN1() {
        List<String> result = solution.generateParenthesis(1);
        assertEquals(1, result.size());
        assertEquals("()", result.get(0));
    }

    @Test
    @DisplayName("n=2：2种组合")
    void testN2() {
        List<String> result = solution.generateParenthesis(2);
        assertEquals(2, result.size());
        Set<String> expected = new HashSet<>(Arrays.asList("(())", "()()"));
        assertEquals(expected, new HashSet<>(result));
    }

    @Test
    @DisplayName("所有结果都是合法括号序列")
    void testAllValid() {
        List<String> result = solution.generateParenthesis(4);
        for (String s : result) {
            assertTrue(isValid(s), "无效括号序列: " + s);
        }
    }

    @Test
    @DisplayName("所有结果长度均等于 2n")
    void testCorrectLength() {
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        for (String s : result) {
            assertEquals(2 * n, s.length());
        }
    }

    @Test
    @DisplayName("结果无重复")
    void testNoDuplicates() {
        List<String> result = solution.generateParenthesis(4);
        assertEquals(result.size(), new HashSet<>(result).size());
    }

    @Test
    @DisplayName("n=4：14种组合（卡特兰数）")
    void testN4() {
        List<String> result = solution.generateParenthesis(4);
        assertEquals(14, result.size());
    }
}
