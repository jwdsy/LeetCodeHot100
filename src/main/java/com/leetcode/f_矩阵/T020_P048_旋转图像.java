package com.leetcode.f_矩阵;

import java.util.*;

/**
 * LeetCode #48 - 旋转图像 难度: 中等
 *
 * <p>题目描述: 给定一个 n × n 的二维矩阵，将图像顺时针旋转 90 度。
 *
 * <p>示例: 示例 1: 输入: matrix = [[1,2,3],[4,5,6],[7,8,9]], 输出: [[7,4,1],[8,5,2],[9,6,3]] 示例 2: 输入:
 * matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]], 输出:
 * [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * <p>解题思路: 转置 + 镜像翻转 1. 先转置矩阵（行列互换） 2. 再对每一行进行反转 时间复杂度: O(n²)，空间复杂度: O(1)
 */
public class T020_P048_旋转图像 {

    public static void main(String[] args) {
        T020_P048_旋转图像 solution = new T020_P048_旋转图像();

        // 测试示例: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        System.out.println("输入: matrix = [[1,2,3],[4,5,6],[7,8,9]]");
        System.out.println("输出: " + Arrays.deepToString(matrix));
    }

    // 解题代码
    // 解法：主对角线转置 + 每行反转（时间 O(n^2)，空间 O(1)）
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) return;

        int size = matrix.length;

        // 转置矩阵
        for (int row = 0; row < size; row++) {
            for (int col = row + 1; col < size; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // 每行反转
        for (int row = 0; row < size; row++) {
            int left = 0;
            int right = size - 1;
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }

    }
}
