package com.jacobcai.cc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc187_2 {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n < 11 || n > 10000) return new ArrayList<>();
        Set<String> res = new HashSet<>(), set = new HashSet<>();
        set.add(s.substring(0, 10));
        String tmp;
        for (int i = 1; i < n - 9; i++)
            if (!set.add(tmp = s.substring(i, i + 10)))
                res.add(tmp);
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        Lc187_2 lc187 = new Lc187_2();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = lc187.findRepeatedDnaSequences(s);
        System.out.println("res = " + res);
    }
}
