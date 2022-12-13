package com.jacobcai.c;

import java.util.ArrayList;
import java.util.List;

public class Lc89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int m = res.size();
            for (int j = m - 1; j >= 0; j--) {
                res.add(res.get(j) | (1 << (i - 1)));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Lc89 lc89 = new Lc89();
        List<Integer> res = lc89.grayCode(4);
        System.out.println("res = " + res);
    }
}
