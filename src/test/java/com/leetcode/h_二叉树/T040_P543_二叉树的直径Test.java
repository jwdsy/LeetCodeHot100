package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T040 - LeetCode #543 二叉树的直径")
class T040_P543_二叉树的直径Test {

    private T040_P543_二叉树的直径 solution;

    @BeforeEach
    void setUp() {
        solution = new T040_P543_二叉树的直径();
    }

    @Test
    @DisplayName("示例1: [1,2,3,4,5] → 3（经过4-2-1-3或5-2-1-3）")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        assertEquals(3, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("示例2: [1,2] → 1")
    void testTwoNodes() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        assertEquals(1, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("单节点 → 0")
    void testSingleNode() {
        assertEquals(0, solution.diameterOfBinaryTree(new TreeNode(1)));
    }

    @Test
    @DisplayName("空树 → 0")
    void testEmpty() {
        assertEquals(0, solution.diameterOfBinaryTree(null));
    }

    @Test
    @DisplayName("链状树（不经过根节点）→ 正确计算最长路径")
    void testLongPath() {
        // 4 -> 2 -> 1 -> 3 -> 5 直径=4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        assertEquals(4, solution.diameterOfBinaryTree(root));
    }
}
