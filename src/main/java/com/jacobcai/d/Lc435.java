package com.jacobcai.d;

import java.util.Arrays;

public class Lc435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,
                    (o1, o2) -> o1[1] - o2[1]);
        int len = intervals.length;
        int ri = intervals[0][1];
        // 保留的区间数
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (ri <= intervals[i][0]) {
                ri = intervals[i][1];
                count++;
            }
        }
        return len - count;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Lc435 lc435 = new Lc435();
        int res = lc435.eraseOverlapIntervals(intervals);
        System.out.println("res = " + res);
    }
}
