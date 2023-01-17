package com.jacobcai.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc451 {
    public String frequencySort(String s) {
        // <char, cnt>
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = map.getOrDefault(c, 0) + 1;
            map.put(c, cnt);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (char c : list)
            sb.append(String.valueOf(c).repeat(map.get(c)));
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc451 lc451 = new Lc451();
        String s = "tree";
        String res = lc451.frequencySort(s);
        System.out.println("res = " + res);
    }
}
