package com.jacobcai.dcc;

public class Lc695 {
    /**
     * 岛屿矩阵
     */
    int[][] grid;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        // grid 中最大的岛屿面积
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfs(i,
                                       j);
                    res = Math.max(res,
                                   currArea);
                }
            }
        }
        return res;
    }
    
    /**
     * @param i 第 i 行
     * @param j 第 j 列
     *
     * @return 当前岛屿的面积
     */
    private int dfs(int i,
                    int j) {
        // 越界或非岛屿
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        // 当前岛屿的面积
        int count = 1;
        // 用完岛屿后沉岛
        grid[i][j] = 0;
        // 向四个方向记录各个方向岛屿的面积
        count += dfs(i,
                     j + 1);
        count += dfs(i + 1,
                     j);
        count += dfs(i,
                     j - 1);
        count += dfs(i - 1,
                     j);
        return count;
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
        Lc695 lc695 = new Lc695();
        int res = lc695.maxAreaOfIsland(grid);
        System.out.println("res = " + res);
    }
}
