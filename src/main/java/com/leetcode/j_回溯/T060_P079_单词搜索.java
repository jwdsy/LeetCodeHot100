package com.leetcode.j_回溯;

/**
 * LeetCode #79 - 单词搜索 难度: 中等
 *
 * <p>题目描述: 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中"相邻"单元格是那些水平相邻或垂直相邻的单元格。 同一个单元格内的字母不允许被重复使用。
 *
 * <p>解题思路: 使用回溯 + DFS。从每个单元格出发尝试匹配单词， 使用 visited 数组记录已访问位置。
 *
 * <p>时间复杂度: O(m * n * 4^k) - m*n个起点，每个位置最多4个方向，k为单词长度 空间复杂度: O(m * n) - visited 数组和递归栈
 */
public class T060_P079_单词搜索 {

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null) return false;

    int m = board.length, n = board[0].length;
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dfs(board, word, i, j, 0, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
    if (index == word.length()) return true;
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
    if (visited[i][j] || board[i][j] != word.charAt(index)) return false;

    visited[i][j] = true;
    boolean found =
        dfs(board, word, i + 1, j, index + 1, visited)
            || dfs(board, word, i - 1, j, index + 1, visited)
            || dfs(board, word, i, j + 1, index + 1, visited)
            || dfs(board, word, i, j - 1, index + 1, visited);
    visited[i][j] = false;

    return found;
  }

  public static void main(String[] args) {
    T060_P079_单词搜索 solution = new T060_P079_单词搜索();

    // 测试用例
    char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    boolean result1 = solution.exist(board1, "ABCCED");
    System.out.println("测试1: " + result1 + " (期望: true)");

    boolean result2 = solution.exist(board1, "SEE");
    System.out.println("测试2: " + result2 + " (期望: true)");

    boolean result3 = solution.exist(board1, "ABCB");
    System.out.println("测试3: " + result3 + " (期望: false)");
  }
}
