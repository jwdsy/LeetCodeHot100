package com.leetcode.o_动态规划;

import java.util.*;

/**
 * LeetCode #118 - 杨辉三角 难度: 简单
 *
 * <p>题目描述: 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * <p>示例: 示例 1: 输入: numRows = 5, 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * <p>解题思路: DP：每行首尾为1，其他位置等于上一行两个相邻元素之和 时间复杂度: O(n²)，空间复杂度: O(n²)
 */
public class T082_P118_杨辉三角 {

    public static void main(String[] args) {
        T082_P118_杨辉三角 solution = new T082_P118_杨辉三角();

        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println("numRows = " + numRows + ", 输出: " + result);
    }

    // 解题代码

    // 解法：逐行构造杨辉三角（时间 O(n^2)，空间 O(n^2)）
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            List<Integer> row = new ArrayList<>();
            for (int colIndex = 0; colIndex <= rowIndex; colIndex++) {
                if (colIndex == 0 || colIndex == rowIndex) {
                    row.add(1);
                } else {
                    // 中间元素 = 上一行左上 + 右上
                    row.add(result.get(rowIndex - 1).get(colIndex - 1) + result.get(rowIndex - 1).get(colIndex));
                }
            }
            result.add(row);
        }

        return result;

    }
}
