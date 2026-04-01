package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T022 - LeetCode #160 相交链表")
class T022_P160_相交链表Test {

    private T022_P160_相交链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T022_P160_相交链表();
    }

    @Test
    @DisplayName("示例1: 两链表在节点8处相交")
    void testIntersectionExists() {
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        ListNode result = solution.getIntersectionNode(headA, headB);
        assertSame(intersect, result);
        assertEquals(8, result.val);
    }

    @Test
    @DisplayName("示例2: 相交于节点2")
    void testIntersectionAtSecondNode() {
        ListNode intersect = new ListNode(2);
        intersect.next = new ListNode(4);

        ListNode headA = new ListNode(1);
        headA.next = intersect;

        ListNode headB = new ListNode(3);
        headB.next = intersect;

        assertSame(intersect, solution.getIntersectionNode(headA, headB));
    }

    @Test
    @DisplayName("无相交节点 → null")
    void testNoIntersection() {
        ListNode headA = ListNode.createFromArray(new int[]{1, 2, 3});
        ListNode headB = ListNode.createFromArray(new int[]{4, 5, 6});
        assertNull(solution.getIntersectionNode(headA, headB));
    }

    @Test
    @DisplayName("两链表完全相同（同一对象） → 头节点")
    void testSameList() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3});
        assertSame(head, solution.getIntersectionNode(head, head));
    }

    @Test
    @DisplayName("headA为null → null")
    void testHeadANull() {
        ListNode headB = ListNode.createFromArray(new int[]{1, 2});
        assertNull(solution.getIntersectionNode(null, headB));
    }

    @Test
    @DisplayName("headB为null → null")
    void testHeadBNull() {
        ListNode headA = ListNode.createFromArray(new int[]{1, 2});
        assertNull(solution.getIntersectionNode(headA, null));
    }
}
