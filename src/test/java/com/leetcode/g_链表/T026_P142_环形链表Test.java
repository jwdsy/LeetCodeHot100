package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T026 - LeetCode #142 环形链表 II")
class T026_P142_环形链表Test {

    private T026_P142_环形链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T026_P142_环形链表();
    }

    @Test
    @DisplayName("示例1: 环入口为节点2（pos=1）")
    void testCycleEntryAtPos1() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 环入口是node2
        assertSame(node2, solution.detectCycle(node1));
    }

    @Test
    @DisplayName("示例2: 环入口为头节点（pos=0）")
    void testCycleEntryAtHead() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1; // 环入口是node1
        assertSame(node1, solution.detectCycle(node1));
    }

    @Test
    @DisplayName("无环 → null")
    void testNoCycle() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3});
        assertNull(solution.detectCycle(head));
    }

    @Test
    @DisplayName("空链表 → null")
    void testEmptyList() {
        assertNull(solution.detectCycle(null));
    }

    @Test
    @DisplayName("自环（单节点）→ 该节点自身")
    void testSelfLoop() {
        ListNode node = new ListNode(1);
        node.next = node;
        assertSame(node, solution.detectCycle(node));
    }
}
