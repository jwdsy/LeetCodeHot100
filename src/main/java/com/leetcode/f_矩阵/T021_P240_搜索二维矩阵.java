package com.leetcode.f_矩阵;

/**
 * LeetCode #240 - 搜索二维矩阵 II 难度: 中等
 *
 * <p>题目描述: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
 *
 * <p>解题思路: 从右上角开始搜索，比目标大向左移动，比目标小向下移动。时间复杂度 O(m+n)
 *
 * <p>时间复杂度: O(m+n) 空间复杂度: O(1)
 */
public class T021_P240_搜索二维矩阵 {

    public static void main(String[] args) {
        T021_P240_搜索二维矩阵 solution = new T021_P240_搜索二维矩阵();

        // 测试用例1
        int[][] matrix1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println("测试1: 搜索5, 结果=" + solution.searchMatrix(matrix1, 5)); // true

        // 测试用例2
        System.out.println("测试2: 搜索20, 结果=" + solution.searchMatrix(matrix1, 20)); // false

        // 测试用例3
        int[][] matrix2 = {{1, 4}, {2, 5}};
        System.out.println("测试3: 搜索2, 结果=" + solution.searchMatrix(matrix2, 2)); // true
    }

    /**
     * 从右上角开始搜索
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 是否存在
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int current = matrix[row][col];
            if (current == target) {
                return true;
            } else if (current > target) {
                // 向左移动
                col--;
            } else {
                // 向下移动
                row++;
            }
        }

        return false;
    }
}
