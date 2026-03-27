package com.leetcode.q_技巧;

/**
 * LeetCode #287 - 寻找重复数 难度: 中等
 *
 * <p>题目描述: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有一个重复的整数，返回这个重复的数。 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * <p>解题思路: 快慢指针（Floyd's Tortoise and Hare算法）。将数组看成链表，索引i指向值nums[i]，由于存在重复数字，必然形成环
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(1)
 */
public class T100_P287_寻找重复数 {

    public static void main(String[] args) {
        T100_P287_寻找重复数 solution = new T100_P287_寻找重复数();

        // 测试用例1
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("测试1: " + solution.findDuplicate(nums1)); // 2

        // 测试用例2
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("测试2: " + solution.findDuplicate(nums2)); // 3

        // 测试用例3
        int[] nums3 = {2, 2, 2, 2, 2};
        System.out.println("测试3: " + solution.findDuplicate(nums3)); // 2
    }

    /**
     * 快慢指针方法
     *
     * @param nums 数组
     * @return 重复的数
     */
    public int findDuplicate(int[] nums) {
        // 第一阶段：找到相遇点
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 第二阶段：找到环的入口（重复的数）
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    /**
     * 二分查找方法（不修改数组，但需要O(n)时间）
     *
     * @param nums 数组
     * @return 重复的数
     */
    public int findDuplicateBinarySearch(int[] nums) {
        int n = nums.length - 1;
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 计算小于等于mid的元素个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // 如果count > mid，说明重复数在[left, mid]
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
