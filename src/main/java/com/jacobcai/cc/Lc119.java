package com.jacobcai.cc;

import java.util.ArrayList;
import java.util.List;

public class Lc119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // 滚动数组，倒着遍历，第j - 1项不会被覆盖
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j,
                        res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int rowIndex = 5;
        Lc119 lc119 = new Lc119();
        List<Integer> res = lc119.getRow(rowIndex);
        System.out.println("res = " + res);
    }
}
