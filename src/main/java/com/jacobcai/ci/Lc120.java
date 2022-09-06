package com.jacobcai.ci;

import java.util.ArrayList;
import java.util.List;

public class Lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowLen = triangle.size();
        // dp[i][j]: 顶部到当前位置的最小路径和
        // dp[j] = Math.min(dp[j-1], dp[j]) + triangle[i][j]
        int[] dp = new int[rowLen];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < rowLen; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j >= 1; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int res = dp[0];
        for (int j = 1; j < rowLen; j++) {
            res = Math.min(res, dp[j]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(List.of(List.of(2),
                                                               List.of(3, 4),
                                                               List.of(6, 5, 7),
                                                               List.of(4, 1, 8, 3)));
        Lc120 lc120 = new Lc120();
        int res = lc120.minimumTotal(triangle);
        System.out.println("res = " + res);
    }
}
