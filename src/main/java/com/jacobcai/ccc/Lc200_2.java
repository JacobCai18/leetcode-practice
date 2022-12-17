package com.jacobcai.ccc;

public class Lc200_2 {
    private char[][] grid;
    private int rowLen;
    private int colLen;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        rowLen = grid.length;
        colLen = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        return cnt;
    }
    
    private void dfs(int i,
                     int j) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(i, j + 1);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i - 1, j);
    }
    
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '1', '0', '0'},
                         {'0', '0', '0', '1', '1'}};
        Lc200_2 lc200_2 = new Lc200_2();
        int res = lc200_2.numIslands(grid);
        System.out.println("res = " + res);
    }
}
