package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T087 - P300 最长递增子序列")
class T087_P300_最长递增子序列Test {

    private T087_P300_最长递增子序列 solution;

    @BeforeEach
    void setUp() {
        solution = new T087_P300_最长递增子序列();
    }

    @Test
    @DisplayName("示例1：[10,9,2,5,3,7,101,18]，长度4")
    void testExample1() {
        assertEquals(4, solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    @Test
    @DisplayName("示例2：[0,1,0,3,2,3]，长度4")
    void testExample2() {
        assertEquals(4, solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    @Test
    @DisplayName("示例3：[7,7,7,7,7]，全部相同，长度1")
    void testAllSame() {
        assertEquals(1, solution.lengthOfLIS(new int[]{7,7,7,7,7}));
    }

    @Test
    @DisplayName("单元素，长度1")
    void testSingleElement() {
        assertEquals(1, solution.lengthOfLIS(new int[]{5}));
    }

    @Test
    @DisplayName("严格递增，长度等于数组长度")
    void testStrictlyIncreasing() {
        assertEquals(5, solution.lengthOfLIS(new int[]{1,2,3,4,5}));
    }

    @Test
    @DisplayName("严格递减，长度为1")
    void testStrictlyDecreasing() {
        assertEquals(1, solution.lengthOfLIS(new int[]{5,4,3,2,1}));
    }

    @Test
    @DisplayName("二分优化版与DP版结果一致")
    void testBothMethodsConsistent() {
        int[][] testCases = {
            {10,9,2,5,3,7,101,18},
            {0,1,0,3,2,3},
            {7,7,7,7}
        };
        for (int[] nums : testCases) {
            assertEquals(
                solution.lengthOfLIS(nums),
                solution.lengthOfLISDP(nums),
                "两种方法结果不一致"
            );
        }
    }
}
