package com.leetcode.n_贪心算法;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T080 - P763 划分字母区间")
class T080_P763_划分字母区间Test {

    private T080_P763_划分字母区间 solution;

    @BeforeEach
    void setUp() {
        solution = new T080_P763_划分字母区间();
    }

    @Test
    @DisplayName("示例1：\"ababcbacadefegdehijhklij\"")
    void testExample1() {
        List<Integer> result = solution.partitionLabels("ababcbacadefegdehijhklij");
        assertEquals(Arrays.asList(9, 7, 8), result);
    }

    @Test
    @DisplayName("示例2：\"eccbbbbdec\"")
    void testExample2() {
        List<Integer> result = solution.partitionLabels("eccbbbbdec");
        assertEquals(Arrays.asList(10), result);
    }

    @Test
    @DisplayName("单字符字符串")
    void testSingleChar() {
        List<Integer> result = solution.partitionLabels("a");
        assertEquals(Arrays.asList(1), result);
    }

    @Test
    @DisplayName("每个字符不重复，每个字符各成一段")
    void testAllUnique() {
        List<Integer> result = solution.partitionLabels("abcdef");
        assertEquals(6, result.size());
        for (int len : result) {
            assertEquals(1, len);
        }
    }

    @Test
    @DisplayName("所有字符相同，整体一段")
    void testAllSame() {
        List<Integer> result = solution.partitionLabels("aaaa");
        assertEquals(Arrays.asList(4), result);
    }

    @Test
    @DisplayName("分段长度之和等于字符串总长度")
    void testSumEqualsLength() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        int sum = result.stream().mapToInt(Integer::intValue).sum();
        assertEquals(s.length(), sum);
    }
}
