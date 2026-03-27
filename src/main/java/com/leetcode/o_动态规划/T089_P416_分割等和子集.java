package com.leetcode.o_动态规划;

/**
 * LeetCode #416 - 分割等和子集 难度: 中等
 *
 * <p>题目描述: 给你一个只包含正整数的非空数组 nums。判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * <p>解题思路: 转换为0-1背包问题，判断是否能凑出 sum/2 的子集和。dp[j] 表示是否能凑出和为 j 的子集
 *
 * <p>时间复杂度: O(n*sum) 空间复杂度: O(sum)
 */
public class T089_P416_分割等和子集 {

    public static void main(String[] args) {
        T089_P416_分割等和子集 solution = new T089_P416_分割等和子集();

        // 测试用例1
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("测试1: " + solution.canPartition(nums1)); // true ([1,5,5] 和 [11])

        // 测试用例2
        int[] nums2 = {1, 2, 3, 5};
        System.out.println("测试2: " + solution.canPartition(nums2)); // false (总和为11，无法分成两部分)

        // 测试用例3
        int[] nums3 = {1, 2, 5};
        System.out.println("测试3: " + solution.canPartition(nums3)); // false
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        // 总和为奇数，无法分割
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        // 最大元素超过目标，也无法分割
        if (maxNum > target) {
            return false;
        }

        // dp[j] 表示是否能凑出和为 j
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            // 从后往前遍历，避免重复使用元素
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
