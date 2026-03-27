package com.leetcode.g_链表;

import com.leetcode.util.ListNode;
import java.util.*;

/**
 * LeetCode #21 - 合并两个有序链表 难度: 简单
 *
 * <p>题目描述: 将两个升序链表合并为一个新的升序链表并返回。
 *
 * <p>示例: 示例 1: 输入: l1 = [1,2,4], l2 = [1,3,4], 输出: [1,1,2,3,4,4] 示例 2: 输入: l1 = [], l2 = [], 输出: []
 *
 * <p>解题思路: 迭代法：创建哑节点，依次比较两个链表节点的值 时间复杂度: O(m+n)，空间复杂度: O(1)
 */
public class T027_P021_合并两个有序链表 {

  public static void main(String[] args) {
    T027_P021_合并两个有序链表 solution = new T027_P021_合并两个有序链表();

    int[] arr1 = {1, 2, 4};
    int[] arr2 = {1, 3, 4};
    ListNode l1 = ListNode.createFromArray(arr1);
    ListNode l2 = ListNode.createFromArray(arr2);
    ListNode result = solution.mergeTwoLists(l1, l2);
    System.out.println("输入: l1 = [1,2,4], l2 = [1,3,4]");
    System.out.println("输出: " + result);
  }

  // 解题代码
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
