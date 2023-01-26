package com.jacobcai.mdcc;

public class Lc1672 {
    public int maximumWealth(int[][] accounts) {
        int maxCnt = 0;
        for (int[] account : accounts) {
            int cnt = 0;
            for (int num : account)
                cnt += num;
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        Lc1672 lc1672 = new Lc1672();
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        int res = lc1672.maximumWealth(accounts);
        System.out.println("res = " + res);
    }
}
