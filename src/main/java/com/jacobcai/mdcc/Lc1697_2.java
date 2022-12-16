package com.jacobcai.mdcc;

import java.util.Arrays;
import java.util.Comparator;

public class Lc1697_2 {
    int[] uf;
    
    public boolean[] distanceLimitedPathsExist(int n,
                                               int[][] edgeList,
                                               int[][] queries) {
        Arrays.sort(edgeList,
                    Comparator.comparingInt(a -> a[2]));
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index,
                    Comparator.comparingInt(a -> queries[a][2]));
        
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        int k = 0;
        for (int i : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                union(edgeList[k][0],
                      edgeList[k][1]);
                k++;
            }
            res[i] = find(queries[i][0]) == find(queries[i][1]);
        }
        return res;
    }
    
    public int find(int p) {
        if (uf[p] != p) {
            uf[p] = find(uf[p]);
        }
        return uf[p];
    }
    
    public void union(int p,
                      int q) {
        p = find(p);
        q = find(q);
        uf[q] = p;
    }
    
    public static void main(String[] args) {
        int n = 3;
        int[][] edgeList = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] queries = {{0, 1, 2}, {0, 2, 5}};
        Lc1697_2 lc1697 = new Lc1697_2();
        boolean[] res = lc1697.distanceLimitedPathsExist(n,
                                                         edgeList,
                                                         queries);
        System.out.println("res = " + Arrays.toString(res));
    }
}
