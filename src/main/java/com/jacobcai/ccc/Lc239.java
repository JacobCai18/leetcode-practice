package com.jacobcai.ccc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc239 {
    public int[] maxSlidingWindow(int[] nums,
                                  int k) {
        int len = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                if (deque.getFirst() == i - k) {
                    deque.removeFirst();
                }
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Lc239 lc239 = new Lc239();
        int[] res = lc239.maxSlidingWindow(nums,
                                           k);
        System.out.println("res = " + Arrays.toString(res));
    }
}
