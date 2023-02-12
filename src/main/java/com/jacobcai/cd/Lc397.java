package com.jacobcai.cd;

import java.util.HashMap;
import java.util.Map;

public class Lc397 {
    private final Map<Long, Integer> map = new HashMap<>();

    private int dfs(long n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1), dfs(n - 1));
        map.put(n, ++ans);
        return ans;
    }

    public int integerReplacement(int n) {
        return dfs(n);
    }

    public static void main(String[] args) {
        Lc397 lc397 = new Lc397();
        int res = lc397.integerReplacement(9);
        System.out.println("res = " + res);
    }
}
