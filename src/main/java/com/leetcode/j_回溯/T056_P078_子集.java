package com.leetcode.j_回溯;

import java.util.*;

/**
 * LeetCode #78 - 子集 难度: 中等
 *
 * <p>题目描述: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 解集不能包含重复的子集。你可以按任意顺序返回解集。
 *
 * <p>解题思路: 使用回溯算法。遍历数组，每个元素都有两种选择：加入当前子集或不加入。 收集所有可能的组合。由于元素互不相同，不需要 used 数组。
 *
 * <p>时间复杂度: O(n * 2^n) - 每个元素有两种选择，共 2^n 个子集 空间复杂度: O(n) - 递归深度
 */
public class T056_P078_子集 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    result.clear();
    List<Integer> path = new ArrayList<>();
    backtrack(nums, 0, path);
    return result;
  }

  private void backtrack(int[] nums, int start, List<Integer> path) {
    result.add(new ArrayList<>(path));

    for (int i = start; i < nums.length; i++) {
      path.add(nums[i]);
      backtrack(nums, i + 1, path);
      path.remove(path.size() - 1);
    }
  }

  public static void main(String[] args) {
    T056_P078_子集 solution = new T056_P078_子集();

    // 测试用例
    int[] nums1 = {1, 2, 3};
    List<List<Integer>> result1 = solution.subsets(nums1);
    System.out.println("测试1: " + result1.size() + " 个子集 (期望: 8)");

    int[] nums2 = {0};
    List<List<Integer>> result2 = solution.subsets(nums2);
    System.out.println("测试2: " + result2.size() + " 个子集 (期望: 2)");
  }
}
