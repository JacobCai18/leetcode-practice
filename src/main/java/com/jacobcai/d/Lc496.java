package com.jacobcai.d;

import java.util.*;

public class Lc496 {
    public int[] nextGreaterElement(int[] nums1,
                                    int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!deque.isEmpty() && num >= deque.getFirst()) {
                deque.removeFirst();
            }
            map.put(num,
                    deque.isEmpty() ?
                    -1 :
                    deque.getFirst());
            deque.addFirst(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Lc496 lc496 = new Lc496();
        int[] res = lc496.nextGreaterElement(nums1,
                                             nums2);
        System.out.println("res = " + Arrays.toString(res));
    }
}
