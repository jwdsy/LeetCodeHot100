package com.leetcode.l_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T069 - P20 有效的括号")
class T069_P020_有效的括号Test {

    private T069_P020_有效的括号 solution;

    @BeforeEach
    void setUp() {
        solution = new T069_P020_有效的括号();
    }

    @Test
    @DisplayName("示例1：\"()\" 合法")
    void testSimpleParen() {
        assertTrue(solution.isValid("()"));
    }

    @Test
    @DisplayName("示例2：\"()[]{}\" 合法")
    void testMixedBrackets() {
        assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    @DisplayName("示例3：\"(]\" 不合法")
    void testMismatch() {
        assertFalse(solution.isValid("(]"));
    }

    @Test
    @DisplayName("嵌套括号合法")
    void testNested() {
        assertTrue(solution.isValid("{[()]}"));
    }

    @Test
    @DisplayName("只有左括号，不合法")
    void testOnlyOpen() {
        assertFalse(solution.isValid("((("));
    }

    @Test
    @DisplayName("只有右括号，不合法")
    void testOnlyClose() {
        assertFalse(solution.isValid("}}}"));
    }

    @Test
    @DisplayName("右括号多余，不合法")
    void testExtraClose() {
        assertFalse(solution.isValid("())"));
    }

    @Test
    @DisplayName("顺序颠倒，不合法")
    void testWrongOrder() {
        assertFalse(solution.isValid(")()"));
    }

    @Test
    @DisplayName("空字符串，合法")
    void testEmpty() {
        assertTrue(solution.isValid(""));
    }
}
