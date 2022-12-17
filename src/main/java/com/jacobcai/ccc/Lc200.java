package com.jacobcai.ccc;

public class Lc200 {
    private int[] uf;
    private int size;
    
    public int numIslands(char[][] grid) {
        int rowLen, colLen;
        rowLen = grid.length;
        colLen = grid[0].length;
        uf = new int[rowLen * colLen];
        size = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    int k = i * colLen + j;
                    uf[k] = k;
                    size++;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        union(k - colLen, k);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        union(k - 1, k);
                    }
                }
            }
        }
        return size;
    }
    
    private void union(int p,
                       int q) {
        p = find(p);
        q = find(q);
        if (p == q) {
            return;
        }
        uf[q] = p;
        size--;
    }
    
    private int find(int p) {
        if (uf[p] != p) {
            uf[p] = find(uf[p]);
        }
        return uf[p];
    }
    
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '1', '0', '0'},
                         {'0', '0', '0', '1', '1'}};
        Lc200 lc200 = new Lc200();
        int res = lc200.numIslands(grid);
        System.out.println("res = " + res);
    }
}
