package com.jacobcai.mdcc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc1687 {
    public int boxDelivering(int[][] boxes,
                             int portsCount,
                             int maxBoxes,
                             int maxWeight) {
        int len = boxes.length;
        int[] p = new int[len + 1];
        int[] w = new int[len + 1];
        int[] neg = new int[len + 1];
        long[] W = new long[len + 1];
        for (int i = 1; i <= len; ++i) {
            p[i] = boxes[i - 1][0];
            w[i] = boxes[i - 1][1];
            if (i > 1) {
                neg[i] = neg[i - 1] + (p[i - 1] != p[i] ?
                                       1 :
                                       0);
            }
            W[i] = W[i - 1] + w[i];
        }
        Deque<Integer> opt = new ArrayDeque<>();
        opt.addLast(0);
        int[] f = new int[len + 1];
        int[] g = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            while (i - opt.getFirst() > maxBoxes || W[i] - W[opt.getFirst()] > maxWeight) {
                opt.removeFirst();
            }
            f[i] = g[opt.getFirst()] + neg[i] + 2;
            if (i != len) {
                g[i] = f[i] - neg[i + 1];
                while (!opt.isEmpty() && g[i] <= g[opt.getLast()]) {
                    opt.removeLast();
                }
                opt.addLast(i);
            }
        }
        return f[len];
    }
    
    public static void main(String[] args) {
        int[][] boxes = {{1, 2}, {3, 3}, {3, 1}, {3, 1}, {2, 4}};
        int portsCount = 3;
        int maxBoxes = 3;
        int maxWeight = 6;
        Lc1687 lc1687 = new Lc1687();
        int res = lc1687.boxDelivering(boxes,
                                       portsCount,
                                       maxBoxes,
                                       maxWeight);
        System.out.println("res = " + res);
    }
}
