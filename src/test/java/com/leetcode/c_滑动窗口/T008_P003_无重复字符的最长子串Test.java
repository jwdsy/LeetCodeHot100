package com.leetcode.c_滑动窗口;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T008 - LeetCode #3 无重复字符的最长子串")
class T008_P003_无重复字符的最长子串Test {

    private T008_P003_无重复字符的最长子串 solution;

    @BeforeEach
    void setUp() {
        solution = new T008_P003_无重复字符的最长子串();
    }

    @Test
    @DisplayName("示例1: \"abcabcbb\" → 3")
    void testExample1() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    @DisplayName("示例2: \"bbbbb\" → 1（全相同字符）")
    void testAllSameChars() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    @DisplayName("示例3: \"pwwkew\" → 3")
    void testExample3() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    @DisplayName("空字符串 → 0")
    void testEmptyString() {
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    @DisplayName("单字符 → 1")
    void testSingleChar() {
        assertEquals(1, solution.lengthOfLongestSubstring("z"));
    }

    @Test
    @DisplayName("全不重复: \"abcde\" → 5")
    void testAllUnique() {
        assertEquals(5, solution.lengthOfLongestSubstring("abcde"));
    }

    @Test
    @DisplayName("含空格和特殊字符: \"a b\" → 3")
    void testWithSpace() {
        assertEquals(3, solution.lengthOfLongestSubstring("a b"));
    }

    @Test
    @DisplayName("重复在两端: \"abba\" → 2")
    void testRepeatAtEnds() {
        assertEquals(2, solution.lengthOfLongestSubstring("abba"));
    }

    @Test
    @DisplayName("较长字符串: \"dvdf\" → 3")
    void testDvdf() {
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
    }
}
