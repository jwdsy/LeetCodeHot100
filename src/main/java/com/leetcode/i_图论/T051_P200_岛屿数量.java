package com.leetcode.i_图论;

import java.util.*;

/**
 * LeetCode #200 - 岛屿数量 难度: 中等
 *
 * <p>题目描述: 给你一个由 '1'（陆地）和 '0'（水）组成的二维网格，计算岛屿的数量。
 *
 * <p>示例: 示例 1: 输入: grid = [["1","1","1"],["0","1","0"],["1","1","1"]], 输出: 1
 *
 * <p>解题思路: DFS/BFS：遍历grid，感染已访问的岛屿 时间复杂度: O(mn)，空间复杂度: O(mn)
 */
public class T051_P200_岛屿数量 {

    public static void main(String[] args) {
        T051_P200_岛屿数量 solution = new T051_P200_岛屿数量();

        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        int result = solution.numIslands(grid);
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法：DFS 感染（时间 O(mn)，空间 O(mn)）
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int islandCount = 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    // 从当前陆地出发，把整块连通陆地都标记为已访问
                    dfs(grid, row, col);
                }
            }
        }
        return islandCount;

    }

    private void dfs(char[][] grid, int row, int col) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount || grid[row][col] != '1') return;

        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
