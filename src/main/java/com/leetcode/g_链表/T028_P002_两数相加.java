package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import java.util.*;

/**
 * LeetCode #2 - 两数相加 难度: 中等
 *
 * <p>题目描述: 给定两个非空链表，表示两个非负整数。数字逆序存储，返回相加后的链表。
 *
 * <p>示例: 示例 1: 输入: l1 = [2,4,3], l2 = [5,6,4], 输出: [7,0,8] 示例 2: 输入: l1 = [0], l2 = [0], 输出: [0]
 *
 * <p>解题思路: 迭代法：从头开始逐位相加，处理进位 时间复杂度: O(max(m,n))，空间复杂度: O(max(m,n))
 */
public class T028_P002_两数相加 {

  public static void main(String[] args) {
    T028_P002_两数相加 solution = new T028_P002_两数相加();

    int[] arr1 = {2, 4, 3};
    int[] arr2 = {5, 6, 4};
    ListNode l1 = ListNode.createFromArray(arr1);
    ListNode l2 = ListNode.createFromArray(arr2);
    ListNode result = solution.addTwoNumbers(l1, l2);
    System.out.println("输入: l1 = [2,4,3], l2 = [5,6,4]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int val1 = (l1 != null) ? l1.val : 0;
      int val2 = (l2 != null) ? l2.val : 0;
      int sum = val1 + val2 + carry;

      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }

    return dummy.next;
  }
}
