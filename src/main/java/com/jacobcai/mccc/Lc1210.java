package com.jacobcai.mccc;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lc1210 {
    private final int[][] DIRS = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    public int minimumMoves(int[][] grid) {
        int n = grid.length, ct = 0;
        boolean[][][] vis = new boolean[n][n][2];
        vis[0][0][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0}); // 初始位置
        while (!q.isEmpty()) {
            ct++;
            int sz = q.size();
            while (sz-- > 0) {
                int[] f = q.poll();
                int X = f[0], Y = f[1], S = f[2];
                for (var d : DIRS) {
                    int x = X + d[0], y = Y + d[1], s = S ^ d[2]; // 先移动, 再判断新位置是否合规
                    int x2 = x + s, y2 = y + (s ^ 1); // 蛇头
                    if (x2 < n && y2 < n && !vis[x][y][s] && grid[x][y] == 0 &&
                            grid[x2][y2] == 0 && (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2) return ct; // 此时蛇头一定在 (n - 1, n - 1)
                        vis[x][y][s] = true;
                        q.offer(new int[]{x, y, s});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc1210 lc1210 = new Lc1210();
        int[][] grid = {{0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0}};
        int res = lc1210.minimumMoves(grid);
        System.out.println("res = " + res);
    }
}
