package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T037 - LeetCode #104 二叉树的最大深度")
class T037_P104_二叉树的最大深度Test {

    private T037_P104_二叉树的最大深度 solution;

    @BeforeEach
    void setUp() {
        solution = new T037_P104_二叉树的最大深度();
    }

    @Test
    @DisplayName("示例1: [3,9,20,null,null,15,7] → 3")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    @DisplayName("空树 → 0")
    void testEmpty() {
        assertEquals(0, solution.maxDepth(null));
    }

    @Test
    @DisplayName("单节点 → 1")
    void testSingleNode() {
        assertEquals(1, solution.maxDepth(new TreeNode(1)));
    }

    @Test
    @DisplayName("链状（全左）: 深度3")
    void testLinkedLeft() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    @DisplayName("完全二叉树（4层）→ 4")
    void testFourLevels() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        assertEquals(4, solution.maxDepth(root));
    }
}
