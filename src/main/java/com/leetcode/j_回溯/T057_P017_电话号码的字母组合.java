package com.leetcode.j_回溯;

import java.util.*;

/**
 * LeetCode #17 - 电话号码的字母组合 难度: 中等
 *
 * <p>题目描述: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * <p>解题思路: 使用回溯算法。建立一个数字到字母的映射表， 对每个数字，遍历其对应的所有字母，进行递归组合。
 *
 * <p>时间复杂度: O(4^n * n) - 最多4个字母的n位数字组合 空间复杂度: O(n) - 递归深度
 */
public class T057_P017_电话号码的字母组合 {

  List<String> result = new ArrayList<>();
  String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    result.clear();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    backtrack(digits, 0, new StringBuilder());
    return result;
  }

  private void backtrack(String digits, int index, StringBuilder sb) {
    if (index == digits.length()) {
      result.add(sb.toString());
      return;
    }

    String letters = mapping[digits.charAt(index) - '0'];
    for (char c : letters.toCharArray()) {
      sb.append(c);
      backtrack(digits, index + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void main(String[] args) {
    T057_P017_电话号码的字母组合 solution = new T057_P017_电话号码的字母组合();

    // 测试用例
    List<String> result1 = solution.letterCombinations("23");
    System.out.println("测试1: " + result1.size() + " 个组合 (期望: 9)");

    List<String> result2 = solution.letterCombinations("");
    System.out.println("测试2: " + result2.size() + " 个组合 (期望: 0)");

    List<String> result3 = solution.letterCombinations("2");
    System.out.println("测试3: " + result3.size() + " 个组合 (期望: 3)");
  }
}
