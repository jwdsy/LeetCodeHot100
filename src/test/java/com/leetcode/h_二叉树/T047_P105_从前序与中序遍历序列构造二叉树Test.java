package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T047 - LeetCode #105 从前序与中序遍历序列构造二叉树")
class T047_P105_从前序与中序遍历序列构造二叉树Test {

    private T047_P105_从前序与中序遍历序列构造二叉树 solution;

    @BeforeEach
    void setUp() {
        solution = new T047_P105_从前序与中序遍历序列构造二叉树();
    }

    /** 前序遍历验证 */
    private void preOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    @Test
    @DisplayName("示例1: preorder=[3,9,20,15,7], inorder=[9,3,15,20,7] → root=3")
    void testExample1() {
        TreeNode result = solution.buildTree(
            new int[]{3, 9, 20, 15, 7},
            new int[]{9, 3, 15, 20, 7}
        );
        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertEquals(7, result.right.right.val);
    }

    @Test
    @DisplayName("单元素: preorder=[1], inorder=[1] → 单节点树")
    void testSingleElement() {
        TreeNode result = solution.buildTree(new int[]{1}, new int[]{1});
        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    @DisplayName("两个元素: preorder=[1,2], inorder=[1,2] → 右子树")
    void testTwoElements() {
        TreeNode result = solution.buildTree(new int[]{1, 2}, new int[]{1, 2});
        assertEquals(1, result.val);
        assertNull(result.left);
        assertEquals(2, result.right.val);
    }

    @Test
    @DisplayName("前序恢复验证：重建树的前序遍历等于原preorder")
    void testPreOrderRestored() {
        int[] preorder = {1, 2, 4, 5, 3, 6};
        int[] inorder = {4, 2, 5, 1, 3, 6};
        TreeNode result = solution.buildTree(preorder, inorder);
        List<Integer> restored = new java.util.ArrayList<>();
        preOrder(result, restored);
        assertArrayEquals(preorder, restored.stream().mapToInt(Integer::intValue).toArray());
    }
}
