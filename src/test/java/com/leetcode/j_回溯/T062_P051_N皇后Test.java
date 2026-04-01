package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T062 - P51 N皇后")
class T062_P051_N皇后Test {

    private T062_P051_N皇后 solution;

    /** 验证皇后摆放是否合法：无同行/同列/同对角线冲突 */
    private boolean isValidSolution(List<String> board) {
        int n = board.size();
        // 每行恰好一个皇后
        for (String row : board) {
            if (row.chars().filter(c -> c == 'Q').count() != 1) return false;
        }
        // 检查列和对角线
        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = board.get(i).indexOf('Q');
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (queens[i] == queens[j]) return false;
                if (Math.abs(queens[i] - queens[j]) == j - i) return false;
            }
        }
        return true;
    }

    @BeforeEach
    void setUp() {
        solution = new T062_P051_N皇后();
    }

    @Test
    @DisplayName("n=4：2种合法方案")
    void testN4() {
        List<List<String>> result = solution.solveNQueens(4);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("n=1：1种方案")
    void testN1() {
        List<List<String>> result = solution.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals("Q", result.get(0).get(0));
    }

    @Test
    @DisplayName("所有方案都合法（无冲突）")
    void testAllSolutionsValid() {
        List<List<String>> result = solution.solveNQueens(4);
        for (List<String> board : result) {
            assertTrue(isValidSolution(board), "存在非法摆放: " + board);
        }
    }

    @Test
    @DisplayName("每个方案棋盘大小正确（n×n）")
    void testBoardSize() {
        int n = 5;
        List<List<String>> result = solution.solveNQueens(n);
        for (List<String> board : result) {
            assertEquals(n, board.size());
            for (String row : board) {
                assertEquals(n, row.length());
            }
        }
    }

    @Test
    @DisplayName("n=5：10种方案")
    void testN5() {
        List<List<String>> result = solution.solveNQueens(5);
        assertEquals(10, result.size());
    }

    @Test
    @DisplayName("n=8：92种方案")
    void testN8() {
        List<List<String>> result = solution.solveNQueens(8);
        assertEquals(92, result.size());
    }
}
