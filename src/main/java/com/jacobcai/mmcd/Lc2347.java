package com.jacobcai.mmcd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc2347 {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> suitsSet = new HashSet<>();
        for (char suit : suits)
            suitsSet.add(suit);
        if (suitsSet.size() == 1)
            return "Flush";
        Map<Integer, Integer> h = new HashMap<>();
        for (int rank : ranks)
            h.put(rank, h.getOrDefault(rank, 0) + 1);
        if (h.size() == 5)
            return "High Card";
        for (Map.Entry<Integer, Integer> entry : h.entrySet())
            if (entry.getValue() > 2)
                return "Three of a Kind";
        return "Pair";
    }

    public static void main(String[] args) {
        Lc2347 lc2347 = new Lc2347();
        int[] ranks = {13, 2, 3, 1, 9};
        char[] suits = {'a', 'a', 'a', 'a', 'a'};
        String res = lc2347.bestHand(ranks, suits);
        System.out.println("res = " + res);
    }
}
