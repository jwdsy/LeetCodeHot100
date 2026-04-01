package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T082 - P118 杨辉三角")
class T082_P118_杨辉三角Test {

    private T082_P118_杨辉三角 solution;

    @BeforeEach
    void setUp() {
        solution = new T082_P118_杨辉三角();
    }

    @Test
    @DisplayName("numRows=1：[[1]]")
    void testOneRow() {
        List<List<Integer>> result = solution.generate(1);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result.get(0));
    }

    @Test
    @DisplayName("numRows=2：[[1],[1,1]]")
    void testTwoRows() {
        List<List<Integer>> result = solution.generate(2);
        assertEquals(2, result.size());
        assertEquals(Arrays.asList(1, 1), result.get(1));
    }

    @Test
    @DisplayName("numRows=5：完整杨辉三角")
    void testFiveRows() {
        List<List<Integer>> result = solution.generate(5);
        assertEquals(5, result.size());
        // 第5行: [1,4,6,4,1]
        assertEquals(Arrays.asList(1,4,6,4,1), result.get(4));
    }

    @Test
    @DisplayName("每行首尾均为1")
    void testFirstAndLastAreOne() {
        List<List<Integer>> result = solution.generate(6);
        for (List<Integer> row : result) {
            assertEquals(1, row.get(0).intValue());
            assertEquals(1, row.get(row.size() - 1).intValue());
        }
    }

    @Test
    @DisplayName("每行长度等于行号+1")
    void testRowLength() {
        List<List<Integer>> result = solution.generate(5);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(i + 1, result.get(i).size());
        }
    }

    @Test
    @DisplayName("中间元素等于上一行两个相邻元素之和")
    void testMiddleElementsSum() {
        List<List<Integer>> result = solution.generate(5);
        for (int i = 1; i < result.size(); i++) {
            for (int j = 1; j < result.get(i).size() - 1; j++) {
                int expected = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                assertEquals(expected, result.get(i).get(j).intValue());
            }
        }
    }
}
