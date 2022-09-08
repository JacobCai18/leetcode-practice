package com.jacobcai.cc;

import java.util.ArrayList;
import java.util.List;

public class Lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(List.of(List.of(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int numRows = 5;
        Lc118 lc118 = new Lc118();
        List<List<Integer>> res = lc118.generate(numRows);
        System.out.println("res = " + res);
    }
}
