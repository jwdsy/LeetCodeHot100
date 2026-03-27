package com.leetcode.l_栈;

import java.util.Stack;

/**
 * LeetCode #739 - 每日温度 难度: 中等
 *
 * <p>题目描述: 给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，其中 answer[i] 是指对于第 i
 * 天，下一个更高温度出现在几天后。如果气温都不会升高，请在该位置用 0 代替。
 *
 * <p>解题思路: 使用单调递减栈，栈中存储索引。当遇到更高温度时，计算天数差
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(n)
 */
public class T072_P739_每日温度 {

    public static void main(String[] args) {
        T072_P739_每日温度 solution = new T072_P739_每日温度();

        // 测试用例
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.print("测试1: ");
        for (int r : result1) {
            System.out.print(r + " ");
        }
        System.out.println(); // [1,1,4,2,1,1,0,0]

        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.print("测试2: ");
        for (int r : result2) {
            System.out.print(r + " ");
        }
        System.out.println(); // [1,1,1,0]
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // 存储索引

        for (int i = 0; i < n; i++) {
            // 当前温度比栈顶温度高，找到更高温度的位置
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }
}
