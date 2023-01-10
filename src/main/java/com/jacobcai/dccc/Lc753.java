package com.jacobcai.dccc;

import java.util.HashSet;
import java.util.Set;

public class Lc753 {
    private final Set<Integer> seen = new HashSet<>();
    private final StringBuilder sb = new StringBuilder();
    private int highest;
    private int k;
    
    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);
        this.k = k;
        dfs(0);
        sb.append("0".repeat(n - 1));
        return sb.toString();
    }
    
    private void dfs(int node) {
        for (int x = 0; x < k; x++) {
            int nei = node * 10 + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei % highest);
                sb.append(x);
            }
        }
    }
    
    public static void main(String[] args) {
        Lc753 lc753 = new Lc753();
        String res = lc753.crackSafe(2, 2);
        System.out.println("res = " + res);
    }
}
