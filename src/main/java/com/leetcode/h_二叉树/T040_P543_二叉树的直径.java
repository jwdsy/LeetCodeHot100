package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #543 - 二叉树的直径 难度: 简单
 *
 * <p>题目描述: 给定一个二叉树根节点 root，返回它的直径长度。一条路径的直径长度是路径上节点数的最大值。
 *
 * <p>示例: 示例 1: 输入: root = [1,2,3,4,5], 输出: 3
 *
 * <p>解题思路: 递归：直径 = 左子树深度 + 右子树深度 时间复杂度: O(n)，空间复杂度: O(height)
 */
public class T040_P543_二叉树的直径 {

    private int maxDiameter = 0;

    public static void main(String[] args) {
        T040_P543_二叉树的直径 solution = new T040_P543_二叉树的直径();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = solution.diameterOfBinaryTree(root);
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        depth(root);
        return maxDiameter;

    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
}
