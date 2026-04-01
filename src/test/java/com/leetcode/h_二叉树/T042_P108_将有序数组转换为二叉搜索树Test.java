package com.leetcode.h_二叉树;

import com.leetcode.util.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T042 - LeetCode #108 将有序数组转换为二叉搜索树")
class T042_P108_将有序数组转换为二叉搜索树Test {

    private T042_P108_将有序数组转换为二叉搜索树 solution;

    @BeforeEach
    void setUp() {
        solution = new T042_P108_将有序数组转换为二叉搜索树();
    }

    /** 验证BST的高度是否平衡（左右子树高度差不超过1） */
    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean isHeightBalanced(TreeNode node) {
        if (node == null) return true;
        int diff = Math.abs(height(node.left) - height(node.right));
        return diff <= 1 && isHeightBalanced(node.left) && isHeightBalanced(node.right);
    }

    /** 中序遍历验证是否为升序 */
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    @Test
    @DisplayName("示例1: [-10,-3,0,5,9] → 高度平衡BST，根为0")
    void testExample1() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = solution.sortedArrayToBST(nums);
        assertNotNull(result);
        assertEquals(0, result.val);
        assertTrue(isHeightBalanced(result));
        assertTrue(isValidBST(result, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    @Test
    @DisplayName("单元素 → 单节点树")
    void testSingleElement() {
        TreeNode result = solution.sortedArrayToBST(new int[]{1});
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    @DisplayName("两个元素 → 高度1或2的平衡树")
    void testTwoElements() {
        TreeNode result = solution.sortedArrayToBST(new int[]{1, 3});
        assertTrue(isHeightBalanced(result));
        assertTrue(isValidBST(result, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    @Test
    @DisplayName("[1,2,3,4,5,6,7] → 高度平衡BST（3层）")
    void testSevenElements() {
        TreeNode result = solution.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        assertTrue(isHeightBalanced(result));
        assertTrue(isValidBST(result, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
