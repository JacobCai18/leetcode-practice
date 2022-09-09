package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.List;

public class Lc279_4 {
    public int numSquares(int n) {
        int a;
        // 预处理出所有可能用到的「完全平方数」
        List<Integer> list = new ArrayList<>();
        a = 1;
        while (a * a <= n) {
            list.add(a * a);
            a++;
        }
        // dp[i][j]: 前 i+1 个完全平方数，凑出 j 所使用到的最少个数
        // dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-k*num]+k)
        // dp[j] = Math.min(dp[j], dp[j-num]+1)
        int[] dp = new int[n + 1];
        // 处理第一个完全平方数的情况
        for (int j = 0; j <= n; j++) {
            int num = list.get(0);
            int k = j / num;
            if (k * num == j) { // 只有第一个完全平方数的整数倍的才能凑出j
                dp[j] = k;
            } else { // 其余则为无效值
                dp[j] = -1;
            }
        }
        // 处理剩余完全平方数的情况
        for (int i = 1; i < list.size(); i++) {
            int num = list.get(i);
            for (int j = num; j <= n; j++) {
                // 能够选择 num 的前提是剩余的数字 j - num 也能被凑出
                if (dp[j - num] != -1) {
                    dp[j] = Math.min(dp[j],
                                     dp[j - num] + 1);
                }
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 12;
        Lc279_4 lc279_4 = new Lc279_4();
        int res = lc279_4.numSquares(n);
        System.out.println("res = " + res);
    }
}
