package com.jacobcai.mcc;

import java.util.*;

public class Lc1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] adj = new ArrayList[2][n]; // 邻接表
        for (int i = 0; i < 2; i++) for (int j = 0; j < n; j++) adj[i][j] = new ArrayList<>();
        for (var r : redEdges) adj[0][r[0]].add(r[1]); // 红 - 0
        for (var b : blueEdges) adj[1][b[0]].add(b[1]); // 蓝 - 1
        int[][] dis = new int[2][n]; // i = 当前结点颜色, j = 当前结点下标, dis[i][j] = 从头到当前结点最短路径长
        for (int i = 0; i < 2; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[0][0] = dis[1][0] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int col = pair[0], cur = pair[1];
            for (var suc : adj[col ^ 1][cur]) {
                if (dis[col ^ 1][suc] != Integer.MAX_VALUE) continue; // 下一个结点已到达
                dis[col ^ 1][suc] = dis[col][cur] + 1;
                q.offer(new int[]{col ^ 1, suc});
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(dis[0][i], dis[1][i]);
            if (res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1129 lc1129 = new Lc1129();
        int[][] redEdges = {{0, 1}, {1, 2}};
        int[][] blueEdges = {};
        int[] res = lc1129.shortestAlternatingPaths(3, redEdges, blueEdges);
        System.out.println("res = " + Arrays.toString(res));
    }
}
