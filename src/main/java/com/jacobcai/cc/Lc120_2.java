package com.jacobcai.cc;

import java.util.ArrayList;
import java.util.List;

public class Lc120_2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowLen = triangle.size();
        // dp[j]: 底部到当前位置的最小路径和
        // dp[j] = Math.min(dp[j], dp[j + 1]) + triangle[i][j]
        // 将dp[rowLen + 1]这一行都置为0
        int[] dp = new int[rowLen + 1];
        for (int i = rowLen - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
    
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(List.of(List.of(2),
                                                               List.of(3, 4),
                                                               List.of(6, 5, 7),
                                                               List.of(4, 1, 8, 3)));
        Lc120_2 lc120_2 = new Lc120_2();
        int res = lc120_2.minimumTotal(triangle);
        System.out.println("res = " + res);
    }
}
