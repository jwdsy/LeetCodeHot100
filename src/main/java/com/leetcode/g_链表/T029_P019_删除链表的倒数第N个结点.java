package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #19 - 删除链表的倒数第 N 个结点 难度: 中等
 *
 * <p>题目描述: 给定一个链表，删除链表的倒数第 n 个结点，并返回链表的头结点。
 *
 * <p>示例: 示例 1: 输入: head = [1,2,3,4,5], n = 2, 输出: [1,2,3,5] 示例 2: 输入: head = [1], n = 1, 输出: []
 *
 * <p>解题思路: 双指针（快慢指针） 1. 快指针先走 n 步 2. 然后两个指针同时前进 时间复杂度: O(L)，空间复杂度: O(1)
 */
public class T029_P019_删除链表的倒数第N个结点 {

    public static void main(String[] args) {
        T029_P019_删除链表的倒数第N个结点 solution = new T029_P019_删除链表的倒数第N个结点();

        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createFromArray(arr);
        int n = 2;
        ListNode result = solution.removeNthFromEnd(head, n);
        System.out.println("输入: head = [1,2,3,4,5], n = 2");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法：快慢指针间隔 n（时间 O(L)，空间 O(1)）
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast 先走 n+1 步，让 slow 停在待删除节点前一位
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;

    }
}
