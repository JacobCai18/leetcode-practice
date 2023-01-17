package com.jacobcai.cc;

import java.util.Arrays;

public class Lc174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        // dp[i][j] = minIn
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[n], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) dp[i][m] = Integer.MAX_VALUE;
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i > -1; --i) {
            for (int j = m - 1; j > -1; --j) {
                int minOut = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minOut - dungeon[i][j], 1); // in + dun = out
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Lc174 lc174 = new Lc174();
        int[][] dungeon = {{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        int res = lc174.calculateMinimumHP(dungeon);
        System.out.println("res = " + res);
    }
}
