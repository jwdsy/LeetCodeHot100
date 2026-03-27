package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import java.util.*;

/**
 * LeetCode #199 - 二叉树的右视图 难度: 中等
 *
 * <p>题目描述: 给定一个二叉树的根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序返回从右侧可见的节点值。
 *
 * <p>示例: 示例 1: 输入: root = [1,2,3,null,5,null,4], 输出: [1,3,4]
 *
 * <p>解题思路: BFS层序遍历：每层取最后一个节点 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T045_P199_二叉树的右视图 {

  public static void main(String[] args) {
    T045_P199_二叉树的右视图 solution = new T045_P199_二叉树的右视图();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);

    List<Integer> result = solution.rightSideView(root);
    System.out.println("输出: " + result);
  }

  // 解题代码
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (i == size - 1) result.add(node.val);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
    }

    return result;
  }
}
