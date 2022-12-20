package com.jacobcai.cd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lc349 {
    public int[] intersection(int[] nums1,
                              int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                resSet.add(num);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int num : resSet) {
            res[i++] = num;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Lc349 lc349 = new Lc349();
        int[] res = lc349.intersection(nums1,
                                       nums2);
        System.out.println("res = " + Arrays.toString(res));
    }
}
