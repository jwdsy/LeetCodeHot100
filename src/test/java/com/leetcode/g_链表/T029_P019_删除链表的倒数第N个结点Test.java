package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T029 - LeetCode #19 删除链表的倒数第N个结点")
class T029_P019_删除链表的倒数第N个结点Test {

    private T029_P019_删除链表的倒数第N个结点 solution;

    @BeforeEach
    void setUp() {
        solution = new T029_P019_删除链表的倒数第N个结点();
    }

    @Test
    @DisplayName("示例1: [1,2,3,4,5], n=2 → [1,2,3,5]（删倒数第2）")
    void testExample1() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{1, 2, 3, 5}, result.toArray());
    }

    @Test
    @DisplayName("示例2: [1], n=1 → []（删唯一节点）")
    void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.removeNthFromEnd(head, 1);
        assertNull(result);
    }

    @Test
    @DisplayName("删头节点: [1,2], n=2 → [2]")
    void testDeleteHead() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2});
        ListNode result = solution.removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{2}, result.toArray());
    }

    @Test
    @DisplayName("删尾节点: [1,2], n=1 → [1]")
    void testDeleteTail() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2});
        ListNode result = solution.removeNthFromEnd(head, 1);
        assertArrayEquals(new int[]{1}, result.toArray());
    }

    @Test
    @DisplayName("删倒数第1（末尾）: [1,2,3,4,5], n=1 → [1,2,3,4]")
    void testDeleteLast() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.removeNthFromEnd(head, 1);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result.toArray());
    }

    @Test
    @DisplayName("删倒数第1（头）: [1,2,3,4,5], n=5 → [2,3,4,5]")
    void testDeleteFirst() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.removeNthFromEnd(head, 5);
        assertArrayEquals(new int[]{2, 3, 4, 5}, result.toArray());
    }
}
