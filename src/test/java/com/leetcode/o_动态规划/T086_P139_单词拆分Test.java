package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T086 - P139 单词拆分")
class T086_P139_单词拆分Test {

    private T086_P139_单词拆分 solution;

    @BeforeEach
    void setUp() {
        solution = new T086_P139_单词拆分();
    }

    @Test
    @DisplayName("示例1：s=leetcode，可以拆分")
    void testExample1() {
        assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet","code")));
    }

    @Test
    @DisplayName("示例2：s=applepenapple，可以拆分（复用单词）")
    void testExample2() {
        assertTrue(solution.wordBreak("applepenapple", Arrays.asList("apple","pen")));
    }

    @Test
    @DisplayName("示例3：s=catsandog，无法拆分")
    void testExample3() {
        assertFalse(solution.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    @Test
    @DisplayName("单词恰好等于字典中的单词")
    void testExactMatch() {
        assertTrue(solution.wordBreak("hello", Arrays.asList("hello")));
    }

    @Test
    @DisplayName("字典中没有匹配的单词")
    void testNoMatch() {
        assertFalse(solution.wordBreak("abc", Arrays.asList("def","ghi")));
    }

    @Test
    @DisplayName("可以重复使用同一个单词")
    void testReuseWord() {
        assertTrue(solution.wordBreak("aaaaaa", Arrays.asList("a","aa","aaa")));
    }

    @Test
    @DisplayName("字典中有多余单词，但仍可拆分")
    void testExtraWordsInDict() {
        assertTrue(solution.wordBreak("cars", Arrays.asList("car","ca","rs","s","extra")));
    }
}
