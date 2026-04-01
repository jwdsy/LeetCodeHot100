package com.leetcode.d_子串;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T012 - LeetCode #76 最小覆盖子串")
class T012_P076_最小覆盖子串Test {

    private T012_P076_最小覆盖子串 solution;

    @BeforeEach
    void setUp() {
        solution = new T012_P076_最小覆盖子串();
    }

    @Test
    @DisplayName("示例1: s=\"ADOBECODEBANC\", t=\"ABC\" → \"BANC\"")
    void testExample1() {
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    @DisplayName("示例2: s=\"a\", t=\"a\" → \"a\"")
    void testSingleCharMatch() {
        assertEquals("a", solution.minWindow("a", "a"));
    }

    @Test
    @DisplayName("示例3: s=\"a\", t=\"aa\" → \"\"（t比s长）")
    void testTooShort() {
        assertEquals("", solution.minWindow("a", "aa"));
    }

    @Test
    @DisplayName("s不包含t中字符 → \"\"")
    void testNoMatch() {
        assertEquals("", solution.minWindow("abc", "xyz"));
    }

    @Test
    @DisplayName("s与t相等 → s本身")
    void testSEqual() {
        assertEquals("abc", solution.minWindow("abc", "abc"));
    }

    @Test
    @DisplayName("t有重复字符: s=\"aa\", t=\"aa\" → \"aa\"")
    void testTWithDuplicates() {
        assertEquals("aa", solution.minWindow("aa", "aa"));
    }

    @Test
    @DisplayName("最小子串在开头: s=\"ABCDEF\", t=\"AB\" → \"AB\"")
    void testMinWindowAtStart() {
        assertEquals("AB", solution.minWindow("ABCDEF", "AB"));
    }

    @Test
    @DisplayName("最小子串在末尾: s=\"DEFABC\", t=\"ABC\" → \"ABC\"")
    void testMinWindowAtEnd() {
        assertEquals("ABC", solution.minWindow("DEFABC", "ABC"));
    }
}
