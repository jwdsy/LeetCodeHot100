package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import java.util.*;

/**
 * LeetCode #102 - 二叉树的层序遍历 难度: 中等
 *
 * <p>题目描述: 给你二叉树的根节点 root，返回其节点值的层序遍历。
 *
 * <p>示例: 示例 1: 输入: root = [3,9,20,null,null,15,7], 输出: [[3],[9,20],[15,7]]
 *
 * <p>解题思路: BFS（广度优先搜索）：使用队列 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T041_P102_二叉树的层序遍历 {

  public static void main(String[] args) {
    T041_P102_二叉树的层序遍历 solution = new T041_P102_二叉树的层序遍历();

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    List<List<Integer>> result = solution.levelOrder(root);
    System.out.println("输出: " + result);
  }

  // 解题代码
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> level = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      result.add(level);
    }

    return result;
  }
}
