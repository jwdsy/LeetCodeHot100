package com.leetcode.g_链表;

import com.leetcode.util.ListNode;

import java.util.*;

/**
 * LeetCode #23 - 合并 K 个升序链表 难度: 困难
 *
 * <p>题目描述: 给你一个链表数组，每个链表都是按升序排列的。合并所有链表返回一个升序链表。
 *
 * <p>示例: 示例 1: 输入: lists = [[1,4,5],[1,3,4],[2,6]], 输出: [1,1,2,3,4,4,5,6]
 *
 * <p>解题思路: 堆（优先队列）或 分治归并 时间复杂度: O(N log k)，空间复杂度: O(k)
 */
public class T034_P023_合并K个升序链表 {

    public static void main(String[] args) {
        T034_P023_合并K个升序链表 solution = new T034_P023_合并K个升序链表();

        // 创建三个有序链表
        ListNode l1 = ListNode.createFromArray(new int[]{1, 4, 5});
        ListNode l2 = ListNode.createFromArray(new int[]{1, 3, 4});
        ListNode l3 = ListNode.createFromArray(new int[]{2, 6});
        ListNode[] lists = {l1, l2, l3};

        ListNode result = solution.mergeKLists(lists);
        System.out.println("输入: lists = [[1,4,5],[1,3,4],[2,6]]");
        System.out.println("输出: " + result);
    }

    // 解题代码

    // 解法：最小堆逐步弹出最小节点（时间 O(N log k)，空间 O(k)）
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            currentNode.next = node;
            currentNode = currentNode.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;

    }
}
