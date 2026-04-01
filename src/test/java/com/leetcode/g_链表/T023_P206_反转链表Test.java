package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T023 - LeetCode #206 反转链表")
class T023_P206_反转链表Test {

    private T023_P206_反转链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T023_P206_反转链表();
    }

    @Test
    @DisplayName("示例1: [1,2,3,4,5] → [5,4,3,2,1]")
    void testExample1() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseList(head);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result.toArray());
    }

    @Test
    @DisplayName("示例2: [1,2] → [2,1]")
    void testTwoElements() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2});
        ListNode result = solution.reverseList(head);
        assertArrayEquals(new int[]{2, 1}, result.toArray());
    }

    @Test
    @DisplayName("空链表 → null")
    void testEmptyList() {
        assertNull(solution.reverseList(null));
    }

    @Test
    @DisplayName("单节点 → 原节点")
    void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.reverseList(head);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    @DisplayName("反转两次恢复原链表: [1,2,3,4,5]")
    void testReverseTwice() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseList(solution.reverseList(head));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.toArray());
    }
}
