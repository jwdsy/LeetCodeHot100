package com.leetcode.i_图论;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T054 - P208 实现Trie (前缀树)")
class T054_P208_实现TrieTest {

    private T054_P208_实现Trie trie;

    @BeforeEach
    void setUp() {
        trie = new T054_P208_实现Trie();
    }

    @Test
    @DisplayName("示例：insert/search/startsWith 基本功能")
    void testBasicOperations() {
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    @Test
    @DisplayName("查找不存在的单词")
    void testSearchNotExist() {
        trie.insert("hello");
        assertFalse(trie.search("hell"));
        assertFalse(trie.search("helloo"));
        assertFalse(trie.search("world"));
    }

    @Test
    @DisplayName("前缀查找")
    void testStartsWith() {
        trie.insert("word");
        assertTrue(trie.startsWith("w"));
        assertTrue(trie.startsWith("wo"));
        assertTrue(trie.startsWith("wor"));
        assertTrue(trie.startsWith("word"));
        assertFalse(trie.startsWith("words"));
        assertFalse(trie.startsWith("abc"));
    }

    @Test
    @DisplayName("插入多个单词，共享前缀")
    void testSharedPrefix() {
        trie.insert("cat");
        trie.insert("car");
        trie.insert("card");
        assertTrue(trie.search("cat"));
        assertTrue(trie.search("car"));
        assertTrue(trie.search("card"));
        assertFalse(trie.search("ca"));
        assertTrue(trie.startsWith("ca"));
        assertTrue(trie.startsWith("car"));
    }

    @Test
    @DisplayName("空树查找")
    void testEmptyTrie() {
        assertFalse(trie.search("any"));
        assertFalse(trie.startsWith("any"));
    }

    @Test
    @DisplayName("单字符单词")
    void testSingleCharWord() {
        trie.insert("a");
        assertTrue(trie.search("a"));
        assertTrue(trie.startsWith("a"));
        assertFalse(trie.search("b"));
    }

    @Test
    @DisplayName("重复插入同一单词")
    void testDuplicateInsert() {
        trie.insert("test");
        trie.insert("test");
        assertTrue(trie.search("test"));
        assertTrue(trie.startsWith("test"));
        assertTrue(trie.startsWith("tes"));
    }
}
