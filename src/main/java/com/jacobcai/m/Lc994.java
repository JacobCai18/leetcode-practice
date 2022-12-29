package com.jacobcai.m;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Lc994 {
    private final int[] di = new int[]{-1, 0, 1, 0};
    private final int[] dj = new int[]{0, -1, 0, 1};
    
    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 2) {
                    int index = i * colLen + j;
                    queue.offer(index);
                    depth.put(index,
                              0);
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int i = index / colLen, j = index % colLen;
            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (0 <= ni && ni < rowLen && 0 <= nj && nj < colLen && grid[ni][nj] == 1) {
                    grid[ni][nj] = 2;
                    int nindex = ni * colLen + nj;
                    queue.offer(nindex);
                    depth.put(nindex,
                              depth.get(index) + 1);
                    res = depth.get(nindex);
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        Lc994 lc994 = new Lc994();
        int res = lc994.orangesRotting(grid);
        System.out.println("res = " + res);
    }
}
