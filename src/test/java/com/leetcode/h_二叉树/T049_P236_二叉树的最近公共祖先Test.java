package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T049 - LeetCode #236 二叉树的最近公共祖先")
class T049_P236_二叉树的最近公共祖先Test {

    private T049_P236_二叉树的最近公共祖先 solution;

    @BeforeEach
    void setUp() {
        solution = new T049_P236_二叉树的最近公共祖先();
    }

    @Test
    @DisplayName("示例1: p=5, q=1, LCA=3（根节点）")
    void testExample1() {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5); TreeNode q = new TreeNode(1);
        root.left = p; root.right = q;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        assertSame(root, solution.lowestCommonAncestor(root, p, q));
    }

    @Test
    @DisplayName("示例2: p=5, q=4, LCA=5（p是q的祖先）")
    void testAncestorIsLCA() {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5); TreeNode q = new TreeNode(4);
        root.left = p; root.right = new TreeNode(1);
        p.left = new TreeNode(6); p.right = new TreeNode(2);
        p.right.left = new TreeNode(7); p.right.right = q;
        assertSame(p, solution.lowestCommonAncestor(root, p, q));
    }

    @Test
    @DisplayName("两个节点在同一侧 → 返回最近公共祖先")
    void testSameSide() {
        TreeNode root = new TreeNode(1);
        TreeNode p = new TreeNode(2); TreeNode q = new TreeNode(3);
        root.left = p; p.left = q;
        assertSame(p, solution.lowestCommonAncestor(root, p, q));
    }

    @Test
    @DisplayName("p或q等于根节点 → 返回根节点")
    void testRootIsLCA() {
        TreeNode root = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        root.left = q;
        assertSame(root, solution.lowestCommonAncestor(root, root, q));
    }
}
