package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T043 - LeetCode #98 验证二叉搜索树")
class T043_P098_验证二叉搜索树Test {

    private T043_P098_验证二叉搜索树 solution;

    @BeforeEach
    void setUp() {
        solution = new T043_P098_验证二叉搜索树();
    }

    @Test
    @DisplayName("示例1: [2,1,3] → true（有效BST）")
    void testValidBST() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertTrue(solution.isValidBST(root));
    }

    @Test
    @DisplayName("示例2: [5,1,4,null,null,3,6] → false（右子节点3<根5）")
    void testInvalidBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("空树 → true")
    void testEmpty() {
        assertTrue(solution.isValidBST(null));
    }

    @Test
    @DisplayName("单节点 → true")
    void testSingleNode() {
        assertTrue(solution.isValidBST(new TreeNode(1)));
    }

    @Test
    @DisplayName("根值等于左子节点 → false（BST要求严格大于）")
    void testEqualNodes() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("跨层违反BST: [10,5,15,null,null,6,20] → false（6<10但在右子树）")
    void testCrossLevelViolation() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        assertFalse(solution.isValidBST(root));
    }
}
