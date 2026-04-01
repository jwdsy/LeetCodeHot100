package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T028 - LeetCode #2 两数相加")
class T028_P002_两数相加Test {

    private T028_P002_两数相加 solution;

    @BeforeEach
    void setUp() {
        solution = new T028_P002_两数相加();
    }

    @Test
    @DisplayName("示例1: [2,4,3]+[5,6,4]=342+465=807 → [7,0,8]")
    void testExample1() {
        ListNode l1 = ListNode.createFromArray(new int[]{2, 4, 3});
        ListNode l2 = ListNode.createFromArray(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{7, 0, 8}, result.toArray());
    }

    @Test
    @DisplayName("示例2: [0]+[0]=0 → [0]")
    void testBothZero() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{0}, result.toArray());
    }

    @Test
    @DisplayName("进位到最高位: [9,9,9,9,9,9,9]+[9,9,9,9] → [8,9,9,9,0,0,0,1]")
    void testCarryToNewDigit() {
        ListNode l1 = ListNode.createFromArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.createFromArray(new int[]{9, 9, 9, 9});
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, result.toArray());
    }

    @Test
    @DisplayName("长度不等: [1,8]+[0]=81+0=81 → [1,8]")
    void testDifferentLength() {
        ListNode l1 = ListNode.createFromArray(new int[]{1, 8});
        ListNode l2 = new ListNode(0);
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{1, 8}, result.toArray());
    }

    @Test
    @DisplayName("单位进位: [5]+[5]=10 → [0,1]")
    void testSingleDigitCarry() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{0, 1}, result.toArray());
    }
}
