package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #230 - 二叉搜索树中第 K 小的元素 难度: 中等
 *
 * <p>题目描述: 给定一个二叉搜索树的根节点 root，和一个整数 k，请你设计一个算法获取其中第 k 小的元素。
 *
 * <p>示例: 示例 1: 输入: root = [3,1,4,null,2], k = 1, 输出: 1
 *
 * <p>解题思路: 中序遍历： BST 中序遍历是递增序列 时间复杂度: O(k)，空间复杂度: O(height)
 */
public class T044_P230_二叉搜索树中第K小的元素 {

    public static void main(String[] args) {
        T044_P230_二叉搜索树中第K小的元素 solution = new T044_P230_二叉搜索树中第K小的元素();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        int result = solution.kthSmallest(root, k);
        System.out.println("k = " + k + ", 输出: " + result);
    }

    // 解题代码

    // 解法
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;
            curr = curr.right;
        }

        return -1;

    }
}
