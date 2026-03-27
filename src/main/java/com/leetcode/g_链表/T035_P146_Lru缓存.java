package com.leetcode.g_链表;

import java.util.*;

/**
 * LeetCode #146 - LRU 缓存 难度: 中等
 *
 * <p>题目描述: 请你设计并实现一个满足 LRU (最近最少使用) 缓存约束的数据结构。
 *
 * <p>示例: 示例 1: LRUCache cache = new LRUCache(2); cache.put(1,1); cache.put(2,2); cache.get(1);
 *
 * <p>解题思路: 哈希表 + 双向链表 时间复杂度: O(1)，空间复杂度: O(capacity)
 */
public class T035_P146_Lru缓存 {

  class LRUCache {
    private int capacity;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      head = new DLinkedNode();
      tail = new DLinkedNode();
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      DLinkedNode node = cache.get(key);
      if (node == null) return -1;
      moveToHead(node);
      return node.value;
    }

    public void put(int key, int value) {
      DLinkedNode node = cache.get(key);
      if (node == null) {
        node = new DLinkedNode(key, value);
        cache.put(key, node);
        addToHead(node);
        if (cache.size() > capacity) {
          DLinkedNode tail = removeTail();
          cache.remove(tail.key);
        }
      } else {
        node.value = value;
        moveToHead(node);
      }
    }

    private void addToHead(DLinkedNode node) {
      node.prev = head;
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
    }

    private void removeNode(DLinkedNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
      removeNode(node);
      addToHead(node);
    }

    private DLinkedNode removeTail() {
      DLinkedNode node = tail.prev;
      removeNode(node);
      return node;
    }

    class DLinkedNode {
      int key, value;
      DLinkedNode prev, next;

      DLinkedNode() {}

      DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }

  public static void main(String[] args) {
    T035_P146_Lru缓存 outer = new T035_P146_Lru缓存();
    LRUCache cache = outer.new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("get(1) = " + cache.get(1));
    cache.put(3, 3);
    System.out.println("get(2) = " + cache.get(2));
  }
}
