package com.leetcode.g_链表;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T035 - LeetCode #146 LRU 缓存")
class T035_P146_Lru缓存Test {

    private T035_P146_Lru缓存 outer;

    @BeforeEach
    void setUp() {
        outer = new T035_P146_Lru缓存();
    }

    @Test
    @DisplayName("示例1: 基本 put/get 操作，淘汰最久未使用")
    void testBasicLRU() {
        T035_P146_Lru缓存.LRUCache cache = outer.new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));   // 返回1，1最近使用
        cache.put(3, 3);                  // 淘汰key=2
        assertEquals(-1, cache.get(2));  // key=2已淘汰
        cache.put(4, 4);                  // 淘汰key=1
        assertEquals(-1, cache.get(1));  // key=1已淘汰
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    @DisplayName("get不存在的key → -1")
    void testGetNonExistent() {
        T035_P146_Lru缓存.LRUCache cache = outer.new LRUCache(1);
        assertEquals(-1, cache.get(1));
    }

    @Test
    @DisplayName("put更新已有key的value")
    void testPutUpdateExisting() {
        T035_P146_Lru缓存.LRUCache cache = outer.new LRUCache(2);
        cache.put(1, 1);
        cache.put(1, 10);
        assertEquals(10, cache.get(1));
    }

    @Test
    @DisplayName("容量为1时，每次put都淘汰旧值")
    void testCapacityOne() {
        T035_P146_Lru缓存.LRUCache cache = outer.new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    @DisplayName("put后get更新使用顺序，不被错误淘汰")
    void testGetUpdatesOrder() {
        T035_P146_Lru缓存.LRUCache cache = outer.new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.get(2);        // 2最近使用
        cache.put(4, 1);     // 淘汰1（最久未使用）
        assertEquals(-1, cache.get(1));
        assertEquals(1, cache.get(2));
    }

    @Test
    @DisplayName("连续put相同key → 不超出容量")
    void testRepeatPut() {
        T035_P146_Lru缓存.LRUCache cache = outer.new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 100); // 更新key=1
        cache.put(3, 3);   // 淘汰key=2
        assertEquals(-1, cache.get(2));
        assertEquals(100, cache.get(1));
        assertEquals(3, cache.get(3));
    }
}
