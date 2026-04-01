package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T048 - LeetCode #437 路径总和 III")
class T048_P437_路径总和ITest {

    private T048_P437_路径总和I solution;

    @BeforeEach
    void setUp() {
        solution = new T048_P437_路径总和I();
    }

    @Test
    @DisplayName("示例1: [10,5,-3,3,2,null,11,...], targetSum=8 → 3")
    void testExample1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        assertEquals(3, solution.pathSum(root, 8));
    }

    @Test
    @DisplayName("示例2: [5,4,8,11,null,13,4,...], targetSum=22 → 3")
    void testExample2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        assertEquals(3, solution.pathSum(root, 22));
    }

    @Test
    @DisplayName("空树 → 0")
    void testEmpty() {
        assertEquals(0, solution.pathSum(null, 1));
    }

    @Test
    @DisplayName("单节点匹配 → 1")
    void testSingleNodeMatch() {
        assertEquals(1, solution.pathSum(new TreeNode(5), 5));
    }

    @Test
    @DisplayName("单节点不匹配 → 0")
    void testSingleNodeNoMatch() {
        assertEquals(0, solution.pathSum(new TreeNode(5), 3));
    }

    @Test
    @DisplayName("含负数路径 → 正确计数")
    void testWithNegativeNodes() {
        // 树: root=1, left=-2, right=-3, target=-2
        // 满足的路径: [-2] (节点-2本身), [1,-3] (1+-3=-2)，共2条
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        assertEquals(2, solution.pathSum(root, -2));
    }
}
