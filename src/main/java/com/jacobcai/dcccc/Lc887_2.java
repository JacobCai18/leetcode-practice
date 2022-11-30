package com.jacobcai.dcccc;

public class Lc887_2 {
    /**
     * @param k 鸡蛋数
     * @param n 楼层数
     *
     * @return 确定楼层 f 确切的值的最小操作数
     */
    public int superEggDrop(int k,
                            int n) {
        int[][] dp = new int[2][n + 1];
        // 1 层楼
        dp[0][1] = 1;
        for (int j = 1; j <= n; j++) {
            // 1 个鸡蛋
            dp[1][j] = j;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                // 用二分确定在哪两层相邻的楼抛鸡蛋会获得确定楼层 f 确切值的最小操作数
                int le = 1, ri = j;
                while (le + 1 < ri) {
                    int x = (le + ri) >>> 1;
                    // 在 x 层抛，碎了
                    int y1 = dp[(i - 1) & 1][x - 1];
                    // 在 x 层抛，没碎
                    int y2 = dp[i & 1][j - x];
                    if (y1 == y2) {
                        le = ri = x;
                    } else if (y1 < y2) {
                        le = x;
                    } else {
                        ri = x;
                    }
                }
                // Math.max(dp[i - 1][x - 1], dp[i][j - x]): 在 x 层抛鸡蛋保证能确定楼层 f 确切值的操作数
                // 在 [1, j] 层分别抛鸡蛋，保证能确定楼层 f 确切值的前提下，选取这些层中最小的操作数
                // 由于已经二分查找，只需在 le 和 ri 这相邻的两层中选取最小的操作数
                dp[i & 1][j] = 1 + Math.min(Math.max(dp[(i - 1) & 1][le - 1],
                                                     dp[i & 1][j - le]),
                                            Math.max(dp[(i - 1) & 1][ri - 1],
                                                     dp[i & 1][j - ri]));
            }
        }
        return dp[k & 1][n];
    }
    
    public static void main(String[] args) {
        int k = 3;
        int n = 14;
        Lc887_2 lc887_2 = new Lc887_2();
        int res = lc887_2.superEggDrop(k,
                                       n);
        System.out.println("res = " + res);
    }
}
