package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,
                    (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        int le, ri;
        le = intervals[0][0];
        ri = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curLe, curRi;
            curRi = intervals[i][1];
            if (ri < (curLe = intervals[i][0])) {
                list.add(new int[]{le, ri});
                le = curLe;
                ri = curRi;
            } else {
                ri = Math.max(ri,
                              curRi);
            }
        }
        list.add(new int[]{le, ri});
        return list.toArray(new int[0][]);
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Lc56 lc56 = new Lc56();
        int[][] res = lc56.merge(intervals);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
