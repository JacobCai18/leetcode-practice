package com.jacobcai.mmdc;

import java.util.Arrays;

public class Lc2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
