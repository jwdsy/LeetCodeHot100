package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import java.util.*;

/**
 * LeetCode #94 - 二叉树的中序遍历 难度: 简单
 *
 * <p>题目描述: 给定一个二叉树根节点 root，返回它节点值的中序遍历。
 *
 * <p>示例: 示例 1: 输入: root = [1,null,2,3], 输出: [1,3,2]
 *
 * <p>解题思路: 递归或迭代：左-根-右 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T036_P094_二叉树的中序遍历 {

  public static void main(String[] args) {
    T036_P094_二叉树的中序遍历 solution = new T036_P094_二叉树的中序遍历();

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

    List<Integer> result = solution.inorderTraversal(root);
    System.out.println("输入: root = [1,null,2,3]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
  }

  private void inorder(TreeNode node, List<Integer> result) {
    if (node == null) return;
    inorder(node.left, result);
    result.add(node.val);
    inorder(node.right, result);
  }
}
