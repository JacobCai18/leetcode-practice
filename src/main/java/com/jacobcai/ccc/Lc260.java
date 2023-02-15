package com.jacobcai.ccc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc260 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet())
            if (entry.getValue() == 1)
                res[i++] = entry.getKey();
        return res;
    }

    public static void main(String[] args) {
        Lc260 lc260 = new Lc260();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] res = lc260.singleNumber(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
