package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T036 - LeetCode #94 二叉树的中序遍历")
class T036_P094_二叉树的中序遍历Test {

    private T036_P094_二叉树的中序遍历 solution;

    @BeforeEach
    void setUp() {
        solution = new T036_P094_二叉树的中序遍历();
    }

    @Test
    @DisplayName("示例1: [1,null,2,3] → [1,3,2]")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root));
    }

    @Test
    @DisplayName("空树 → []")
    void testEmpty() {
        assertTrue(solution.inorderTraversal(null).isEmpty());
    }

    @Test
    @DisplayName("单节点 → [1]")
    void testSingleNode() {
        assertEquals(Arrays.asList(1), solution.inorderTraversal(new TreeNode(1)));
    }

    @Test
    @DisplayName("完全二叉树 [1,2,3] → [2,1,3]")
    void testFullTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(Arrays.asList(2, 1, 3), solution.inorderTraversal(root));
    }

    @Test
    @DisplayName("BST [3,1,4,null,2] 中序应为升序 [1,2,3,4]")
    void testBST() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        assertEquals(Arrays.asList(1, 2, 3, 4), solution.inorderTraversal(root));
    }
}
