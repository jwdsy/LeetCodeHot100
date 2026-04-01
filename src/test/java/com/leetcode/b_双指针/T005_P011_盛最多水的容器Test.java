package com.leetcode.b_双指针;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LeetCode #11 - 盛最多水的容器 单元测试
 */
@DisplayName("LeetCode #11 - 盛最多水的容器")
class T005_P011_盛最多水的容器Test {

    private T005_P011_盛最多水的容器 solution;

    @BeforeEach
    void setUp() {
        solution = new T005_P011_盛最多水的容器();
    }

    @Test
    @DisplayName("示例1: [1,8,6,2,5,4,8,3,7] → 49")
    void testExample1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solution.maxArea(height));
    }

    @Test
    @DisplayName("示例2: [1,1] → 1")
    void testExample2() {
        int[] height = {1, 1};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    @DisplayName("等高递增: [1,2,3,4] → 4 (高度1，宽度3)")
    void testIncreasing() {
        int[] height = {1, 2, 3, 4};
        // 最大: min(1,4)*3=3, min(2,4)*2=4, min(3,4)*1=3 → 4
        assertEquals(4, solution.maxArea(height));
    }

    @Test
    @DisplayName("两个高柱夹低柱: [10,1,10] → 20")
    void testTallWallsWithDip() {
        int[] height = {10, 1, 10};
        assertEquals(20, solution.maxArea(height));
    }

    @Test
    @DisplayName("递减序列: [5,4,3,2,1] → 6 (高度2，宽度3 → min(5,2)*4=8? 正确应为8)")
    void testDecreasing() {
        int[] height = {5, 4, 3, 2, 1};
        // min(5,1)*4=4, min(5,2)*3=6, min(5,3)*2=6, min(5,4)*1=4
        // min(4,1)*3=3, min(4,2)*2=4, min(4,3)*1=3
        // min(3,1)*2=2, min(3,2)*1=2
        // min(2,1)*1=1 → 最大为 6
        assertEquals(6, solution.maxArea(height));
    }

    @Test
    @DisplayName("全部相同高度: [5,5,5,5] → 15")
    void testAllSameHeight() {
        int[] height = {5, 5, 5, 5};
        // min(5,5)*3 = 15
        assertEquals(15, solution.maxArea(height));
    }

    @Test
    @DisplayName("只有两个元素，不等高: [3,7] → 3")
    void testTwoElements() {
        int[] height = {3, 7};
        // min(3,7)*1 = 3
        assertEquals(3, solution.maxArea(height));
    }

    @Test
    @DisplayName("最优解在中间: [2,3,4,5,18,17,6] → 17")
    void testOptimalInMiddle() {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        // min(18,17)*1=17; min(5,17)*2=10; min(5,18)*1=5...
        // 检查一下：17*1=17, 5*2=10, 4*3=12 → 最大为 17
        assertEquals(17, solution.maxArea(height));
    }
}
