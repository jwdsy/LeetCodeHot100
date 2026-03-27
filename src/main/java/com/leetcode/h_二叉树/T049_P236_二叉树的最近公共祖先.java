package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #236 - 二叉树的最近公共祖先 难度: 中等
 *
 * <p>题目描述: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * <p>示例: 示例 1: 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1, 输出: 3
 *
 * <p>解题思路: 递归：后序遍历，如果找到p或q则返回 时间复杂度: O(n)，空间复杂度: O(height)
 */
public class T049_P236_二叉树的最近公共祖先 {

    public static void main(String[] args) {
        T049_P236_二叉树的最近公共祖先 solution = new T049_P236_二叉树的最近公共祖先();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        System.out.println("输出: " + result.val);
    }

    // 解题代码
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
