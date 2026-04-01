package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T027 - LeetCode #21 合并两个有序链表")
class T027_P021_合并两个有序链表Test {

    private T027_P021_合并两个有序链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T027_P021_合并两个有序链表();
    }

    @Test
    @DisplayName("示例1: [1,2,4] + [1,3,4] → [1,1,2,3,4,4]")
    void testExample1() {
        ListNode l1 = ListNode.createFromArray(new int[]{1, 2, 4});
        ListNode l2 = ListNode.createFromArray(new int[]{1, 3, 4});
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, result.toArray());
    }

    @Test
    @DisplayName("示例2: [] + [] → []")
    void testBothEmpty() {
        assertNull(solution.mergeTwoLists(null, null));
    }

    @Test
    @DisplayName("示例3: [] + [0] → [0]")
    void testOneEmpty() {
        ListNode l2 = new ListNode(0);
        ListNode result = solution.mergeTwoLists(null, l2);
        assertEquals(0, result.val);
    }

    @Test
    @DisplayName("l1所有元素小于l2: [1,2,3] + [4,5,6] → [1,2,3,4,5,6]")
    void testAllSmallerFirst() {
        ListNode l1 = ListNode.createFromArray(new int[]{1, 2, 3});
        ListNode l2 = ListNode.createFromArray(new int[]{4, 5, 6});
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result.toArray());
    }

    @Test
    @DisplayName("l2所有元素小于l1: [4,5,6] + [1,2,3] → [1,2,3,4,5,6]")
    void testAllSmallerSecond() {
        ListNode l1 = ListNode.createFromArray(new int[]{4, 5, 6});
        ListNode l2 = ListNode.createFromArray(new int[]{1, 2, 3});
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result.toArray());
    }

    @Test
    @DisplayName("相同元素: [1,1,1] + [1,1,1] → [1,1,1,1,1,1]")
    void testAllSameElements() {
        ListNode l1 = ListNode.createFromArray(new int[]{1, 1, 1});
        ListNode l2 = ListNode.createFromArray(new int[]{1, 1, 1});
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1}, result.toArray());
    }
}
