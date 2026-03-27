package com.leetcode.m_堆;

import java.util.*;

/**
 * LeetCode #295 - 数据流的中位数 难度: 困难
 *
 * <p>题目描述: 中位数是有序列表中间的数。如果列表有偶数个数，中位数则是中间两个数的平均值。 设计一个支持以下两种操作的数据结构： - void addNum(int num) -
 * 从数据流中添加一个整数 - double findMedian() - 返回目前所有元素的中位数
 *
 * <p>解题思路: 使用两个堆： - 最大堆 left：存储较小的一半元素 - 最小堆 right：存储较大的一半元素 保持两个堆的大小平衡（最多相差1），中位数就是堆顶的平均值或最大值
 *
 * <p>时间复杂度: O(log n) - addNum, O(1) - findMedian 空间复杂度: O(n)
 */
public class T076_P295_数据流的中位数 {

    PriorityQueue<Integer> left; // 最大堆，存较小的一半
    PriorityQueue<Integer> right; // 最小堆，存较大的一半

    public T076_P295_数据流的中位数() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 先加入最大堆
        left.offer(num);
        // 平衡两个堆
        right.offer(left.poll());

        // 确保左堆 >= 右堆
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }
        return (left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args) {
        T076_P295_数据流的中位数 solution = new T076_P295_数据流的中位数();

        // 测试用例
        solution.addNum(1);
        solution.addNum(2);
        System.out.println("测试1: " + solution.findMedian() + " (期望: 1.5)");

        solution.addNum(3);
        System.out.println("测试2: " + solution.findMedian() + " (期望: 2.0)");
    }
}
