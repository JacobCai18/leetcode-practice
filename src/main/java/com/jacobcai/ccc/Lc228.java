package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.List;

public class Lc228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            int le = i++;
            while (i < n && nums[i] == nums[i - 1] + 1) i++;
            int ri = i - 1;
            StringBuilder tmp = new StringBuilder(Integer.toString(nums[le]));
            if (le < ri) {
                tmp.append("->");
                tmp.append(nums[ri]);
            }
            res.add(tmp.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Lc228 lc228 = new Lc228();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> res = lc228.summaryRanges(nums);
        System.out.println("res = " + res);
    }
}
