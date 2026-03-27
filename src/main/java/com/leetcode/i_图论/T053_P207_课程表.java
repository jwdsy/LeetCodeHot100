package com.leetcode.i_图论;

import java.util.*;

/**
 * LeetCode #207 - 课程表 难度: 中等
 *
 * <p>题目描述: 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 在选修某些课程之前需要一些先修课程。 先修课程按数组
 * prerequisites 给出， 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则必须先学习课程 bi 。 请你判断是否可能完成所有课程的学习？
 *
 * <p>解题思路: 使用拓扑排序（Kahn算法或DFS检测环）。这里使用BFS（Kahn算法）： 1. 构建入度数组和邻接表 2. 将所有入度为0的节点入队 3.
 * 依次取出节点，将其邻接节点的入度-1，若入度变为0则入队 4. 最终若处理了所有节点，则无环；否则有环
 *
 * <p>时间复杂度: O(V + E) - V为课程数，E为先修关系数 空间复杂度: O(V + E)
 */
public class T053_P207_课程表 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // 构建入度数组和邻接表
    int[] inDegree = new int[numCourses];
    List<List<Integer>> adjacency = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      adjacency.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      inDegree[pre[0]]++;
      adjacency.get(pre[1]).add(pre[0]);
    }

    // 将所有入度为0的课程入队
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int count = 0; // 已完成的课程数
    while (!queue.isEmpty()) {
      int course = queue.poll();
      count++;

      // 将该课程的后续课程入度-1
      for (int next : adjacency.get(course)) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
          queue.offer(next);
        }
      }
    }

    return count == numCourses;
  }

  public static void main(String[] args) {
    T053_P207_课程表 solution = new T053_P207_课程表();

    // 测试用例 1
    int[][] prerequisites1 = {{1, 0}};
    boolean result1 = solution.canFinish(2, prerequisites1);
    System.out.println("测试1: " + result1 + " (期望: true)");

    // 测试用例 2
    int[][] prerequisites2 = {{1, 0}, {0, 1}};
    boolean result2 = solution.canFinish(2, prerequisites2);
    System.out.println("测试2: " + result2 + " (期望: false)");

    // 测试用例 3
    int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    boolean result3 = solution.canFinish(4, prerequisites3);
    System.out.println("测试3: " + result3 + " (期望: true)");
  }
}
