package com.leetcode.l_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T072 - P739 每日温度")
class T072_P739_每日温度Test {

    private T072_P739_每日温度 solution;

    @BeforeEach
    void setUp() {
        solution = new T072_P739_每日温度();
    }

    @Test
    @DisplayName("示例1：[73,74,75,71,69,72,76,73]")
    void testExample1() {
        assertArrayEquals(
            new int[]{1,1,4,2,1,1,0,0},
            solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})
        );
    }

    @Test
    @DisplayName("示例2：[30,40,50,60]，递增序列")
    void testAscending() {
        assertArrayEquals(
            new int[]{1,1,1,0},
            solution.dailyTemperatures(new int[]{30,40,50,60})
        );
    }

    @Test
    @DisplayName("示例3：[30,60,90]")
    void testAscending2() {
        assertArrayEquals(
            new int[]{1,1,0},
            solution.dailyTemperatures(new int[]{30,60,90})
        );
    }

    @Test
    @DisplayName("递减序列，全部返回0")
    void testDescending() {
        assertArrayEquals(
            new int[]{0,0,0,0},
            solution.dailyTemperatures(new int[]{90,80,70,60})
        );
    }

    @Test
    @DisplayName("单元素数组，返回[0]")
    void testSingleElement() {
        assertArrayEquals(new int[]{0}, solution.dailyTemperatures(new int[]{50}));
    }

    @Test
    @DisplayName("所有温度相同，全部返回0")
    void testAllSame() {
        assertArrayEquals(
            new int[]{0,0,0},
            solution.dailyTemperatures(new int[]{70,70,70})
        );
    }

    @Test
    @DisplayName("最后有更高温度")
    void testHigherAtEnd() {
        assertArrayEquals(
            new int[]{4,3,2,1,0},
            solution.dailyTemperatures(new int[]{50,50,50,50,100})
        );
    }
}
