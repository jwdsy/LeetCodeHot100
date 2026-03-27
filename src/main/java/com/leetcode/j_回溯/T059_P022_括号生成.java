package com.leetcode.j_回溯;

import java.util.*;

/**
 * LeetCode #22 - 括号生成 难度: 中等
 *
 * <p>题目描述: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * <p>解题思路: 使用回溯算法。维护左右括号的使用数量： - 左括号未用完时可以添加 '(' - 右括号少于左括号时可以添加 ')'
 *
 * <p>时间复杂度: O(4^n / sqrt(n)) - 卡特兰数 空间复杂度: O(n) - 递归深度
 */
public class T059_P022_括号生成 {

  List<String> result = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    result.clear();
    backtrack(n, 0, 0, new StringBuilder());
    return result;
  }

  private void backtrack(int n, int left, int right, StringBuilder sb) {
    if (sb.length() == 2 * n) {
      result.add(sb.toString());
      return;
    }

    // 可以添加左括号
    if (left < n) {
      sb.append('(');
      backtrack(n, left + 1, right, sb);
      sb.deleteCharAt(sb.length() - 1);
    }

    // 可以添加右括号（左括号比右括号多时）
    if (right < left) {
      sb.append(')');
      backtrack(n, left, right + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void main(String[] args) {
    T059_P022_括号生成 solution = new T059_P022_括号生成();

    // 测试用例
    List<String> result1 = solution.generateParenthesis(3);
    System.out.println("测试1: " + result1.size() + " 个组合 (期望: 5)");

    List<String> result2 = solution.generateParenthesis(1);
    System.out.println("测试2: " + result2 + " (期望: [()])");
  }
}
