package com.leetcode.g_链表;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T032 - LeetCode #138 随机链表的复制")
class T032_P138_随机链表的复制Test {

    private T032_P138_随机链表的复制 outer;

    @BeforeEach
    void setUp() {
        outer = new T032_P138_随机链表的复制();
    }

    /** 辅助方法：创建 Node 实例（Node 是 outer 的非静态内部类） */
    private T032_P138_随机链表的复制.Node newNode(int val) {
        return outer.new Node(val);
    }

    @Test
    @DisplayName("空链表 → null")
    void testNullInput() {
        assertNull(outer.copyRandomList(null));
    }

    @Test
    @DisplayName("单节点（random=null）→ 深拷贝，不是同一对象")
    void testSingleNodeNoRandom() {
        T032_P138_随机链表的复制.Node node = newNode(1);
        T032_P138_随机链表的复制.Node copy = outer.copyRandomList(node);
        assertNotNull(copy);
        assertEquals(1, copy.val);
        assertNull(copy.next);
        assertNull(copy.random);
        assertNotSame(node, copy);
    }

    @Test
    @DisplayName("单节点（random=自身）→ 深拷贝的random也指向自身")
    void testSingleNodeSelfRandom() {
        T032_P138_随机链表的复制.Node node = newNode(1);
        node.random = node;
        T032_P138_随机链表的复制.Node copy = outer.copyRandomList(node);
        assertNotNull(copy);
        assertEquals(1, copy.val);
        assertSame(copy, copy.random);
        assertNotSame(node, copy);
    }

    @Test
    @DisplayName("多节点：验证值相同但对象不同，random关系正确复制")
    void testMultipleNodes() {
        // 1 -> 2 -> 3, random: n1→n3, n2→n1, n3→n2
        T032_P138_随机链表的复制.Node n1 = newNode(1);
        T032_P138_随机链表的复制.Node n2 = newNode(2);
        T032_P138_随机链表的复制.Node n3 = newNode(3);
        n1.next = n2; n2.next = n3;
        n1.random = n3; n2.random = n1; n3.random = n2;

        T032_P138_随机链表的复制.Node copy = outer.copyRandomList(n1);

        // 值相同
        assertEquals(1, copy.val);
        assertEquals(2, copy.next.val);
        assertEquals(3, copy.next.next.val);

        // 对象不同（深拷贝）
        assertNotSame(n1, copy);
        assertNotSame(n2, copy.next);
        assertNotSame(n3, copy.next.next);

        // random关系保持
        assertSame(copy.next.next, copy.random);
        assertSame(copy, copy.next.random);
        assertSame(copy.next, copy.next.next.random);
    }

    @Test
    @DisplayName("全部random为null → 深拷贝且random均为null")
    void testAllRandomNull() {
        T032_P138_随机链表的复制.Node n1 = newNode(7);
        T032_P138_随机链表的复制.Node n2 = newNode(13);
        n1.next = n2;

        T032_P138_随机链表的复制.Node copy = outer.copyRandomList(n1);
        assertNull(copy.random);
        assertNull(copy.next.random);
    }
}
