package com.jacobcai.dccc;

import java.util.*;

public class Lc752 {
    private final Set<String> set = new HashSet<>();

    private int update(Queue<String> q, Map<String, Integer> mpThis, Map<String, Integer> mpAnother) {
        int n = q.size();
        while (n-- > 0) {
            String cur = q.poll();
            char[] curca = cur.toCharArray();
            for (int i = 0; i < 4; i++) { // 第几位
                for (int j = -1; j <= 1; j++) { // 往上还是往下
                    if (j == 0) continue;
                    char[] nextca = curca.clone();
                    nextca[i] = (char) ('0' + (curca[i] - '0' + j + 10) % 10);
                    String next = String.valueOf(nextca); // 下一层的字符串
                    if (set.contains(next) || mpThis.containsKey(next)) continue; // 死路或已访问
                    if (mpAnother.containsKey(next)) { // 另一边已访问
                        return mpThis.get(cur) + 1 + mpAnother.get(next);
                    } else { // 另一边未访问
                        q.offer(next);
                        mpThis.put(next, mpThis.get(cur) + 1);
                    }
                }
            }
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) {
        String begin = "0000";
        if (begin.equals(target)) return 0;
        set.addAll(Arrays.asList(deadends));
        if (set.contains(begin)) return -1;
        Queue<String> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        Map<String, Integer> mp1 = new HashMap<>(), mp2 = new HashMap<>(); // <到达的字符串, 几步到达>
        q1.offer(begin);
        mp1.put(begin, 0);
        q2.offer(target);
        mp2.put(target, 0);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int ct;
            if (q1.size() <= q2.size()) {
                ct = update(q1, mp1, mp2);
            } else {
                ct = update(q2, mp2, mp1);
            }
            if (ct != -1) return ct;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc752 lc752 = new Lc752();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int res = lc752.openLock(deadends, target);
        System.out.println("res = " + res);
    }
}
