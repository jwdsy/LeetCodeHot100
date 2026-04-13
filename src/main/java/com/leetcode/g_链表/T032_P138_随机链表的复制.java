package com.leetcode.g_链表;

import java.util.*;

/**
 * LeetCode #138 - 随机链表的复制 难度: 中等
 *
 * <p>题目描述: 给定一个链表，每个节点包含一个额外分配的随机指针，该指针可以指向链表中的任何节点或null。返回链表的深拷贝。
 *
 * <p>解题思路: 哈希表：第一次遍历创建新节点并建立映射，第二次遍历设置next和random 时间复杂度: O(n)，空间复杂度: O(n)
 */
public class T032_P138_随机链表的复制 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        T032_P138_随机链表的复制 solution = new T032_P138_随机链表的复制();
        System.out.println("输出: 已完成");
    }

    // 解题代码

    // 解法：哈希映射原节点与新节点（时间 O(n)，空间 O(n)）
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> originalToCopy = new HashMap<>();
        Node currentNode = head;

        while (currentNode != null) {
            originalToCopy.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }

        currentNode = head;
        while (currentNode != null) {
            originalToCopy.get(currentNode).next = originalToCopy.get(currentNode.next);
            originalToCopy.get(currentNode).random = originalToCopy.get(currentNode.random);
            currentNode = currentNode.next;
        }

        return originalToCopy.get(head);

    }
}
