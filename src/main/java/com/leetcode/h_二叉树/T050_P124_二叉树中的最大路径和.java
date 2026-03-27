package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #124 - 二叉树中的最大路径和 难度: 困难
 *
 * <p>题目描述: 二叉树中的路径被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。要求路径和等于目标值。
 *
 * <p>示例: 示例 1: 输入: root = [-10,9,20,null,null,15,7], 输出: 42
 *
 * <p>解题思路: 递归：每个节点计算贡献值 时间复杂度: O(n)，空间复杂度: O(height)
 */
public class T050_P124_二叉树中的最大路径和 {

    private int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        T050_P124_二叉树中的最大路径和 solution = new T050_P124_二叉树中的最大路径和();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.maxPathSum(root);
        System.out.println("输出: " + result);
    }

    // 解题代码
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gain(root);
        return maxSum;
    }

    private int gain(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(gain(node.left), 0);
        int right = Math.max(gain(node.right), 0);

        maxSum = Math.max(maxSum, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
