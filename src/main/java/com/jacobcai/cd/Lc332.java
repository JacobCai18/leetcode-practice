package com.jacobcai.cd;

import java.util.*;

public class Lc332 {
    private final Map<String, PriorityQueue<String>> map = new HashMap<>();
    private final List<String> itinerary = new ArrayList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src))
                map.put(src, new PriorityQueue<>());
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }
    
    private void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String tmp = map.get(cur).poll();
            dfs(tmp);
        }
        itinerary.add(cur);
    }
    
    public static void main(String[] args) {
        String[][] t = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        List<List<String>> tickets = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            tickets.add(new ArrayList<>());
            for (int j = 0; j < 2; j++)
                tickets.get(i).add(t[i][j]);
        }
        Lc332 lc332 = new Lc332();
        List<String> res = lc332.findItinerary(tickets);
        System.out.println("res = " + res);
    }
}
