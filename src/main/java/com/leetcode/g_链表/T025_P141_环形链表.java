package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import java.util.*;

/**
 * LeetCode #141 - 环形链表 难度: 简单
 *
 * <p>题目描述: 给定一个链表的头节点 head，判断链表中是否有环。
 *
 * <p>示例: 示例 1: 输入: head = [3,2,0,-4], pos = 1, 输出: true 示例 2: 输入: head = [1,2], pos = 0, 输出: true
 * 示例 3: 输入: head = [1], pos = -1, 输出: false
 *
 * <p>解题思路: 快慢指针（Floyd判圈算法） 1. 快指针每次走两步，慢指针每次走一步 2. 如果有环，它们会相遇 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T025_P141_环形链表 {

  public static void main(String[] args) {
    T025_P141_环形链表 solution = new T025_P141_环形链表();

    // 测试示例: 创建有环链表 3->2->0->4->(回到2)
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node2; // 形成环

    boolean result = solution.hasCycle(node1);
    System.out.println("输出: " + result);
  }

  // 解题代码
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }
}
