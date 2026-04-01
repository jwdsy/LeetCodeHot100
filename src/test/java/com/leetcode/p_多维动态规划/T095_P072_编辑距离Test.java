package com.leetcode.p_多维动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T095 - P72 编辑距离")
class T095_P072_编辑距离Test {

    private T095_P072_编辑距离 solution;

    @BeforeEach
    void setUp() {
        solution = new T095_P072_编辑距离();
    }

    @Test
    @DisplayName("示例1：\"horse\"→\"ros\"，编辑距离3")
    void testExample1() {
        assertEquals(3, solution.minDistance("horse", "ros"));
    }

    @Test
    @DisplayName("示例2：\"intention\"→\"execution\"，编辑距离5")
    void testExample2() {
        assertEquals(5, solution.minDistance("intention", "execution"));
    }

    @Test
    @DisplayName("两个空字符串，距离为0")
    void testBothEmpty() {
        assertEquals(0, solution.minDistance("", ""));
    }

    @Test
    @DisplayName("word1为空，距离等于word2长度（全插入）")
    void testWord1Empty() {
        assertEquals(3, solution.minDistance("", "abc"));
    }

    @Test
    @DisplayName("word2为空，距离等于word1长度（全删除）")
    void testWord2Empty() {
        assertEquals(4, solution.minDistance("abcd", ""));
    }

    @Test
    @DisplayName("相同字符串，距离为0")
    void testSameStrings() {
        assertEquals(0, solution.minDistance("abc", "abc"));
    }

    @Test
    @DisplayName("完全不同，距离等于较长字符串长度")
    void testCompletelyDifferent() {
        // "abc" → "xyz"：3次替换
        assertEquals(3, solution.minDistance("abc", "xyz"));
    }

    @Test
    @DisplayName("只差一个字符（末尾插入）")
    void testOneInsert() {
        assertEquals(1, solution.minDistance("abc", "abcd"));
    }

    @Test
    @DisplayName("只差一个字符（末尾删除）")
    void testOneDelete() {
        assertEquals(1, solution.minDistance("abcd", "abc"));
    }
}
