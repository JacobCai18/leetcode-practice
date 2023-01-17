package com.jacobcai.d;

import java.util.HashMap;
import java.util.Map;

public class Lc451_2 {
    public String frequencySort(String s) {
        // <char, cnt>
        Map<Character, Integer> map = new HashMap<>();
        int maxCnt = 0;
        for (char c : s.toCharArray()) {
            int cnt = map.getOrDefault(c, 0) + 1;
            map.put(c, cnt);
            maxCnt = Math.max(maxCnt, cnt);
        }
        StringBuilder[] buckets = new StringBuilder[maxCnt + 1];
        for (int i = 0; i <= maxCnt; i++)
            buckets[i] = new StringBuilder();
        for (Map.Entry<Character, Integer> e : map.entrySet())
            buckets[e.getValue()].append(e.getKey());
        StringBuilder sb = new StringBuilder();
        for (int i = maxCnt; i > 0; i--) {
            StringBuilder bucket = buckets[i];
            for (int j = 0; j < bucket.length(); j++)
                sb.append(String.valueOf(bucket.charAt(j)).repeat(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc451_2 lc451_2 = new Lc451_2();
        String s = "tree";
        String res = lc451_2.frequencySort(s);
        System.out.println("res = " + res);
    }
}
