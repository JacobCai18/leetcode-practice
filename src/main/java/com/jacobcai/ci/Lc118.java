package com.jacobcai.ci;

import java.util.ArrayList;
import java.util.List;

public class Lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
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
