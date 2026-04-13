package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #148 - 排序链表 难度: 中等
 *
 * <p>题目描述: 给定链表的头节点 head，请按升序排列链表并返回排序后的链表头节点。
 *
 * <p>示例: 示例 1: 输入: head = [4,2,1,3], 输出: [1,2,3,4]
 *
 * <p>解题思路: 自底向上归并排序 时间复杂度: O(n log n)，空间复杂度: O(1)
 */
public class T033_P148_排序链表 {

    public static void main(String[] args) {
        T033_P148_排序链表 solution = new T033_P148_排序链表();

        int[] arr = {4, 2, 1, 3};
        ListNode head = ListNode.createFromArray(arr);
        ListNode result = solution.sortList(head);
        System.out.println("输入: head = [4,2,1,3]");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法：自底向上归并排序（时间 O(n log n)，空间 O(1)）
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int length = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int subSize = 1; subSize < length; subSize <<= 1) {
            ListNode mergedTail = dummy;
            ListNode currentHead = dummy.next;

            while (currentHead != null) {
                ListNode head1 = currentHead;
                ListNode head2 = split(head1, subSize);
                currentHead = split(head2, subSize);
                ListNode merged = merge(head1, head2);
                mergedTail.next = merged;
                while (mergedTail.next != null) {
                    mergedTail = mergedTail.next;
                }
            }
        }

        return dummy.next;

    }

    private ListNode split(ListNode head, int size) {
        if (head == null) return null;
        ListNode curr = head;
        for (int i = 1; i < size && curr.next != null; i++) {
            curr = curr.next;
        }
        ListNode second = curr.next;
        curr.next = null;
        return second;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
