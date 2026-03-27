package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #25 - K 个一组翻转链表 难度: 困难
 *
 * <p>题目描述: 给你一个链表，每 k 个节点一组进行翻转，请返回翻转后的链表。
 *
 * <p>示例: 示例 1: 输入: head = [1,2,3,4,5], k = 2, 输出: [2,1,4,3,5]
 *
 * <p>解题思路: 迭代法：先统计长度，再按组翻转 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T031_P025_K个一组翻转链表 {

    public static void main(String[] args) {
        T031_P025_K个一组翻转链表 solution = new T031_P025_K个一组翻转链表();

        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createFromArray(arr);
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);
        System.out.println("输入: head = [1,2,3,4,5], k = 2");
        System.out.println("输出: " + result);
    }

    // 解题代码
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) return dummy.next;
            }
            ListNode next = tail.next;
            ListNode[] newHead = reverse(head, tail);
            head = newHead[0];
            tail = newHead[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = next;
        }

        return dummy.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }
}
