package com.leetcode.n_贪心算法;

/**
 * LeetCode #121 - 买卖股票的最佳时机 难度: 简单
 *
 * <p>题目描述: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。 设计一个算法来计算你所能获取的最大利润。 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * <p>解题思路: 贪心：记录最低价格，计算当前价格与最低价格的差值，取最大
 *
 * <p>时间复杂度: O(n) 空间复杂度: O(1)
 */
public class T077_P121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        T077_P121_买卖股票的最佳时机 solution = new T077_P121_买卖股票的最佳时机();

        // 测试用例
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("测试1: " + solution.maxProfit(prices1) + " (期望: 5)");

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("测试2: " + solution.maxProfit(prices2) + " (期望: 0)");
    }
}
