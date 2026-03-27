package com.leetcode.l_栈;

import java.util.Stack;

/**
 * LeetCode #84 - 柱状图中最大的矩形 难度: 困难
 *
 * <p>题目描述: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1。 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * <p>解题思路: 使用单调递增栈，计算每个柱子作为最小高度的矩形面积。在数组首尾添加0简化计算
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(n)
 */
public class T073_P084_柱状图中最大的矩形 {

    public static void main(String[] args) {
        T073_P084_柱状图中最大的矩形 solution = new T073_P084_柱状图中最大的矩形();

        // 测试用例1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("测试1: " + solution.largestRectangleArea(heights1)); // 10

        // 测试用例2
        int[] heights2 = {2, 4};
        System.out.println("测试2: " + solution.largestRectangleArea(heights2)); // 4

        // 测试用例3
        int[] heights3 = {1};
        System.out.println("测试3: " + solution.largestRectangleArea(heights3)); // 1
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        // 使用单调递增栈
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // 末尾添加0，确保所有柱子都能出栈
            int h = (i == n) ? 0 : heights[i];

            // 当当前高度小于栈顶高度时，计算栈顶元素的矩形面积
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
