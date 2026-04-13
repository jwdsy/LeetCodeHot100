package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #104 - 二叉树的最大深度 难度: 简单
 *
 * <p>题目描述: 给定一个二叉树根节点 root，返回它的最大深度。最大深度是从根节点到最远叶子节点的最长路径上的节点数。
 *
 * <p>示例: 示例 1: 输入: root = [3,9,20,null,null,15,7], 输出: 3
 *
 * <p>解题思路: 递归：最大深度 = 1 + max(左子树深度, 右子树深度) 时间复杂度: O(n)，空间复杂度: O(height)
 */
public class T037_P104_二叉树的最大深度 {

    public static void main(String[] args) {
        T037_P104_二叉树的最大深度 solution = new T037_P104_二叉树的最大深度();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.maxDepth(root);
        System.out.println("输入: root = [3,9,20,null,null,15,7]");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }
}
