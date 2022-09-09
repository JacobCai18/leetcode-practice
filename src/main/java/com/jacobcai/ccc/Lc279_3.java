package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.List;

public class Lc279_3 {
    public int numSquares(int n) {
        int a, len;
        // 预处理出所有可能用到的「完全平方数」
        List<Integer> list = new ArrayList<>();
        a = 1;
        while (a * a <= n) {
            list.add(a * a);
            a++;
        }
        // dp[i][j]: 前 i+1 个完全平方数，凑出 j 所使用到的最少个数
        // dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j - k * num] + k)
        int[][] dp = new int[(len = list.size())][n + 1];
        // 处理第一个完全平方数的情况
        for (int j = 0; j <= n; j++) {
            int num = list.get(0);
            int k = j / num;
            if (k * num == j) { // 只有第一个完全平方数的整数倍的才能凑出j
                dp[0][j] = k;
            } else { // 其余则为无效值
                dp[0][j] = -1;
            }
        }
        // 处理剩余完全平方数的情况
        for (int i = 1; i < len; i++) {
            int num = list.get(i);
            for (int j = 0; j <= n; j++) {
                // 不选第 i+1 个完全平方数
                dp[i][j] = dp[i - 1][j];
                // 选 k 次第 i+1 个完全平方数
                for (int k = 1; k * num <= j; k++) {
                    // 能够选择 k 个 num 的前提是剩余的数字 j - k * num 也能被凑出
                    if (dp[i - 1][j - k * num] != -1) {
                        dp[i][j] = Math.min(dp[i][j],
                                            dp[i - 1][j - k * num] + k);
                    }
                }
                
            }
        }
        return dp[len - 1][n];
    }
    
    public static void main(String[] args) {
        int n = 12;
        Lc279_3 lc279_3 = new Lc279_3();
        int res = lc279_3.numSquares(n);
        System.out.println("res = " + res);
    }
}
