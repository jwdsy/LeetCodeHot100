package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T045 - LeetCode #199 二叉树的右视图")
class T045_P199_二叉树的右视图Test {

    private T045_P199_二叉树的右视图 solution;

    @BeforeEach
    void setUp() {
        solution = new T045_P199_二叉树的右视图();
    }

    @Test
    @DisplayName("示例1: [1,2,3,null,5,null,4] → [1,3,4]")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        assertEquals(Arrays.asList(1, 3, 4), solution.rightSideView(root));
    }

    @Test
    @DisplayName("空树 → []")
    void testEmpty() {
        assertTrue(solution.rightSideView(null).isEmpty());
    }

    @Test
    @DisplayName("单节点 → [1]")
    void testSingleNode() {
        assertEquals(Arrays.asList(1), solution.rightSideView(new TreeNode(1)));
    }

    @Test
    @DisplayName("只有左子树: [1,2,null,3] → [1,2,3]")
    void testOnlyLeftSubtree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        assertEquals(Arrays.asList(1, 2, 3), solution.rightSideView(root));
    }

    @Test
    @DisplayName("只有右子树 → 每层唯一节点")
    void testOnlyRightSubtree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        assertEquals(Arrays.asList(1, 3), solution.rightSideView(root));
    }
}
