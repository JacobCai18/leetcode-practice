package com.jacobcai.mmdc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idxs = new Integer[n]; // 需要包装类才能用其他数组进行定制排序
        for (int i = 0; i < n; i++) idxs[i] = i;
        Arrays.sort(idxs, (a, b) -> nums2[b] - nums2[a]);
        long sm = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            int n1 = nums1[idxs[i]];
            pq.offer(n1);
            sm += n1;
        }
        long res = sm * nums2[idxs[k - 1]];
        for (int i = k; i < n; i++) {
            int j = idxs[i];
            pq.offer(nums1[j]);
            sm += nums1[j];
            sm -= pq.poll();
            res = Math.max(res, sm * nums2[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Lc2542 lc2542 = new Lc2542();
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        long res = lc2542.maxScore(nums1, nums2, 3);
        System.out.println("res = " + res);
    }
}
