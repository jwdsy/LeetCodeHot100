package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T024 - LeetCode #234 回文链表")
class T024_P234_回文链表Test {

    private T024_P234_回文链表 solution;

    @BeforeEach
    void setUp() {
        solution = new T024_P234_回文链表();
    }

    @Test
    @DisplayName("示例1: [1,2,2,1] → true（偶数长度回文）")
    void testEvenPalindrome() {
        assertTrue(solution.isPalindrome(ListNode.createFromArray(new int[]{1, 2, 2, 1})));
    }

    @Test
    @DisplayName("示例2: [1,2] → false")
    void testNotPalindrome() {
        assertFalse(solution.isPalindrome(ListNode.createFromArray(new int[]{1, 2})));
    }

    @Test
    @DisplayName("奇数长度回文: [1,2,1] → true")
    void testOddPalindrome() {
        assertTrue(solution.isPalindrome(ListNode.createFromArray(new int[]{1, 2, 1})));
    }

    @Test
    @DisplayName("单节点 → true")
    void testSingleNode() {
        assertTrue(solution.isPalindrome(new ListNode(1)));
    }

    @Test
    @DisplayName("空链表 → true")
    void testEmptyList() {
        assertTrue(solution.isPalindrome(null));
    }

    @Test
    @DisplayName("全相同元素: [5,5,5,5] → true")
    void testAllSame() {
        assertTrue(solution.isPalindrome(ListNode.createFromArray(new int[]{5, 5, 5, 5})));
    }

    @Test
    @DisplayName("非回文: [1,2,3,4] → false")
    void testNotPalindrome2() {
        assertFalse(solution.isPalindrome(ListNode.createFromArray(new int[]{1, 2, 3, 4})));
    }
}
