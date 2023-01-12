package com.jacobcai.dccc;

public class Lc785 {
    private int[] uf;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        uf = new int[n];
        for (int i = 0; i < n; i++) uf[i] = i;
        // 遍历每个顶点，将当前顶点的所有邻接点进行合并
        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                // 若某个邻接点与当前顶点已经在一个集合中了，说明不是二分图，返回 false。
                if (isConnected(i, v)) return false;
                union(graph[i][0], v);
            }
        }
        return true;
    }

    private int find(int p) {
        if (uf[p] == p) return p;
        return uf[p] = find(uf[p]);
    }

    private void union(int p, int q) {
        uf[find(q)] = find(p);
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        Lc785 lc785 = new Lc785();
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean res = lc785.isBipartite(graph);
        System.out.println("res = " + res);
    }
}
