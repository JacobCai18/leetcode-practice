package com.jacobcai.dcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc692 {
    public List<String> topKFrequent(String[] words,
                                     int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            res.add(entry.getKey());
        }
        res.sort((word1, word2) -> cnt.get(word1) == cnt.get(word2) ?
                                   word1.compareTo(word2) :
                                   cnt.get(word2) - cnt.get(word1));
        return res.subList(0, k);
    }
    
    public static void main(String[] args) {
        String[] words = {"i", "love", "coding", "i", "love", "eating"};
        int k = 2;
        Lc692 lc692 = new Lc692();
        List<String> res = lc692.topKFrequent(words,
                                              k);
        System.out.println("res = " + res);
    }
}
