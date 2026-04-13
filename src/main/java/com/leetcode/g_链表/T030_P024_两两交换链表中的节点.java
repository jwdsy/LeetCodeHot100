package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #24 - 两两交换链表中的节点 难度: 中等
 *
 * <p>题目描述: 给定一个链表，两两交换相邻节点，返回交换后链表的头节点。
 *
 * <p>示例: 示例 1: 输入: head = [1,2,3,4], 输出: [2,1,4,3]
 *
 * <p>解题思路: 迭代法：使用哑节点简化操作 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T030_P024_两两交换链表中的节点 {

    public static void main(String[] args) {
        T030_P024_两两交换链表中的节点 solution = new T030_P024_两两交换链表中的节点();

        int[] arr = {1, 2, 3, 4};
        ListNode head = ListNode.createFromArray(arr);
        ListNode result = solution.swapPairs(head);
        System.out.println("输入: head = [1,2,3,4]");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法：迭代两两交换（时间 O(n)，空间 O(1)）
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previousNode = dummy;

        while (previousNode.next != null && previousNode.next.next != null) {
            ListNode firstNode = previousNode.next;
            ListNode secondNode = firstNode.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            previousNode.next = secondNode;

            previousNode = firstNode;
        }

        return dummy.next;

    }
}
