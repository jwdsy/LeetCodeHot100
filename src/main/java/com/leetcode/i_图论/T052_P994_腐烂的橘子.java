package com.leetcode.i_图论;

import java.util.*;

/**
 * LeetCode #994 - 腐烂的橘子 难度: 中等
 *
 * <p>题目描述: 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一： - 0 代表空单元格 - 1 代表新鲜橘子 - 2 代表腐烂的橘子 每分钟，腐烂的橘子会使周围 4
 * 个方向上相邻的新鲜橘子腐烂。 返回直到所有新鲜橘子都腐烂所需的最少分钟数；如果不可能全部腐烂，返回 -1。
 *
 * <p>解题思路: 使用多源 BFS（广度优先搜索）。将所有腐烂橘子作为起始点同时入队， 按层遍历，每层代表一分钟的扩散过程。
 *
 * <p>时间复杂度: O(m*n) - 每个单元格最多被访问一次 空间复杂度: O(m*n) - 用于队列存储
 */
public class T052_P994_腐烂的橘子 {

  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int m = grid.length, n = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int fresh = 0;

    // 初始化：将所有腐烂橘子入队，统计新鲜橘子数量
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new int[] {i, j});
        } else if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }

    // 没有新鲜橘子，直接返回 0
    if (fresh == 0) return 0;

    int minutes = 0;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // BFS 按层遍历
    while (!queue.isEmpty() && fresh > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] rot = queue.poll();
        for (int[] dir : directions) {
          int x = rot[0] + dir[0];
          int y = rot[1] + dir[1];

          // 检查边界和是否为新鲜橘子
          if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
            grid[x][y] = 2; // 腐烂
            fresh--;
            queue.offer(new int[] {x, y});
          }
        }
      }
      minutes++;
    }

    return fresh == 0 ? minutes : -1;
  }

  public static void main(String[] args) {
    T052_P994_腐烂的橘子 solution = new T052_P994_腐烂的橘子();

    // 测试用例 1
    int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    int result1 = solution.orangesRotting(grid1);
    System.out.println("测试1: " + result1 + " (期望: 4)");

    // 测试用例 2
    int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    int result2 = solution.orangesRotting(grid2);
    System.out.println("测试2: " + result2 + " (期望: -1)");

    // 测试用例 3
    int[][] grid3 = {{0, 2}};
    int result3 = solution.orangesRotting(grid3);
    System.out.println("测试3: " + result3 + " (期望: 0)");
  }
}
