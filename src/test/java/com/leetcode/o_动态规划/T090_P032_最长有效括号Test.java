package com.leetcode.o_动态规划;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T090 - P32 最长有效括号")
class T090_P032_最长有效括号Test {

    private T090_P032_最长有效括号 solution;

    @BeforeEach
    void setUp() {
        solution = new T090_P032_最长有效括号();
    }

    @Test
    @DisplayName("示例1：\"(()\"，最长为2")
    void testExample1() {
        assertEquals(2, solution.longestValidParentheses("(()"));
    }

    @Test
    @DisplayName("示例2：\")()())\"，最长为4")
    void testExample2() {
        assertEquals(4, solution.longestValidParentheses(")()())"));
    }

    @Test
    @DisplayName("示例3：空字符串，返回0")
    void testEmpty() {
        assertEquals(0, solution.longestValidParentheses(""));
    }

    @Test
    @DisplayName("全合法：\"()()\"，返回4")
    void testAllValid() {
        assertEquals(4, solution.longestValidParentheses("()()"));
    }

    @Test
    @DisplayName("全不合法：\"))))\"，返回0")
    void testAllInvalid() {
        assertEquals(0, solution.longestValidParentheses("))))"));
    }

    @Test
    @DisplayName("嵌套括号：\"(())\"，返回4")
    void testNested() {
        assertEquals(4, solution.longestValidParentheses("(())"));
    }

    @Test
    @DisplayName("多段有效，取最长段")
    void testMultipleValidSections() {
        // "()(())" → 6
        assertEquals(6, solution.longestValidParentheses("()(())"));
    }

    @Test
    @DisplayName("栈方法与DP方法结果一致")
    void testBothMethodsConsistent() {
        String[] tests = {"(()", ")()())", "", "()(())", "((()))((("};
        for (String s : tests) {
            assertEquals(
                solution.longestValidParentheses(s),
                solution.longestValidParenthesesDP(s),
                "两种方法结果不一致，s=" + s
            );
        }
    }
}
