package com.jacobcai.mc;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lc1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a); // 默认最小堆
        for (int s : stones) q.offer(s);
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if (a > b) q.offer(a - b);
        }
        return q.isEmpty() ? 0 : q.peek();
    }

    public static void main(String[] args) {
        Lc1046 lc1046 = new Lc1046();
        int[] stones = {2, 7, 4, 1, 8, 1};
        int res = lc1046.lastStoneWeight(stones);
        System.out.println("res = " + res);
    }
}
