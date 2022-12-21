package com.jacobcai.dc;

public class Lc547 {
    private int cnt;
    private int[] uf;
    
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        cnt = len;
        uf = new int[len];
        for (int i = 0; i < len; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return cnt;
    }
    
    private void union(int p,
                       int q) {
        p = find(p);
        q = find(q);
        if (p == q) {
            return;
        }
        uf[q] = p;
        cnt--;
    }
    
    private int find(int p) {
        if (uf[p] != p) {
            uf[p] = find(uf[p]);
        }
        return uf[p];
    }
    
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Lc547 lc547 = new Lc547();
        int res = lc547.findCircleNum(isConnected);
        System.out.println("res = " + res);
    }
}
