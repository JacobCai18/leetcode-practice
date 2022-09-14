package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc57 {
    public int[][] insert(int[][] intervals,
                          int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean flag = false;
        int le, ri;
        le = newInterval[0];
        ri = newInterval[1];
        for (int[] interval : intervals) {
            int curLe = interval[0];
            int curRi = interval[1];
            if (curRi < le) {
                list.add(interval);
            } else if (ri < curLe) {
                if (!flag) {
                    list.add(new int[]{le, ri});
                    flag = true;
                }
                list.add(interval);
            } else {
                le = Math.min(le,
                              curLe);
                ri = Math.max(ri,
                              curRi);
            }
        }
        if (!flag) {
            list.add(new int[]{le, ri});
        }
        return list.toArray(new int[0][]);
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {11, 14}};
        int[] newInterval = {7, 8};
        Lc57 lc57 = new Lc57();
        int[][] res = lc57.insert(intervals,
                                  newInterval);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
