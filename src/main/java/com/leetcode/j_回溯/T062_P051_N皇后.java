package com.leetcode.j_回溯;

import java.util.*;

/**
 * LeetCode #51 - N皇后 难度: 困难
 *
 * <p>题目描述: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 返回所有不同的 n 皇后问题的解决方案。
 *
 * <p>解题思路: 使用回溯算法。按行放置皇后，用三个集合分别记录： - cols: 已放置皇后的列 - diag1: 主对角线 (row - col 固定) - diag2: 副对角线 (row
 * + col 固定)
 *
 * <p>时间复杂度: O(n!) - 第一个位置 n 种，第二个最多 n-1 种，以此类推 空间复杂度: O(n) - 递归深度和棋盘
 */
public class T062_P051_N皇后 {

  List<List<String>> result = new ArrayList<>();
  Set<Integer> cols = new HashSet<>();
  Set<Integer> diag1 = new HashSet<>(); // row - col
  Set<Integer> diag2 = new HashSet<>(); // row + col

  public List<List<String>> solveNQueens(int n) {
    result.clear();
    cols.clear();
    diag1.clear();
    diag2.clear();

    char[][] board = new char[n][n];
    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    backtrack(n, 0, board);
    return result;
  }

  private void backtrack(int n, int row, char[][] board) {
    if (row == n) {
      List<String> solution = new ArrayList<>();
      for (char[] rowChars : board) {
        solution.add(new String(rowChars));
      }
      result.add(solution);
      return;
    }

    for (int col = 0; col < n; col++) {
      int d1 = row - col;
      int d2 = row + col;

      if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) {
        continue;
      }

      board[row][col] = 'Q';
      cols.add(col);
      diag1.add(d1);
      diag2.add(d2);

      backtrack(n, row + 1, board);

      board[row][col] = '.';
      cols.remove(col);
      diag1.remove(d1);
      diag2.remove(d2);
    }
  }

  public static void main(String[] args) {
    T062_P051_N皇后 solution = new T062_P051_N皇后();

    // 测试用例
    List<List<String>> result1 = solution.solveNQueens(4);
    System.out.println("测试1: " + result1.size() + " 种解法 (期望: 2)");

    List<List<String>> result2 = solution.solveNQueens(1);
    System.out.println("测试2: " + result2.size() + " 种解法 (期望: 1)");
  }
}
