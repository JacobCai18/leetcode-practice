package com.jacobcai.cd;

import java.util.ArrayList;
import java.util.List;

public class Lc323 {
    /**
     * 邻接表
     */
    List<List<Integer>> adj;
    /**
     * 记录结点是否已被访问过
     */
    boolean[] visited;
    
    public int countComponents(int n,
                               int[][] edges) {
        // 构建邻接表
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // 无向图，添加双向引用
        for (int[] edge : edges) {
            adj.get(edge[0])
               .add(edge[1]);
            adj.get(edge[1])
               .add(edge[0]);
        }
        visited = new boolean[n];
        // 连通分量的数目
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
    
    /**
     * 从第 i 个结点深度优先遍历所有与其连接的结点
     *
     * @param i 第 i 个结点
     */
    private void dfs(int i) {
        visited[i] = true;
        // 获取该结点所连接的所有其他结点
        List<Integer> successors = adj.get(i);
        for (int successor : successors) {
            if (!visited[successor]) {
                dfs(successor);
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        Lc323 lc323 = new Lc323();
        int res = lc323.countComponents(n,
                                        edges);
        System.out.println("res = " + res);
    }
}
