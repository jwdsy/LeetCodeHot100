package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import java.util.*;

/**
 * LeetCode #142 - 环形链表 II 难度: 中等
 *
 * <p>题目描述: 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 *
 * <p>示例: 示例 1: 输入: head = [3,2,0,-4], pos = 1, 输出: 节点 2 示例 2: 输入: head = [1,2], pos = 0, 输出: 节点 1
 *
 * <p>解题思路: 快慢指针 + 数学推导 1. 快慢指针相遇后，将一个指针重置到头节点 2. 两个指针同速前进，再次相遇点即为环入口 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T026_P142_环形链表 {

  public static void main(String[] args) {
    T026_P142_环形链表 solution = new T026_P142_环形链表();

    // 创建有环链表
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node2;

    ListNode result = solution.detectCycle(node1);
    System.out.println("输出: " + (result != null ? result.val : "null"));
  }

  // 解题代码
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode slow = head;
    ListNode fast = head;

    // 第一次相遇
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }

    if (fast == null || fast.next == null) return null;

    // 重置到头节点
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}
