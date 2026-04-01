package com.leetcode.l_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T070 - P155 最小栈")
class T070_P155_最小栈Test {

    private T070_P155_最小栈 minStack;

    @BeforeEach
    void setUp() {
        minStack = new T070_P155_最小栈();
    }

    @Test
    @DisplayName("示例：push/pop/top/getMin 基本操作")
    void testBasicOperations() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }

    @Test
    @DisplayName("单个元素的最小值")
    void testSingleElement() {
        minStack.push(5);
        assertEquals(5, minStack.getMin());
        assertEquals(5, minStack.top());
    }

    @Test
    @DisplayName("递增序列，最小值始终为第一个元素")
    void testAscendingOrder() {
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(1, minStack.getMin());
    }

    @Test
    @DisplayName("递减序列，pop后最小值正确更新")
    void testDescendingOrder() {
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.getMin());
        minStack.pop();
        assertEquals(3, minStack.getMin());
    }

    @Test
    @DisplayName("重复元素，pop后最小值正确")
    void testDuplicateMin() {
        minStack.push(2);
        minStack.push(2);
        minStack.push(1);
        minStack.push(1);
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.getMin());
    }

    @Test
    @DisplayName("负数元素")
    void testNegativeElements() {
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(-2, minStack.getMin());
    }
}
