package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T044 - LeetCode #230 二叉搜索树中第K小的元素")
class T044_P230_二叉搜索树中第K小的元素Test {

    private T044_P230_二叉搜索树中第K小的元素 solution;

    @BeforeEach
    void setUp() {
        solution = new T044_P230_二叉搜索树中第K小的元素();
    }

    // BST: 3(1(null,2),4)
    private TreeNode buildBST1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        return root;
    }

    @Test
    @DisplayName("示例1: [3,1,4,null,2], k=1 → 1（最小值）")
    void testKth1() {
        assertEquals(1, solution.kthSmallest(buildBST1(), 1));
    }

    @Test
    @DisplayName("[3,1,4,null,2], k=2 → 2")
    void testKth2() {
        assertEquals(2, solution.kthSmallest(buildBST1(), 2));
    }

    @Test
    @DisplayName("[3,1,4,null,2], k=3 → 3（根节点）")
    void testKth3() {
        assertEquals(3, solution.kthSmallest(buildBST1(), 3));
    }

    @Test
    @DisplayName("[3,1,4,null,2], k=4 → 4（最大值）")
    void testKth4() {
        assertEquals(4, solution.kthSmallest(buildBST1(), 4));
    }

    @Test
    @DisplayName("示例2: [5,3,6,2,4,null,null,1], k=3 → 3")
    void testExample2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        assertEquals(3, solution.kthSmallest(root, 3));
    }
}
