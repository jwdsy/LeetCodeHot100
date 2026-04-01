package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T031 - LeetCode #25 K个一组翻转链表")
class T031_P025_K个一组翻转链表Test {

    private T031_P025_K个一组翻转链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T031_P025_K个一组翻转链表();
    }

    @Test
    @DisplayName("示例1: [1,2,3,4,5], k=2 → [2,1,4,3,5]")
    void testExample1() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseKGroup(head, 2);
        assertArrayEquals(new int[]{2, 1, 4, 3, 5}, result.toArray());
    }

    @Test
    @DisplayName("示例2: [1,2,3,4,5], k=3 → [3,2,1,4,5]")
    void testExample2() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseKGroup(head, 3);
        assertArrayEquals(new int[]{3, 2, 1, 4, 5}, result.toArray());
    }

    @Test
    @DisplayName("k=1 → 链表不变")
    void testKEqualsOne() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseKGroup(head, 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.toArray());
    }

    @Test
    @DisplayName("k等于链表长度 → 全部翻转")
    void testKEqualsLength() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseKGroup(head, 5);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result.toArray());
    }

    @Test
    @DisplayName("k大于链表长度 → 不变")
    void testKGreaterThanLength() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3});
        ListNode result = solution.reverseKGroup(head, 5);
        assertArrayEquals(new int[]{1, 2, 3}, result.toArray());
    }

    @Test
    @DisplayName("单节点: [1], k=1 → [1]")
    void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.reverseKGroup(head, 1);
        assertArrayEquals(new int[]{1}, result.toArray());
    }
}
