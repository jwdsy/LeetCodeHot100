package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T034 - LeetCode #23 合并K个升序链表")
class T034_P023_合并K个升序链表Test {

    private T034_P023_合并K个升序链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T034_P023_合并K个升序链表();
    }

    @Test
    @DisplayName("示例1: [[1,4,5],[1,3,4],[2,6]] → [1,1,2,3,4,4,5,6]")
    void testExample1() {
        ListNode[] lists = {
            ListNode.createFromArray(new int[]{1, 4, 5}),
            ListNode.createFromArray(new int[]{1, 3, 4}),
            ListNode.createFromArray(new int[]{2, 6})
        };
        ListNode result = solution.mergeKLists(lists);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4, 5, 6}, result.toArray());
    }

    @Test
    @DisplayName("示例2: 空数组 → null")
    void testEmptyArray() {
        assertNull(solution.mergeKLists(new ListNode[]{}));
    }

    @Test
    @DisplayName("示例3: [[]] → null")
    void testAllNullLists() {
        assertNull(solution.mergeKLists(new ListNode[]{null}));
    }

    @Test
    @DisplayName("单个链表 → 原链表")
    void testSingleList() {
        ListNode[] lists = {ListNode.createFromArray(new int[]{1, 2, 3})};
        ListNode result = solution.mergeKLists(lists);
        assertArrayEquals(new int[]{1, 2, 3}, result.toArray());
    }

    @Test
    @DisplayName("两个链表合并: [[1,3],[2,4]] → [1,2,3,4]")
    void testTwoLists() {
        ListNode[] lists = {
            ListNode.createFromArray(new int[]{1, 3}),
            ListNode.createFromArray(new int[]{2, 4})
        };
        ListNode result = solution.mergeKLists(lists);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result.toArray());
    }

    @Test
    @DisplayName("含空链表: [[1],[null],[2]] → [1,2]")
    void testWithNullList() {
        ListNode[] lists = {
            new ListNode(1),
            null,
            new ListNode(2)
        };
        ListNode result = solution.mergeKLists(lists);
        assertArrayEquals(new int[]{1, 2}, result.toArray());
    }
}
