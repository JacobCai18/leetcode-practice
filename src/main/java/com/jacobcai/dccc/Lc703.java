package com.jacobcai.dccc;

import java.util.PriorityQueue;

public class Lc703 {
    private final PriorityQueue<Integer> pq;
    private final int k;

    public Lc703(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int x : nums) add(x);
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Lc703 kthLargest = new Lc703(2, new int[]{0});
        kthLargest.add(-1);
        kthLargest.add(1);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(3);
    }
}
