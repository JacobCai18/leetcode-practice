package com.jacobcai.dcccc;

public class Lc887_4 {
    public int superEggDrop(int k,
                            int n) {
        // dp[i][j]: 操作数 i，鸡蛋数 j 能最多确定的楼层数
        int[] dp = new int[k + 1];
        for (int j = 1; j <= k; j++) {
            // 1 次操作
            dp[j] = 1;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[j] = 1 + dp[j - 1] + dp[j];
            }
            if (dp[k] >= n) {
                res = i;
                break;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int k = 3;
        int n = 2;
        Lc887_4 lc887_4 = new Lc887_4();
        int res = lc887_4.superEggDrop(k,
                                       n);
        System.out.println("res = " + res);
    }
}
