package com.jacobcai.dcccc;

public class Lc887_3 {
    int[][] dp;
    
    /**
     * @param k 鸡蛋数
     * @param n 楼层数
     *
     * @return 确定楼层 f 确切的值的最小操作数
     */
    public int superEggDrop(int k,
                            int n) {
        dp = new int[2][n + 1];
        // 1 层楼
        dp[0][1] = 1;
        for (int j = 0; j <= n; ++j) {
            // 1 个鸡蛋
            dp[1][j] = j;
        }
        for (int i = 2; i <= k; ++i) {
            int x = 1;
            for (int j = 2; j <= n; ++j) {
                while (x < j && getMax(i, j, x) > getMax(i, j, x + 1)) {
                    x++;
                }
                dp[i & 1][j] = 1 + getMax(i, j, x);
            }
        }
        return dp[k & 1][n];
    }
    
    /**
     * y1(x) = dp[(i - 1) & 1][x - 1] 图像单调递增，
     * y2(x) = dp[i & 1][j - x] 图像单调递减，
     * Y(x) = max(y1(x), y2(x))，min(Y(x)) 在 y1(x) 和 y2(x) 图像交点取得。
     * 随着 j 增加，y1(x) 图像不变，y2(x) 图像上移，y1(x) 和 y2(x) 图像交点右移，
     * j 增加后想获得新 min(Y(x))，需要在取得上一个 min(Y(x)) 的 x 的右方尝试。
     *
     * @param i 当前鸡蛋数
     * @param j 当前楼层数
     * @param x 本次抛鸡蛋的楼层
     *
     * @return 保证能确定楼层 f 确切值的操作数
     */
    private int getMax(int i,
                       int j,
                       int x) {
        return Math.max(dp[(i - 1) & 1][x - 1],
                        dp[i & 1][j - x]);
    }
    
    public static void main(String[] args) {
        int k = 3;
        int n = 14;
        Lc887_3 lc887_3 = new Lc887_3();
        int res = lc887_3.superEggDrop(k,
                                       n);
        System.out.println("res = " + res);
    }
}
