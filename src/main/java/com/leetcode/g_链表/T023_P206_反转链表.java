package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #206 - 反转链表 难度: 简单
 *
 * <p>题目描述: 给定单链表的头节点 head，请反转链表并返回反转后的链表。
 *
 * <p>示例: 示例 1: 输入: head = [1,2,3,4,5], 输出: [5,4,3,2,1] 示例 2: 输入: head = [1,2], 输出: [2,1] 示例 3: 输入:
 * head = [], 输出: []
 *
 * <p>解题思路: 迭代法：使用三个指针 prev、curr、next 1. 遍历链表，将当前节点的 next 指向 prev 2. prev 移到 curr，curr 移到 next
 * 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T023_P206_反转链表 {

    public static void main(String[] args) {
        T023_P206_反转链表 solution = new T023_P206_反转链表();

        // 测试示例: [1,2,3,4,5]
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createFromArray(arr);
        ListNode result = solution.reverseList(head);
        System.out.println("输入: " + Arrays.toString(arr));
        System.out.println("输出: " + result);
    }

    // 解题代码
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
