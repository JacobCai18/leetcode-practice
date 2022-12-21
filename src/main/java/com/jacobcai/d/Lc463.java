package com.jacobcai.d;

public class Lc463 {
    public int islandPerimeter(int[][] grid) {
        int rowLen, colLen;
        rowLen = grid.length;
        colLen = grid[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= rowLen || ty < 0 || ty >= colLen || grid[tx][ty] == 0) {
                            cnt++;
                        }
                    }
                    res += cnt;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        Lc463 lc463 = new Lc463();
        int res = lc463.islandPerimeter(grid);
        System.out.println("res = " + res);
    }
}
