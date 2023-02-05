package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc229 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> ct = new HashMap<>();
        for (int x : nums)
            if (ct.containsKey(x))
                ct.put(x, ct.get(x) + 1);
            else
                ct.put(x, 1);
        List<Integer> res = new ArrayList<>();
        for (int x : ct.keySet())
            if (ct.get(x) > n / 3)
                res.add(x);
        return res;
    }

    public static void main(String[] args) {
        Lc229 lc229 = new Lc229();
        int[] nums = {3, 2, 3};
        List<Integer> res = lc229.majorityElement(nums);
        System.out.println("res = " + res);
    }
}
