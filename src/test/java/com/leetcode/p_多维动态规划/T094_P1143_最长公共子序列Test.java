package com.leetcode.p_多维动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T094 - P1143 最长公共子序列")
class T094_P1143_最长公共子序列Test {

    private T094_P1143_最长公共子序列 solution;

    @BeforeEach
    void setUp() {
        solution = new T094_P1143_最长公共子序列();
    }

    @Test
    @DisplayName("示例1：\"abcde\"和\"ace\"，LCS长度为3")
    void testExample1() {
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    @DisplayName("示例2：\"abc\"和\"abc\"，完全相同，LCS长度为3")
    void testSameStrings() {
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
    }

    @Test
    @DisplayName("示例3：\"abc\"和\"def\"，无公共子序列，返回0")
    void testNoCommon() {
        assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
    }

    @Test
    @DisplayName("一个字符串为空，返回0")
    void testOneEmpty() {
        assertEquals(0, solution.longestCommonSubsequence("", "abc"));
        assertEquals(0, solution.longestCommonSubsequence("abc", ""));
    }

    @Test
    @DisplayName("一个字符串是另一个的子序列")
    void testSubsequence() {
        assertEquals(3, solution.longestCommonSubsequence("abcdef", "bdf"));
    }

    @Test
    @DisplayName("交叉公共子序列")
    void testInterleaved() {
        // "abcba" 和 "abcbca" → LCS = "abcba" 长度5
        assertEquals(5, solution.longestCommonSubsequence("abcba", "abcbca"));
    }

    @Test
    @DisplayName("单字符，相同则1，不同则0")
    void testSingleChar() {
        assertEquals(1, solution.longestCommonSubsequence("a", "a"));
        assertEquals(0, solution.longestCommonSubsequence("a", "b"));
    }
}
