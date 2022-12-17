package com.jacobcai.cc;

import java.util.HashMap;
import java.util.Map;

public class Lc128 {
    private int[] uf;
    private int[] sz;
    private int maxSize;
    
    public int longestConsecutive(int[] nums) {
        // k: nums[i], v: i
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        uf = new int[len];
        sz = new int[len];
        maxSize = len > 0 ? 1 : 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
                uf[i] = i;
                sz[i] = 1;
                if (map.containsKey(num - 1)) {
                    union(i, map.get(num - 1));
                }
                if (map.containsKey(num + 1)) {
                    union(i, map.get(num + 1));
                }
            }
        }
        return maxSize;
    }
    
    private void union(int p,
                       int q) {
        p = find(p);
        q = find(q);
        if (sz[p] < sz[q]) {
            int tmp = p;
            p = q;
            q = tmp;
        }
        uf[q] = p;
        sz[p] += sz[q];
        maxSize = Math.max(maxSize, sz[p]);
    }
    
    private int find(int p) {
        if (uf[p] != p) {
            uf[p] = find(uf[p]);
        }
        return uf[p];
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Lc128 lc128 = new Lc128();
        int res = lc128.longestConsecutive(nums);
        System.out.println("res = " + res);
    }
}
