package com.leetcode.f_矩阵;

import java.util.*;

/**
 * LeetCode #54 - 螺旋矩阵 难度: 中等
 *
 * <p>题目描述: 给定一个 m 行 n 列的矩阵，按照顺时针螺旋顺序返回矩阵中的所有元素。
 *
 * <p>示例: 示例 1: 输入: matrix = [[1,2,3],[4,5,6],[7,8,9]], 输出: [1,2,3,6,9,8,7,4,5] 示例 2: 输入: matrix =
 * [[1,2,3,4],[5,6,7,8],[9,10,11,12]], 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * <p>解题思路: 按层模拟 1. 定义四个边界：上、下、左、右 2. 按顺时针遍历：右→下→左→上 3. 每层遍历完后边界收缩 时间复杂度: O(mn)，空间复杂度: O(1)
 */
public class T019_P054_螺旋矩阵 {

    public static void main(String[] args) {
        T019_P054_螺旋矩阵 solution = new T019_P054_螺旋矩阵();

        // 测试示例: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println("输入: matrix = [[1,2,3],[4,5,6],[7,8,9]]");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法：按层遍历四条边（时间 O(mn)，空间 O(1)）
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int top = 0;
        int bottom = rowCount - 1;
        int left = 0;
        int right = colCount - 1;

        while (top <= bottom && left <= right) {
            // 从左到右
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // 从上到下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 从右到左
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 从下到上
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;

    }
}
