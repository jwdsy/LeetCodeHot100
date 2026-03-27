package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import java.util.*;

/**
 * LeetCode #437 - 路径总和 III 难度: 中等
 *
 * <p>题目描述: 给定一个二叉树的根节点 root，和一个整数 targetSum，求该二叉树里节点值之和等于 targetSum 的路径的数目。
 *
 * <p>示例: 示例 1: 输入: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8, 输出: 3
 *
 * <p>解题思路: 前缀和 + 哈希表 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T048_P437_路径总和I {

  public static void main(String[] args) {
    T048_P437_路径总和I solution = new T048_P437_路径总和I();

    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(-3);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    root.right.right = new TreeNode(11);
    root.left.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(-2);
    root.left.right.right = new TreeNode(1);

    int targetSum = 8;
    int result = solution.pathSum(root, targetSum);
    System.out.println("targetSum = " + targetSum + ", 输出: " + result);
  }

  // 解题代码
  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> prefixSumCount = new HashMap<>();
    prefixSumCount.put(0L, 1);
    return dfs(root, 0, targetSum, prefixSumCount);
  }

  private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSumCount) {
    if (node == null) return 0;

    currSum += node.val;
    int count = prefixSumCount.getOrDefault(currSum - target, 0);
    prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

    count += dfs(node.left, currSum, target, prefixSumCount);
    count += dfs(node.right, currSum, target, prefixSumCount);

    prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
    return count;
  }
}
