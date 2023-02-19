package com.jacobcai.mdccc;

import java.util.PriorityQueue;

public class Lc1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2)
                return 0;
            return val1 < val2 ? 1 : -1;
        });
        for (int[] c : classes)  // offer all items to the pq
            pq.offer(new int[]{c[0], c[1]});
        for (int i = 0; i < extraStudents; i++) { // operate the root element and offer it back to the pq
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }
        double res = 0;
        int n = classes.length;
        for (int i = 0; i < n; i++) { // calculate the total ratio
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / n;
    }

    public static void main(String[] args) {
        Lc1792 lc1792 = new Lc1792();
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        double res = lc1792.maxAverageRatio(classes, 2);
        System.out.println("res = " + res);
    }
}
