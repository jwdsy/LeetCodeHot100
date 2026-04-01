package com.leetcode.c_滑动窗口;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T009 - LeetCode #438 找到字符串中所有字母异位词")
class T009_P438_找到字符串中所有字母异位词Test {

    private T009_P438_找到字符串中所有字母异位词 solution;

    @BeforeEach
    void setUp() {
        solution = new T009_P438_找到字符串中所有字母异位词();
    }

    @Test
    @DisplayName("示例1: s=\"cbaebabacd\", p=\"abc\" → [0,6]")
    void testExample1() {
        List<Integer> result = solution.findAnagrams("cbaebabacd", "abc");
        assertEquals(Arrays.asList(0, 6), result);
    }

    @Test
    @DisplayName("示例2: s=\"abab\", p=\"ab\" → [0,1,2]")
    void testExample2() {
        List<Integer> result = solution.findAnagrams("abab", "ab");
        assertEquals(Arrays.asList(0, 1, 2), result);
    }

    @Test
    @DisplayName("p比s长，无结果 → []")
    void testPLongerThanS() {
        List<Integer> result = solution.findAnagrams("ab", "abc");
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("s和p相等且为异位词 → [0]")
    void testSameLengthAnagram() {
        List<Integer> result = solution.findAnagrams("ba", "ab");
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    @DisplayName("无任何异位词 → []")
    void testNoAnagram() {
        List<Integer> result = solution.findAnagrams("aaaaa", "bc");
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("整个s就是p的异位词: s=\"cba\", p=\"abc\" → [0]")
    void testEntireStringIsAnagram() {
        List<Integer> result = solution.findAnagrams("cba", "abc");
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    @DisplayName("全相同字符: s=\"aaa\", p=\"a\" → [0,1,2]")
    void testAllSameChars() {
        List<Integer> result = solution.findAnagrams("aaa", "a");
        assertEquals(Arrays.asList(0, 1, 2), result);
    }
}
