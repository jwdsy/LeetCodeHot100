package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #226 - 翻转二叉树 难度: 简单
 *
 * <p>题目描述: 给定一个二叉树根节点 root，翻转这棵二叉树并返回其根节点。
 *
 * <p>示例: 示例 1: 输入: root = [4,2,7,1,3,6,9], 输出: [4,7,2,9,6,3,1]
 *
 * <p>解题思路: 递归：交换左右子树，然后递归翻转子树 时间复杂度: O(n)，空间复杂度: O(height)
 */
public class T038_P226_翻转二叉树 {

    public static void main(String[] args) {
        T038_P226_翻转二叉树 solution = new T038_P226_翻转二叉树();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode result = solution.invertTree(root);
        System.out.println("输出: 已翻转");
    }

    // 解题代码
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
