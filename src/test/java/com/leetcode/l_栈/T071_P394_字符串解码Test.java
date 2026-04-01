package com.leetcode.l_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T071 - P394 字符串解码")
class T071_P394_字符串解码Test {

    private T071_P394_字符串解码 solution;

    @BeforeEach
    void setUp() {
        solution = new T071_P394_字符串解码();
    }

    @Test
    @DisplayName("示例1：\"3[a]2[bc]\" → \"aaabcbc\"")
    void testExample1() {
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
    }

    @Test
    @DisplayName("示例2：\"3[a2[c]]\" → \"accaccacc\"")
    void testExample2() {
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
    }

    @Test
    @DisplayName("示例3：\"2[abc]3[cd]ef\" → \"abcabccdcdcdef\"")
    void testExample3() {
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
    }

    @Test
    @DisplayName("无编码，返回原字符串")
    void testNoEncoding() {
        assertEquals("abc", solution.decodeString("abc"));
    }

    @Test
    @DisplayName("单层嵌套")
    void testSingleLayer() {
        assertEquals("aaaaaa", solution.decodeString("6[a]"));
    }

    @Test
    @DisplayName("多层嵌套：\"2[3[a]]\" → \"aaaaaa\"")
    void testDeepNested() {
        assertEquals("aaaaaa", solution.decodeString("2[3[a]]"));
    }

    @Test
    @DisplayName("空字符串")
    void testEmpty() {
        assertEquals("", solution.decodeString(""));
    }

    @Test
    @DisplayName("前缀字母加编码")
    void testPrefixWithEncoding() {
        assertEquals("leetleetleetcode", solution.decodeString("3[leet]code"));
    }
}
