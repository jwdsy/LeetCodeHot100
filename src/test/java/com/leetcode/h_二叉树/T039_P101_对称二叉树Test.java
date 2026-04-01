package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T039 - LeetCode #101 对称二叉树")
class T039_P101_对称二叉树Test {

    private T039_P101_对称二叉树 solution;

    @BeforeEach
    void setUp() {
        solution = new T039_P101_对称二叉树();
    }

    @Test
    @DisplayName("示例1: [1,2,2,3,4,4,3] → true")
    void testSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(2);
        root.left.left = new TreeNode(3); root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4); root.right.right = new TreeNode(3);
        assertTrue(solution.isSymmetric(root));
    }

    @Test
    @DisplayName("示例2: [1,2,2,null,3,null,3] → false（不对称）")
    void testNotSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(2);
        root.left.right = new TreeNode(3); root.right.right = new TreeNode(3);
        assertFalse(solution.isSymmetric(root));
    }

    @Test
    @DisplayName("单节点 → true")
    void testSingleNode() {
        assertTrue(solution.isSymmetric(new TreeNode(1)));
    }

    @Test
    @DisplayName("空树 → true")
    void testEmpty() {
        assertTrue(solution.isSymmetric(null));
    }

    @Test
    @DisplayName("两个子节点值不同 → false")
    void testDifferentChildren() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        assertFalse(solution.isSymmetric(root));
    }

    @Test
    @DisplayName("两个相同子节点 → true")
    void testTwoSameChildren() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(2);
        assertTrue(solution.isSymmetric(root));
    }
}
