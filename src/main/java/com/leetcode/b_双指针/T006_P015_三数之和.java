package com.leetcode.b_双指针;

import java.util.*;

/**
 * LeetCode #15 - 三数之和 难度: 中等
 *
 * <p>题目描述: 给定整数数组nums，判断是否存在三元组和为0，返回所有不重复的三元组。
 *
 * <p>示例: 示例 1: 输入: nums = [-1,0,1,2,-1,-4], 输出: [[-1,-1,2],[-1,0,1]] 示例 2: 输入: nums = [0,0,0], 输出:
 * [[0,0,0]]
 *
 * <p>解题思路: 排序 + 双指针：排序后固定第一个数，双指针找后两数。 时间复杂度: O(n²)，空间复杂度: O(log n)
 */
public class T006_P015_三数之和 {

    public static void main(String[] args) {
        T006_P015_三数之和 solution = new T006_P015_三数之和();

        // 测试示例: nums = [-1,0,1,2,-1,-4]
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println("输入: nums = [-1,0,1,2,-1,-4]");
        System.out.println("输出: " + result);
    }

    // 对外保留原方法名，默认调用最优解法（方法2）
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum2(nums);
    }

    // 方法1：排序 + 哈希去重（时间 O(n^2)，空间 O(n^2)）
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int need = -nums[i] - nums[j];
                if (seen.contains(need)) {
                    List<Integer> triple = Arrays.asList(nums[i], need, nums[j]);
                    triple.sort(Integer::compareTo);
                    resultSet.add(triple);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(resultSet);
    }

    // 方法2：排序 + 双指针（最优解法，时间 O(n^2)，空间 O(log n)）
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int firstIndex = 0; firstIndex < nums.length - 2; firstIndex++) {
            if (nums[firstIndex] > 0) break;
            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) continue;
            int left = firstIndex + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[firstIndex] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[firstIndex], nums[left], nums[right]));
                    // 跳过重复值，避免重复三元组
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return result;
    }
}
