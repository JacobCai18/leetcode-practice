package com.jacobcai.mmd;

import java.util.*;

class UnionFind {
    private final int[] uf;

    public UnionFind(int n) {
        uf = new int[n];
        for (int i = 0; i < n; i++) uf[i] = i;
    }

    public int find(int p) {
        if (uf[p] == p) return p;
        return uf[p] = find(uf[p]);
    }

    public void merge(int p, int q) {
        uf[find(q)] = find(p);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}

public class Lc2493 {
    private int[] time;
    private int clock;
    private List<List<Integer>> adj;

    private int bfs(int start) {
        int depth = 0;
        time[start] = ++clock;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                for (int y : adj.get(x)) {
                    if (time[y] != clock) {
                        time[y] = clock;
                        queue.offer(y);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    public int magnificentSets(int n, int[][] edges) {
        // 每个连通块是否为二分图，存在非二分图的连通块则返回 -1
        // 每个二分图的最大深度之和
        time = new int[n + 1];
        clock = 0;
        UnionFind block = new UnionFind(n + 1);
        adj = new ArrayList<>(n + 1); // 建邻接表
        for (int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            block.merge(edge[0], edge[1]);
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        UnionFind bipartite = new UnionFind(n + 1); // 判断是否为二分图
        for (int u = 1; u < n + 1; u++) {
            for (int v : adj.get(u)) {
                if (bipartite.isConnected(u, v)) return -1;
                bipartite.merge(adj.get(u).get(0), v);
            }
        }
        Map<Integer, List<Integer>> blocks = new HashMap<>(); // 将连通的点放在一起
        for (int i = 1; i < n + 1; i++) {
            blocks.putIfAbsent(block.find(i), new ArrayList<>());
            blocks.get(block.find(i)).add(i);
        }
        int groups = 0; // 每个二分图的最大深度之和
        for (var entry : blocks.entrySet()) {
            int maxDepth = 0;
            for (int vertex : entry.getValue())
                maxDepth = Math.max(maxDepth, bfs(vertex));
            groups += maxDepth;
        }
        return groups;
    }

    public static void main(String[] args) {
        Lc2493 lc2493 = new Lc2493();
        int[][] edges = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        int res = lc2493.magnificentSets(6, edges);
        System.out.println("res = " + res);
    }
}
