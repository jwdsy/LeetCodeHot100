package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T060 - P79 单词搜索")
class T060_P079_单词搜索Test {

    private T060_P079_单词搜索 solution;

    @BeforeEach
    void setUp() {
        solution = new T060_P079_单词搜索();
    }

    @Test
    @DisplayName("示例1：存在单词 ABCCED")
    void testExist() {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        assertTrue(solution.exist(board, "ABCCED"));
    }

    @Test
    @DisplayName("示例2：存在单词 SEE")
    void testExistSEE() {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        assertTrue(solution.exist(board, "SEE"));
    }

    @Test
    @DisplayName("示例3：不存在单词 ABCB（不可重用）")
    void testNotExist() {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        assertFalse(solution.exist(board, "ABCB"));
    }

    @Test
    @DisplayName("单个字符，存在")
    void testSingleCharFound() {
        char[][] board = {{'A'}};
        assertTrue(solution.exist(board, "A"));
    }

    @Test
    @DisplayName("单个字符，不存在")
    void testSingleCharNotFound() {
        char[][] board = {{'A'}};
        assertFalse(solution.exist(board, "B"));
    }

    @Test
    @DisplayName("单词长度超过棋盘格子数，不存在")
    void testWordTooLong() {
        char[][] board = {{'A','B'},{'C','D'}};
        assertFalse(solution.exist(board, "ABCDE"));
    }

    @Test
    @DisplayName("蛇形路径搜索")
    void testSnakePath() {
        char[][] board = {
            {'A','B','C'},
            {'D','E','F'},
            {'G','H','I'}
        };
        assertTrue(solution.exist(board, "ABCFIHGDE"));
    }

    @Test
    @DisplayName("相同字符需要用到不同位置")
    void testSameCharDifferentPosition() {
        char[][] board = {
            {'A','A','A'},
            {'A','A','A'}
        };
        assertTrue(solution.exist(board, "AAA"));
    }
}
