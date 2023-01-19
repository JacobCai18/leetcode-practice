package com.jacobcai.mdcccc;

import java.util.*;

public class Lc1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k]; // <i, ans[i]> = <user active minutes, cnt>
        Map<Integer, Set<Integer>> map = new HashMap<>(); // <id, unique user active minute>
        for (int[] log : logs) {
            map.putIfAbsent(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        for (Set<Integer> v : map.values())
            ans[v.size() - 1]++;
        return ans;
    }

    public static void main(String[] args) {
        int[][] logs = {{1, 1}, {2, 2}, {2, 3}};
        Lc1817 lc1817 = new Lc1817();
        int[] res = lc1817.findingUsersActiveMinutes(logs, 4);
        System.out.println("res = " + Arrays.toString(res));
    }
}
