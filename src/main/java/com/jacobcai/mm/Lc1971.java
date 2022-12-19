package com.jacobcai.mm;

public class Lc1971 {
    private int[] uf;
    
    public boolean validPath(int n,
                             int[][] edges,
                             int source,
                             int destination) {
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0],
                  edge[1]);
        }
        return find(source) == find(destination);
    }
    
    private void union(int p,
                       int q) {
        p = find(p);
        q = find(q);
        uf[q] = p;
    }
    
    private int find(int p) {
        if (uf[p] != p) {
            uf[p] = find(uf[p]);
        }
        return uf[p];
    }
    
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        Lc1971 lc1971 = new Lc1971();
        boolean res = lc1971.validPath(n,
                                       edges,
                                       source,
                                       destination);
        System.out.println("res = " + res);
    }
}
