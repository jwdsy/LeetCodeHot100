package com.leetcode.j_回溯;

import java.util.*;

/**
 * LeetCode #46 - 全排列 难度: 中等
 *
 * <p>题目描述: 给定一个不含重复数字的数组 nums，返回其所有可能的全排列。 可以按任意顺序返回结果列表。
 *
 * <p>解题思路: 使用回溯算法。维护一个 used 数组标记当前位置是否已被使用， 从数组开头开始选择未被使用的数字加入路径，递归后撤销选择。
 *
 * <p>时间复杂度: O(n! * n) - n! 个排列，每个排列需要 O(n) 时间 空间复杂度: O(n) - 递归深度
 */
public class T055_P046_全排列 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    result.clear();
    List<Integer> path = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(nums, used, path);
    return result;
  }

  private void backtrack(int[] nums, boolean[] used, List<Integer> path) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        used[i] = true;
        path.add(nums[i]);
        backtrack(nums, used, path);
        path.remove(path.size() - 1);
        used[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    T055_P046_全排列 solution = new T055_P046_全排列();

    // 测试用例
    int[] nums1 = {1, 2, 3};
    List<List<Integer>> result1 = solution.permute(nums1);
    System.out.println("测试1: " + result1.size() + " 个排列 (期望: 6)");

    int[] nums2 = {0, 1};
    List<List<Integer>> result2 = solution.permute(nums2);
    System.out.println("测试2: " + result2.size() + " 个排列 (期望: 2)");
  }
}
