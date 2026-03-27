package com.leetcode.b_双指针;

/**
 * LeetCode #283 - 移动零 难度: 简单
 *
 * <p>题目描述: 给定一个数组 nums，将所有 0 移动到数组末尾，同时保持非零元素的相对顺序。必须在不复制数组的情况下原地操作。
 *
 * <p>示例: 示例 1: 输入: nums = [0,1,0,3,12], 输出: [1,3,12,0,0] 示例 2: 输入: nums = [0], 输出: [0]
 *
 * <p>解题思路: 双指针技巧：left指向已处理好的非零序列末尾，right遍历数组。 时间复杂度: O(n)，空间复杂度: O(1)
 */
public class T004_P283_移动零 {

    public static void main(String[] args) {
        T004_P283_移动零 solution = new T004_P283_移动零();

        // 测试示例: nums = [0,1,0,3,12]
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println("输入: nums = [0,1,0,3,12]");
        System.out.println("输出: " + java.util.Arrays.toString(nums));
    }

    // 解题代码
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
