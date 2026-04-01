package com.leetcode.i_图论;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("T053 - P207 课程表")
class T053_P207_课程表Test {

    private T053_P207_课程表 solution;

    @BeforeEach
    void setUp() {
        solution = new T053_P207_课程表();
    }

    @Test
    @DisplayName("示例1：可以完成（2门课，无环）")
    void testCanFinish() {
        assertTrue(solution.canFinish(2, new int[][]{{1,0}}));
    }

    @Test
    @DisplayName("示例2：不可完成（2门课，互相依赖成环）")
    void testCycle() {
        assertFalse(solution.canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    @Test
    @DisplayName("没有先修要求，可以完成")
    void testNoPrerequisites() {
        assertTrue(solution.canFinish(5, new int[][]{}));
    }

    @Test
    @DisplayName("单门课，无先修，可以完成")
    void testSingleCourse() {
        assertTrue(solution.canFinish(1, new int[][]{}));
    }

    @Test
    @DisplayName("链式依赖，可以完成")
    void testChainDependency() {
        // 0->1->2->3
        assertTrue(solution.canFinish(4, new int[][]{{1,0},{2,1},{3,2}}));
    }

    @Test
    @DisplayName("三节点环，无法完成")
    void testThreeNodeCycle() {
        // 0->1->2->0
        assertFalse(solution.canFinish(3, new int[][]{{1,0},{2,1},{0,2}}));
    }

    @Test
    @DisplayName("有向无环图（DAG）：多分支，可以完成")
    void testDAG() {
        // 课程 0,1,2 都需要先修课程 3
        assertTrue(solution.canFinish(4, new int[][]{{0,3},{1,3},{2,3}}));
    }

    @Test
    @DisplayName("复杂图：局部成环，无法完成")
    void testComplexCycle() {
        // 4->0->1->3->1 环存在
        assertFalse(solution.canFinish(5, new int[][]{{0,4},{1,0},{2,0},{3,1},{1,3}}));
    }
}
