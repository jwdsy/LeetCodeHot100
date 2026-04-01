package com.leetcode.p_多维动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T093 - P5 最长回文子串")
class T093_P005_最长回文子串Test {

    private T093_P005_最长回文子串 solution;

    /** 验证字符串是否是回文 */
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    @BeforeEach
    void setUp() {
        solution = new T093_P005_最长回文子串();
    }

    @Test
    @DisplayName("示例1：\"babad\"，最长回文子串为 \"bab\" 或 \"aba\"")
    void testExample1() {
        String result = solution.longestPalindrome("babad");
        assertTrue(result.equals("bab") || result.equals("aba"));
    }

    @Test
    @DisplayName("示例2：\"cbbd\"，最长回文子串为 \"bb\"")
    void testExample2() {
        assertEquals("bb", solution.longestPalindrome("cbbd"));
    }

    @Test
    @DisplayName("单字符，本身是回文")
    void testSingleChar() {
        assertEquals("a", solution.longestPalindrome("a"));
    }

    @Test
    @DisplayName("全部相同字符，整个字符串是回文")
    void testAllSame() {
        assertEquals("aaaa", solution.longestPalindrome("aaaa"));
    }

    @Test
    @DisplayName("结果是原字符串的子串")
    void testIsSubstring() {
        String s = "racecar";
        String result = solution.longestPalindrome(s);
        assertTrue(s.contains(result));
    }

    @Test
    @DisplayName("结果本身是回文")
    void testResultIsPalindrome() {
        String[] tests = {"babad", "cbbd", "abcba", "abacaba"};
        for (String s : tests) {
            String result = solution.longestPalindrome(s);
            assertTrue(isPalindrome(result), "结果不是回文: " + result);
        }
    }

    @Test
    @DisplayName("\"abcba\"，整体是回文")
    void testOddPalindrome() {
        assertEquals("abcba", solution.longestPalindrome("abcba"));
    }

    @Test
    @DisplayName("\"abccba\"，偶数长度回文")
    void testEvenPalindrome() {
        assertEquals("abccba", solution.longestPalindrome("abccba"));
    }
}
