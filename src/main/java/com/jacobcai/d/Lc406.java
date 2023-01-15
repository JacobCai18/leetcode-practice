package com.jacobcai.d;

import java.util.Arrays;

public class Lc406 { // 57m
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int n = people.length;
        int[][] queue = new int[n][2];
        for (int i = 0; i < n; i++) {
            queue[i][0] = -1;
        }
        for (int[] person : people) {
            int pos = person[1] + 1;
            int p = 0, j = -1;
            while (p != pos) {
                j++;
                if (queue[j][0] == -1 || queue[j][0] == person[0]) {
                    p++;
                }
            }
            queue[j][0] = person[0]; // 传递值
            queue[j][1] = person[1];
        }
        return queue;
    }

    public static void main(String[] args) {
        Lc406 lc406 = new Lc406();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = lc406.reconstructQueue(people);
        System.out.println("res = " + Arrays.deepToString(res));
    }
}
