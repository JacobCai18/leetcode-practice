package com.jacobcai.mdcc;

import java.util.Arrays;

public class Lc1691 {
    public int maxHeight(int[][] cuboids) {
        int len = cuboids.length;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        // 保证枚举关系的拓扑性：保证所有满足可堆叠在第 i 个长方体之上的长方体排在 i 之前
        Arrays.sort(cuboids,
                    (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        int res = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int currHeight = cuboids[i][2];
            dp[i] = currHeight;
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i],
                                     dp[j] + currHeight);
                }
            }
            res = Math.max(res,
                           dp[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] cuboids = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        Lc1691 lc1691 = new Lc1691();
        int res = lc1691.maxHeight(cuboids);
        System.out.println("res = " + res);
    }
}
