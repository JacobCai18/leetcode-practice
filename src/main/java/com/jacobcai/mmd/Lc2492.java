package com.jacobcai.mmd;

public class Lc2492 {
    private int[] uf;

    private int find(int p) {
        if (uf[p] == p) return p;
        return uf[p] = find(uf[p]);
    }

    private void merge(int p, int q) {
        uf[find(q)] = find(p);
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int minScore(int n, int[][] roads) {
        int min = Integer.MAX_VALUE;
        uf = new int[n + 1];
        for (int i = 0; i <= n; i++) uf[i] = i;
        for (int[] r : roads) merge(r[0], r[1]);
        for (int[] r : roads)
            if (isConnected(r[0], 1))
                min = Math.min(min, r[2]);
        return min;
    }

    public static void main(String[] args) {
        Lc2492 lc2492 = new Lc2492();
        int[][] roads = {{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        int res = lc2492.minScore(4, roads);
        System.out.println("res = " + res);
    }
}
