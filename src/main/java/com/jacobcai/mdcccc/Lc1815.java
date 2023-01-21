package com.jacobcai.mdcccc;

import java.util.HashMap;
import java.util.Map;

public class Lc1815 {
    static final int K_WIDTH = 5;
    static final int K_WIDTH_MASK = (1 << K_WIDTH) - 1;

    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] cnt = new int[batchSize];
        for (int x : groups) {
            ++cnt[x % batchSize];
        }

        long start = 0;
        for (int i = batchSize - 1; i >= 1; --i) {
            start = (start << K_WIDTH) | cnt[i];
        }

        Map<Long, Integer> memo = new HashMap<>();

        return dfs(memo, batchSize, start) + cnt[0];
    }

    public int dfs(Map<Long, Integer> memo, int batchSize, long mask) {
        if (mask == 0) {
            return 0;
        }

        if (!memo.containsKey(mask)) {
            long total = 0;
            for (int i = 1; i < batchSize; ++i) {
                long amount = ((mask >> ((i - 1) * K_WIDTH)) & K_WIDTH_MASK);
                total += i * amount;
            }

            int best = 0;
            for (int i = 1; i < batchSize; ++i) {
                long amount = ((mask >> ((i - 1) * K_WIDTH)) & K_WIDTH_MASK);
                if (amount > 0) {
                    int result = dfs(memo, batchSize, mask - (1L << ((i - 1) * K_WIDTH)));
                    if ((total - i) % batchSize == 0) {
                        ++result;
                    }
                    best = Math.max(best, result);
                }
            }

            memo.put(mask, best);
        }
        return memo.get(mask);
    }

    public static void main(String[] args) {
        Lc1815 lc1815 = new Lc1815();
        int[] groups = {1, 2, 3, 4, 5, 6};
        int res = lc1815.maxHappyGroups(3, groups);
        System.out.println("res = " + res);
    }
}
