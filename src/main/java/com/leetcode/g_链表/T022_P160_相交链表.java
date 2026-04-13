package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #160 - 相交链表 难度: 简单
 *
 * <p>题目描述: 给定两个单链表的头节点 headA 和 headB，找出并返回两个单链表相交的起始节点。如果不相交返回 null。
 *
 * <p>示例: 示例 1: 输入: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], 输出: 相交节点 8 示例 2:
 * 输入: listA = [1,2,4], listB = [3,2,4], 输出: 相交节点 2
 *
 * <p>解题思路: 双指针法 1. pA 遍历 A 然后切换到 B，pB 遍历 B 然后切换到 A 2. 如果有交点，它们会在交点相遇 时间复杂度: O(m+n)，空间复杂度: O(1)
 */
public class T022_P160_相交链表 {

    public static void main(String[] args) {
        T022_P160_相交链表 solution = new T022_P160_相交链表();

        // 创建链表 A: 4 -> 1 -> 8 -> 4 -> 5
        // 创建链表 B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        ListNode result = solution.getIntersectionNode(headA, headB);
        System.out.println("输出: " + (result != null ? result.val : "null"));
    }

    // 解题代码

    // 解法：双指针交替遍历（时间 O(m+n)，空间 O(1)）
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // 两指针都走过 A+B 的长度后，会在交点或 null 处对齐
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;

    }
}
