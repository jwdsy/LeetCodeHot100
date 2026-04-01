package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T025 - LeetCode #141 环形链表")
class T025_P141_环形链表Test {

    private T025_P141_环形链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T025_P141_环形链表();
    }

    @Test
    @DisplayName("示例1: 有环（pos=1）→ true")
    void testHasCycle() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 环
        assertTrue(solution.hasCycle(node1));
    }

    @Test
    @DisplayName("示例2: 有环（pos=0）→ true")
    void testCycleAtHead() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1; // 回到头
        assertTrue(solution.hasCycle(node1));
    }

    @Test
    @DisplayName("示例3: 无环 → false")
    void testNoCycle() {
        ListNode head = ListNode.createFromArray(new int[]{1});
        assertFalse(solution.hasCycle(head));
    }

    @Test
    @DisplayName("空链表 → false")
    void testEmptyList() {
        assertFalse(solution.hasCycle(null));
    }

    @Test
    @DisplayName("普通链表无环 → false")
    void testNormalListNoCycle() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        assertFalse(solution.hasCycle(head));
    }

    @Test
    @DisplayName("自环（单节点指向自身）→ true")
    void testSelfLoop() {
        ListNode node = new ListNode(1);
        node.next = node;
        assertTrue(solution.hasCycle(node));
    }
}
