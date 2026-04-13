package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;

import java.util.*;

/**
 * LeetCode #108 - 将有序数组转换为二叉搜索树 难度: 简单
 *
 * <p>题目描述: 给你一个整数数组 nums，其中元素已经按升序排列，请你将其转换为一棵高度平衡二叉搜索树。
 *
 * <p>示例: 示例 1: 输入: nums = [-10,-3,0,5,9], 输出: [0,-3,9,-10,null,5]
 *
 * <p>解题思路: 递归：选择中间元素作为根节点 时间复杂度: O(n)，空间复杂度: O(log n)
 */
public class T042_P108_将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        T042_P108_将有序数组转换为二叉搜索树 solution = new T042_P108_将有序数组转换为二叉搜索树();

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = solution.sortedArrayToBST(nums);
        System.out.println("输出: 已构建");
    }

    // 解题代码

    // 解法
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);

    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);

        return node;
    }
}
