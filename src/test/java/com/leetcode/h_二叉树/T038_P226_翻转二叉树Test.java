package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T038 - LeetCode #226 翻转二叉树")
class T038_P226_翻转二叉树Test {

    private T038_P226_翻转二叉树 solution;

    @BeforeEach
    void setUp() {
        solution = new T038_P226_翻转二叉树();
    }

    @Test
    @DisplayName("示例1: [4,2,7,1,3,6,9] 翻转后根节点右子树为2")
    void testExample1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode result = solution.invertTree(root);
        assertEquals(4, result.val);
        assertEquals(7, result.left.val);
        assertEquals(2, result.right.val);
        assertEquals(9, result.left.left.val);
        assertEquals(6, result.left.right.val);
    }

    @Test
    @DisplayName("空树 → null")
    void testEmpty() {
        assertNull(solution.invertTree(null));
    }

    @Test
    @DisplayName("单节点 → 原节点")
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        TreeNode result = solution.invertTree(root);
        assertEquals(1, result.val);
    }

    @Test
    @DisplayName("翻转两次恢复原树")
    void testInvertTwice() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        solution.invertTree(solution.invertTree(root));
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
    }

    @Test
    @DisplayName("叶节点翻转后左右均为null")
    void testLeafNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode result = solution.invertTree(root);
        assertNull(result.left);
        assertEquals(2, result.right.val);
    }
}
