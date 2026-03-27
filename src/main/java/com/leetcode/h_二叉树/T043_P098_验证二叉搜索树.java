package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import java.util.*;

/**
 * LeetCode #98 - 验证二叉搜索树 难度: 中等
 *
 * <p>题目描述: 给你一个二叉树的根节点 root，判断其是否是一个有效的二叉搜索树。
 *
 * <p>示例: 示例 1: 输入: root = [2,1,3], 输出: true
 *
 * <p>解题思路: 中序遍历： BST 中序遍历是递增序列 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T043_P098_验证二叉搜索树 {

  public static void main(String[] args) {
    T043_P098_验证二叉搜索树 solution = new T043_P098_验证二叉搜索树();

    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    boolean result = solution.isValidBST(root);
    System.out.println("输出: " + result);
  }

  // 解题代码
  public boolean isValidBST(TreeNode root) {
    return inorder(root);
  }

  private long prev = Long.MIN_VALUE;

  private boolean inorder(TreeNode node) {
    if (node == null) return true;

    if (!inorder(node.left)) return false;
    if (node.val <= prev) return false;
    prev = node.val;
    return inorder(node.right);
  }
}
