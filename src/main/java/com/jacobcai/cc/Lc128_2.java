package com.jacobcai.cc;

import java.util.HashSet;
import java.util.Set;

public class Lc128_2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxSize = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currSize = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currSize++;
                }
                maxSize = Math.max(maxSize, currSize);
            }
        }
        return maxSize;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Lc128_2 lc128 = new Lc128_2();
        int res = lc128.longestConsecutive(nums);
        System.out.println("res = " + res);
    }
}
