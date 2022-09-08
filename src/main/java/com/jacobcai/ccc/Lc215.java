package com.jacobcai.ccc;

import java.util.PriorityQueue;

public class Lc215 {
    public int findKthLargest(int[] nums,
                              int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Lc215 lc215 = new Lc215();
        int res = lc215.findKthLargest(nums,
                                       k);
        System.out.println("res = " + res);
    }
}
