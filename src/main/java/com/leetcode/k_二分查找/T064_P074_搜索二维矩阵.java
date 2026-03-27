package com.leetcode.k_二分查找;

/**
 * LeetCode #74 - 搜索二维矩阵 难度: 中等
 *
 * <p>题目描述: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。 该矩阵具有以下特性： - 每行的元素从左到右升序排列 -
 * 每列的第一个元素大于上一列的最后一个元素
 *
 * <p>解题思路: 方法1：将二维数组当作一维数组进行二分查找 方法2：先确定行，再在行内二分 这里使用方法1。
 *
 * <p>时间复杂度: O(log(m*n)) 空间复杂度: O(1)
 */
public class T064_P074_搜索二维矩阵 {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;

    int m = matrix.length, n = matrix[0].length;
    int left = 0, right = m * n - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int row = mid / n;
      int col = mid % n;

      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    T064_P074_搜索二维矩阵 solution = new T064_P074_搜索二维矩阵();

    // 测试用例
    int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    System.out.println("测试1: " + solution.searchMatrix(matrix1, 3) + " (期望: true)");
    System.out.println("测试2: " + solution.searchMatrix(matrix1, 13) + " (期望: false)");
  }
}
