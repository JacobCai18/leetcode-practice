package com.jacobcai.d;

import java.util.*;

public class Lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i > -1; i--) {
            int x = nums2[i];
            while (!stk.isEmpty() && x >= stk.getFirst())
                stk.removeFirst();
            map.put(x, stk.isEmpty() ? -1 : stk.getFirst());
            stk.addFirst(x);
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++)
            res[i] = map.get(nums1[i]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Lc496 lc496 = new Lc496();
        int[] res = lc496.nextGreaterElement(nums1, nums2);
        System.out.println("res = " + Arrays.toString(res));
    }
}
