package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #234 - 回文链表 难度: 简单
 *
 * <p>题目描述: 给定一个单链表的头节点 head，判断该链表是否为回文链表。
 *
 * <p>示例: 示例 1: 输入: head = [1,2,2,1], 输出: true 示例 2: 输入: head = [1,2], 输出: false
 *
 * <p>解题思路: 快慢指针 + 反转后半部分 1. 快慢指针找中点 2. 反转后半部分链表 3. 比较前后两部分 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T024_P234_回文链表 {

    public static void main(String[] args) {
        T024_P234_回文链表 solution = new T024_P234_回文链表();

        // 测试示例: [1,2,2,1]
        int[] arr = {1, 2, 2, 1};
        ListNode head = ListNode.createFromArray(arr);
        boolean result = solution.isPalindrome(head);
        System.out.println("输入: " + Arrays.toString(arr));
        System.out.println("输出: " + result);
    }

    // 解题代码
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分
        ListNode secondHalf = reverseList(slow.next);

        // 比较
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 恢复链表（可选）
        slow.next = reverseList(secondHalf);

        return result;
    }

    private ListNode reverseList(ListNode head) {
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
