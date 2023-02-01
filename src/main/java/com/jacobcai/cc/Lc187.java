package com.jacobcai.cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int m = 10, n = s.length(), x = 0, mask = (1 << 20) - 1;
        List<String> res = new ArrayList<>();
        if (n <= m) return res;
        Map<Character, Integer> c2i = new HashMap<>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        for (int i = 0; i < m - 1; i++) x = (x << 2) | c2i.get(s.charAt(i));
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i <= n - m; i++) {
            x = ((x << 2) | c2i.get(s.charAt(i + m - 1))) & mask;
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            if (mp.get(x) == 2) res.add(s.substring(i, i + m));
        }
        return res;
    }

    public static void main(String[] args) {
        Lc187 lc187 = new Lc187();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = lc187.findRepeatedDnaSequences(s);
        System.out.println("res = " + res);
    }
}
