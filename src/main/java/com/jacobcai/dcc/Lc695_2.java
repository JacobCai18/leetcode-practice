package com.jacobcai.dcc;

public class Lc695_2 {
    private int[] uf;
    private int[] sz;
    private int maxArea;
    
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen, colLen;
        rowLen = grid.length;
        colLen = grid[0].length;
        maxArea = 0;
        uf = new int[rowLen * colLen];
        sz = new int[rowLen * colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    int k = i * colLen + j;
                    uf[k] = k;
                    sz[k] = 1;
                    maxArea = 1;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    int k = i * colLen + j;
                    if (j < colLen - 1 && grid[i][j + 1] == 1) {
                        union(k,
                              k + 1);
                    }
                    if (i < rowLen - 1 && grid[i + 1][j] == 1) {
                        union(k,
                              k + colLen);
                    }
                }
            }
        }
        return maxArea;
    }
    
    private void union(int p,
                       int q) {
        p = find(p);
        q = find(q);
        if (p != q) {
            uf[q] = p;
            sz[p] += sz[q];
            maxArea = Math.max(maxArea,
                               sz[p]);
        }
    }
    
    private int find(int p) {
        if (uf[p] != p) {
            uf[p] = find(uf[p]);
        }
        return uf[p];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        Lc695_2 lc695_2 = new Lc695_2();
        int res = lc695_2.maxAreaOfIsland(grid);
        System.out.println("res = " + res);
    }
}
