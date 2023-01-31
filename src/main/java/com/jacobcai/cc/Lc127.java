package com.jacobcai.cc;

import java.util.*;

public class Lc127 {
    private int bfs(Set<String> st, Queue<String> q, Map<String, Integer> mp1, Map<String, Integer> mp2) {
        int m = q.size();
        while (m-- > 0) {
            String s = q.poll();
            int steps = mp1.get(s); // 到当前字符串的步数
            for (int i = 0; i < s.length(); i++) { // 第几位
                for (char j = 'a'; j <= 'z'; j++) { // 每一位上任意字母
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, j);
                    String next = sb.toString(); // 下一层的字符串
                    if (!st.contains(next) || mp1.containsKey(next)) continue; // 此路不可走或已走过
                    if (mp2.containsKey(next)) return steps + 1 + mp2.get(next); // 另一边已走过
                    q.offer(next);
                    mp1.put(next, steps + 1);
                }
            }
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList); // 可走的路
        if (!st.contains(endWord)) return 0;
        Queue<String> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        Map<String, Integer> mp1 = new HashMap<>(), mp2 = new HashMap<>(); // <到达的字符串, 需要几步>
        q1.offer(beginWord);
        mp1.put(beginWord, 0);
        q2.offer(endWord);
        mp2.put(endWord, 0);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int ct = q1.size() <= q2.size() ? bfs(st, q1, mp1, mp2) : bfs(st, q2, mp2, mp1);
            if (ct != -1) return ct + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Lc127 lc127 = new Lc127();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        int res = lc127.ladderLength(beginWord, endWord, wordList);
        System.out.println("res = " + res);
    }
}
