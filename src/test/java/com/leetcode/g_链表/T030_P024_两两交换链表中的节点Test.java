package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T030 - LeetCode #24 两两交换链表中的节点")
class T030_P024_两两交换链表中的节点Test {

    private T030_P024_两两交换链表中的节点 solution;

    @BeforeEach
    void setUp() {
        solution = new T030_P024_两两交换链表中的节点();
    }

    @Test
    @DisplayName("示例1: [1,2,3,4] → [2,1,4,3]")
    void testExample1() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4});
        ListNode result = solution.swapPairs(head);
        assertArrayEquals(new int[]{2, 1, 4, 3}, result.toArray());
    }

    @Test
    @DisplayName("空链表 → null")
    void testEmpty() {
        assertNull(solution.swapPairs(null));
    }

    @Test
    @DisplayName("单节点 → 不变")
    void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.swapPairs(head);
        assertArrayEquals(new int[]{1}, result.toArray());
    }

    @Test
    @DisplayName("奇数节点: [1,2,3] → [2,1,3]（最后一个不交换）")
    void testOddLength() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3});
        ListNode result = solution.swapPairs(head);
        assertArrayEquals(new int[]{2, 1, 3}, result.toArray());
    }

    @Test
    @DisplayName("两个节点: [1,2] → [2,1]")
    void testTwoNodes() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2});
        ListNode result = solution.swapPairs(head);
        assertArrayEquals(new int[]{2, 1}, result.toArray());
    }

    @Test
    @DisplayName("六个节点: [1,2,3,4,5,6] → [2,1,4,3,6,5]")
    void testSixNodes() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNode result = solution.swapPairs(head);
        assertArrayEquals(new int[]{2, 1, 4, 3, 6, 5}, result.toArray());
    }
}
