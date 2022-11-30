package com.jacobcai.dcccc;

public class Lc887 {
    /**
     * @param k 鸡蛋数
     * @param n 楼层数
     *
     * @return 确定楼层 f 确切的值的最小操作数
     */
    public int superEggDrop(int k,
                            int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            // 1 层楼
            dp[i][1] = 1;
        }
        for (int j = 1; j <= n; j++) {
            // 1 个鸡蛋
            dp[1][j] = j;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int le = 1, ri = j;
                while (le + 1 < ri) {
                    int x = (le + ri) >>> 1;
                    // 在 x 层抛，碎了
                    int y1 = dp[i - 1][x - 1];
                    // 在 x 层抛，没碎
                    int y2 = dp[i][j - x];
                    if (y1 == y2) {
                        le = ri = x;
                    } else if (y1 < y2) {
                        le = x;
                    } else {
                        ri = x;
                    }
                }
                dp[i][j] = 1 + Math.min(Math.max(dp[i - 1][le - 1],
                                                 dp[i][j - le]),
                                        Math.max(dp[i - 1][ri - 1],
                                                 dp[i][j - ri]));
            }
        }
        return dp[k][n];
    }
    
    public static void main(String[] args) {
        int k = 2;
        int n = 6;
        Lc887 lc887 = new Lc887();
        int res = lc887.superEggDrop(k,
                                     n);
        System.out.println("res = " + res);
    }
}
