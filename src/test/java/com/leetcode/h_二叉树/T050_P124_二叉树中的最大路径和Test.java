package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T050 - LeetCode #124 二叉树中的最大路径和")
class T050_P124_二叉树中的最大路径和Test {

    private T050_P124_二叉树中的最大路径和 solution;

    @BeforeEach
    void setUp() {
        solution = new T050_P124_二叉树中的最大路径和();
    }

    @Test
    @DisplayName("示例1: [-10,9,20,null,null,15,7] → 42（15+20+7）")
    void testExample1() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(42, solution.maxPathSum(root));
    }

    @Test
    @DisplayName("示例2: [1,2,3] → 6（全部节点）")
    void testExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(6, solution.maxPathSum(root));
    }

    @Test
    @DisplayName("单节点负数: [-3] → -3")
    void testSingleNegative() {
        assertEquals(-3, solution.maxPathSum(new TreeNode(-3)));
    }

    @Test
    @DisplayName("全负数: [-1,-2,-3] → -1（只取最大单节点）")
    void testAllNegative() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        assertEquals(-1, solution.maxPathSum(root));
    }

    @Test
    @DisplayName("单节点正数: [5] → 5")
    void testSinglePositive() {
        assertEquals(5, solution.maxPathSum(new TreeNode(5)));
    }

    @Test
    @DisplayName("路径经过根节点: [2,-1] → 2")
    void testPathThroughRoot() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        assertEquals(2, solution.maxPathSum(root));
    }
}
