package com.leetcode.l_栈;

import java.util.Stack;

/**
 * LeetCode #155 - 最小栈 难度: 简单
 *
 * <p>题目描述: 设计一个支持 push，pop，top 和获取最小元素的栈。 实现 MinStack 类: MinStack()
 * 初始化堆栈对象。 void push(int val) 将元素val推入堆栈。 void pop() 删除堆栈顶部的元素。 int top()
 * 获取堆栈顶部的元素。 int getMin() 获取堆栈中的最小元素。
 *
 * <p>解题思路: 使用两个栈，一个存储所有元素，另一个存储当前最小值
 *
 * <p>时间复杂度: O(1) 空间复杂度: O(n)
 */
public class T070_P155_最小栈 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public T070_P155_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void main(String[] args) {
        T070_P155_最小栈 minStack = new T070_P155_最小栈();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin: " + minStack.getMin()); // 返回 -3
        minStack.pop();
        System.out.println("top: " + minStack.top()); // 返回 0
        System.out.println("getMin: " + minStack.getMin()); // 返回 -2
    }

    public void push(int val) {
        stack.push(val);
        // 如果最小栈为空或新值更小，则推送
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            // 否则重复推送当前最小值
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
