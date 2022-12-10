package com.jacobcai.mdcc;

import java.util.Arrays;

public class Lc1691_2 {
    public int maxHeight(int[][] cuboids) {
        int len = cuboids.length;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids,
                    (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        
        int[] memo = new int[len];
        Arrays.fill(memo,
                    -1);
        return dfs(cuboids,
                   memo,
                   -1,
                   0);
    }
    
    public int dfs(int[][] cuboids,
                   int[] memo,
                   int top,
                   int index) {
        if (index == cuboids.length) {
            return 0;
        }
        if (top != -1 && memo[top] != -1) {
            return memo[top];
        }
        int height = dfs(cuboids,
                         memo,
                         top,
                         index + 1);
        if (top == -1 || check(cuboids[top],
                               cuboids[index])) {
            height = Math.max(height,
                              cuboids[index][2] + dfs(cuboids,
                                                      memo,
                                                      index,
                                                      index + 1));
        }
        if (top != -1) {
            memo[top] = height;
        }
        return height;
    }
    
    public boolean check(int[] a,
                         int[] b) {
        return a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2];
    }
    
    public static void main(String[] args) {
        int[][] cuboids = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        Lc1691_2 lc1691_2 = new Lc1691_2();
        int res = lc1691_2.maxHeight(cuboids);
        System.out.println("res = " + res);
    }
}
