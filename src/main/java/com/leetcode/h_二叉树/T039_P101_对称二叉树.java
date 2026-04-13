package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #101 - 对称二叉树 难度: 简单
 *
 * <p>题目描述: 给定一个二叉树根节点 root，检查它是否镜像对称。
 *
 * <p>示例: 示例 1: 输入: root = [1,2,2,3,4,4,3], 输出: true
 *
 * <p>解题思路: 递归：比较左子树和右子树是否对称 时间复杂度: O(n)，空间复杂度: O(height)
 */
public class T039_P101_对称二叉树 {

    public static void main(String[] args) {
        T039_P101_对称二叉树 solution = new T039_P101_对称二叉树();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = solution.isSymmetric(root);
        System.out.println("输入: root = [1,2,2,3,4,4,3]");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);

    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
