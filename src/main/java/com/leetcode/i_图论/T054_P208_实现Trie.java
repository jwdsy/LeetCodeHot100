package com.leetcode.i_图论;

/**
 * LeetCode #208 - 实现 Trie (前缀树) 难度: 中等
 *
 * <p>题目描述: 实现 Trie 类： - Trie() 初始化前缀树对象 - void insert(String word) 向前缀树中插入字符串 word - boolean
 * search(String word) 如果字符串 word 在前缀树中，返回 true - boolean startsWith(String prefix) 如果前缀树中有以 prefix
 * 为前缀的字符串，返回 true
 *
 * <p>解题思路: 使用字典树（Trie）数据结构。每个节点包含： - children: 26个子节点（对应a-z） - isEnd: 标记该节点是否是某个单词的结尾
 *
 * <p>时间复杂度: - insert: O(m) 其中 m 为 word 长度 - search: O(m) - startsWith: O(m) 空间复杂度: O(26 * m * n) 其中
 * m 为平均长度，n 为单词数
 */
public class T054_P208_实现Trie {

  private class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
      children = new TrieNode[26];
      isEnd = false;
    }
  }

  private TrieNode root;

  public T054_P208_实现Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }
      node = node.children[index];
    }
    node.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd;
  }

  public boolean startsWith(String prefix) {
    return searchPrefix(prefix) != null;
  }

  private TrieNode searchPrefix(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        return null;
      }
      node = node.children[index];
    }
    return node;
  }

  public static void main(String[] args) {
    T054_P208_实现Trie trie = new T054_P208_实现Trie();

    // 测试用例
    trie.insert("apple");
    System.out.println("search 'apple': " + trie.search("apple") + " (期望: true)");
    System.out.println("search 'app': " + trie.search("app") + " (期望: false)");
    System.out.println("startsWith 'app': " + trie.startsWith("app") + " (期望: true)");
    trie.insert("app");
    System.out.println("search 'app' after insert: " + trie.search("app") + " (期望: true)");
  }
}
