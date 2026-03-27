package com.leetcode.j_回溯;

import java.util.*;

/**
 * LeetCode #39 - 组合总和 难度: 中等
 *
 * <p>题目描述: 给你一个无重复元素的整数数组 candidates 和一个目标整数 target ， 找出 candidates 中可以使数字和为目标 target 的所有组合。
 * candidates 中的同一个数字可以无限制重复被选取。
 *
 * <p>解题思路: 使用回溯算法。由于可以重复选取，递归时从当前位置开始。 先对数组排序以便剪枝：如果当前和已超过 target，则后面的数更大，无需继续。
 *
 * <p>时间复杂度: O(n^T) - T 为 target/最小元素，实际通过剪枝优化 空间复杂度: O(T) - 递归深度
 */
public class T058_P039_组合总和 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    result.clear();
    Arrays.sort(candidates);
    backtrack(candidates, target, 0, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] candidates, int target, int start, List<Integer> path) {
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (candidates[i] > target) break;

      path.add(candidates[i]);
      backtrack(candidates, target - candidates[i], i, path);
      path.remove(path.size() - 1);
    }
  }

  public static void main(String[] args) {
    T058_P039_组合总和 solution = new T058_P039_组合总和();

    // 测试用例
    int[] candidates1 = {2, 3, 6, 7};
    List<List<Integer>> result1 = solution.combinationSum(candidates1, 7);
    System.out.println("测试1: " + result1);

    int[] candidates2 = {2, 3, 5};
    List<List<Integer>> result2 = solution.combinationSum(candidates2, 8);
    System.out.println("测试2: " + result2);
  }
}
