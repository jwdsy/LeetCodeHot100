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
    // 解法：首行首列做标记（时间 O(mn)，空间 O(1)）
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 检查第一行和第一列是否有0
        for (int row = 0; row < rowCount; row++) {
            if (matrix[row][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int col = 0; col < colCount; col++) {
            if (matrix[0][col] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 用第一行和第一列标记其他位置
        for (int row = 1; row < rowCount; row++) {
            for (int col = 1; col < colCount; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // 根据标记置零（不包括第一行和第一列）
        for (int row = 1; row < rowCount; row++) {
            for (int col = 1; col < colCount; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // 处理第一行和第一列
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColZero) {
            for (int row = 0; row < rowCount; row++) {
                matrix[row][0] = 0;
            }
        }

    }
}
