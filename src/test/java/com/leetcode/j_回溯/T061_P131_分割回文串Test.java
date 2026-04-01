package com.leetcode.j_回溯;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T061 - P131 分割回文串")
class T061_P131_分割回文串Test {

    private T061_P131_分割回文串 solution;

    /** 验证分割方案中每个子串是否是回文 */
    private boolean allPalindromes(List<List<String>> result) {
        for (List<String> partition : result) {
            for (String s : partition) {
                String rev = new StringBuilder(s).reverse().toString();
                if (!s.equals(rev)) return false;
            }
        }
        return true;
    }

    /** 验证分割方案的拼接等于原字符串 */
    private boolean allConcatEqual(List<List<String>> result, String original) {
        for (List<String> partition : result) {
            StringBuilder sb = new StringBuilder();
            for (String s : partition) sb.append(s);
            if (!sb.toString().equals(original)) return false;
        }
        return true;
    }

    @BeforeEach
    void setUp() {
        solution = new T061_P131_分割回文串();
    }

    @Test
    @DisplayName("示例：\"aab\" 有两种分割方式")
    void testAab() {
        List<List<String>> result = solution.partition("aab");
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("\"a\" 只有一种分割")
    void testSingleChar() {
        List<List<String>> result = solution.partition("a");
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("a"), result.get(0));
    }

    @Test
    @DisplayName("所有分割中每个子串都是回文")
    void testAllArePalindromes() {
        List<List<String>> result = solution.partition("aab");
        assertTrue(allPalindromes(result));
    }

    @Test
    @DisplayName("所有分割拼接等于原字符串")
    void testConcatEqualsOriginal() {
        List<List<String>> result = solution.partition("aab");
        assertTrue(allConcatEqual(result, "aab"));
    }

    @Test
    @DisplayName("\"aba\"：包含整体回文和单字符分割")
    void testAba() {
        List<List<String>> result = solution.partition("aba");
        // 至少包含 ["aba"] 和 ["a","b","a"]
        assertTrue(result.stream().anyMatch(p -> p.equals(Arrays.asList("aba"))));
        assertTrue(result.stream().anyMatch(p -> p.equals(Arrays.asList("a","b","a"))));
    }

    @Test
    @DisplayName("\"aaa\"：多种分割方式")
    void testAaa() {
        List<List<String>> result = solution.partition("aaa");
        // 应有: ["aaa"], ["a","aa"], ["aa","a"], ["a","a","a"] 共4种
        assertEquals(4, result.size());
        assertTrue(allPalindromes(result));
    }
}
