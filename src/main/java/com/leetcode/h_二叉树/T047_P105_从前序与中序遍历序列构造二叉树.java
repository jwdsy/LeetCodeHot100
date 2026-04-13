package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #105 - 从前序与中序遍历序列构造二叉树 难度: 中等
 *
 * <p>题目描述: 给定两个整数数组 preorder 和 inorder ，请构造二叉树并返回其根节点。
 *
 * <p>示例: 示例 1: 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7], 输出: [3,9,20,null,null,15,7]
 *
 * <p>解题思路: 递归：前序找到根，中序分左右子树 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T047_P105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        T047_P105_从前序与中序遍历序列构造二叉树 solution = new T047_P105_从前序与中序遍历序列构造二叉树();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = solution.buildTree(preorder, inorder);
        System.out.println("输出: 已构建");
    }

    // 解题代码
    private Map<Integer, Integer> indexMap = new HashMap<>();

    // 解法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        int rootVal = preorder[preStart];
        int rootIndex = indexMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }
}
