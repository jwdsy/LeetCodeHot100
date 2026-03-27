package com.leetcode.util;

/** 链表节点定义 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  // 从数组创建链表
  public static ListNode createFromArray(int[] arr) {
    if (arr == null || arr.length == 0) return null;
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    for (int val : arr) {
      curr.next = new ListNode(val);
      curr = curr.next;
    }
    return dummy.next;
  }

  // 转换为数组
  public int[] toArray() {
    java.util.List<Integer> list = new java.util.ArrayList<>();
    ListNode curr = this;
    while (curr != null) {
      list.add(curr.val);
      curr = curr.next;
    }
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  @Override
  public String toString() {
    return java.util.Arrays.toString(toArray());
  }
}
