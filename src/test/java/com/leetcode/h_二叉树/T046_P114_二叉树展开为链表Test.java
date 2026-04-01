package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T046 - LeetCode #114 二叉树展开为链表")
class T046_P114_二叉树展开为链表Test {

    private T046_P114_二叉树展开为链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T046_P114_二叉树展开为链表();
    }

    /** 将展开后的链表（只有right指针）转为数组 */
    private int[] toArray(TreeNode root) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (root != null) {
            list.add(root.val);
            assertNull(root.left, "展开后左指针应为null");
            root = root.right;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    @DisplayName("示例1: [1,2,5,3,4,null,6] → [1,2,3,4,5,6]")
    void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.right = new TreeNode(5);
        root.left.left = new TreeNode(3); root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        solution.flatten(root);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(root));
    }

    @Test
    @DisplayName("空树 → 不崩溃")
    void testEmpty() {
        assertDoesNotThrow(() -> solution.flatten(null));
    }

    @Test
    @DisplayName("单节点 → 不变")
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        solution.flatten(root);
        assertArrayEquals(new int[]{1}, toArray(root));
    }

    @Test
    @DisplayName("只有右子树 → 不变")
    void testOnlyRight() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        solution.flatten(root);
        assertArrayEquals(new int[]{1, 2, 3}, toArray(root));
    }

    @Test
    @DisplayName("只有左子树 → 转为右链")
    void testOnlyLeft() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        solution.flatten(root);
        assertArrayEquals(new int[]{1, 2, 3}, toArray(root));
    }
}
