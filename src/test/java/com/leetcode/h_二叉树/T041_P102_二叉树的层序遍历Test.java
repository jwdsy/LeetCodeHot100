package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T041 - LeetCode #102 二叉树的层序遍历")
class T041_P102_二叉树的层序遍历Test {

    private T041_P102_二叉树的层序遍历 solution;

    @BeforeEach
    void setUp() {
        solution = new T041_P102_二叉树的层序遍历();
    }

    @Test
    @DisplayName("示例1: [3,9,20,null,null,15,7] → [[3],[9,20],[15,7]]")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = solution.levelOrder(root);
        assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)), result);
    }

    @Test
    @DisplayName("空树 → []")
    void testEmpty() {
        assertTrue(solution.levelOrder(null).isEmpty());
    }

    @Test
    @DisplayName("单节点 → [[1]]")
    void testSingleNode() {
        assertEquals(Arrays.asList(Arrays.asList(1)), solution.levelOrder(new TreeNode(1)));
    }

    @Test
    @DisplayName("完全二叉树3层 → 3个子列表")
    void testThreeLevels() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);
        List<List<Integer>> result = solution.levelOrder(root);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(1), result.get(0));
        assertEquals(Arrays.asList(2, 3), result.get(1));
        assertEquals(Arrays.asList(4, 5), result.get(2));
    }
}
