package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import java.util.*;

/**
 * LeetCode #114 - 二叉树展开为链表 难度: 中等
 *
 * <p>题目描述: 给你二叉树的根结点 root，请你将它展开为一个单链表：展开后的单链表应该同样使用 TreeNode ，其中 right 指针指向链表中下一个结点，而左指针始终为 null。
 *
 * <p>示例: 示例 1: 输入: root = [1,2,5,3,4,null,6], 输出: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * <p>解题思路: 后序遍历：先展开左右子树，再合并 时间复杂度: O(n)，空间复杂度: O(height)
 */
public class T046_P114_二叉树展开为链表 {

  public static void main(String[] args) {
    T046_P114_二叉树展开为链表 solution = new T046_P114_二叉树展开为链表();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);

    solution.flatten(root);
    System.out.println("输出: 已展开");
  }

  // 解题代码
  public void flatten(TreeNode root) {
    if (root == null) return;

    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    root.right = left;

    TreeNode curr = root;
    while (curr.right != null) {
      curr = curr.right;
    }
    curr.right = right;
  }
}
