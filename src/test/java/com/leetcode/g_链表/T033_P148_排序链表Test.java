package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T033 - LeetCode #148 排序链表")
class T033_P148_排序链表Test {

    private T033_P148_排序链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T033_P148_排序链表();
    }

    @Test
    @DisplayName("示例1: [4,2,1,3] → [1,2,3,4]")
    void testExample1() {
        ListNode head = ListNode.createFromArray(new int[]{4, 2, 1, 3});
        ListNode result = solution.sortList(head);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result.toArray());
    }

    @Test
    @DisplayName("示例2: [-1,5,3,4,0] → [-1,0,3,4,5]")
    void testExample2() {
        ListNode head = ListNode.createFromArray(new int[]{-1, 5, 3, 4, 0});
        ListNode result = solution.sortList(head);
        assertArrayEquals(new int[]{-1, 0, 3, 4, 5}, result.toArray());
    }

    @Test
    @DisplayName("空链表 → null")
    void testEmpty() {
        assertNull(solution.sortList(null));
    }

    @Test
    @DisplayName("单节点 → 原节点")
    void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.sortList(head);
        assertArrayEquals(new int[]{1}, result.toArray());
    }

    @Test
    @DisplayName("已排序 → 不变")
    void testAlreadySorted() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.sortList(head);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.toArray());
    }

    @Test
    @DisplayName("逆序 → 正序")
    void testReverse() {
        ListNode head = ListNode.createFromArray(new int[]{5, 4, 3, 2, 1});
        ListNode result = solution.sortList(head);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.toArray());
    }

    @Test
    @DisplayName("含重复元素: [3,1,2,3,1] → [1,1,2,3,3]")
    void testWithDuplicates() {
        ListNode head = ListNode.createFromArray(new int[]{3, 1, 2, 3, 1});
        ListNode result = solution.sortList(head);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, result.toArray());
    }
}
