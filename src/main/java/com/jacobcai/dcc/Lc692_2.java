package com.jacobcai.dcc;

import java.util.*;

public class Lc692_2 {
    public List<String> topKFrequent(String[] words,
                                     int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word,
                    cnt.getOrDefault(word,
                                     0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue()
                                                                                         .equals(e2.getValue()) ?
                                                                                       e2.getKey()
                                                                                         .compareTo(e1.getKey()) :
                                                                                       e1.getValue() - e2.getValue());
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()
                      .getKey());
        }
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        String[] words = {"i", "love", "coding", "i", "love", "eating"};
        int k = 2;
        Lc692_2 lc692 = new Lc692_2();
        List<String> res = lc692.topKFrequent(words,
                                              k);
        System.out.println("res = " + res);
    }
}
