package com.leetcode.f_矩阵;

import java.util.*;

/**
 * LeetCode #73 - 矩阵置零 难度: 中等
 *
 * <p>题目描述: 给定一个 m x n 的矩阵，如果某个元素为 0，则将其所在行和列的所有元素都设为 0。
 *
 * <p>示例: 示例 1: 输入: matrix = [[1,1,1],[1,0,1],[1,1,1]], 输出: [[1,0,1],[0,0,0],[1,0,1]] 示例 2: 输入:
 * matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]], 输出: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * <p>解题思路: 使用第一行和第一列作为标记 1. 标记哪些行和列需要置零 2. 根据标记置零 时间复杂度: O(mn)，空间复杂度: O(1)
 */
public class T018_P073_矩阵置零 {

    public static void main(String[] args) {
        T018_P073_矩阵置零 solution = new T018_P073_矩阵置零();

        // 测试示例: matrix = [[1,1,1],[1,0,1],[1,1,1]]
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);
        System.out.println("输入: matrix = [[1,1,1],[1,0,1],[1,1,1]]");
        System.out.println("输出: " + Arrays.deepToString(matrix));
    }

    // 解题代码
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 检查第一行和第一列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 用第一行和第一列标记其他位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据标记置零（不包括第一行和第一列）
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行和第一列
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
