package com.jacobcai.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc18 {
    public List<List<Integer>> fourSum(int[] nums,
                                       int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            if ((long) nums[a] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if ((long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if ((long) nums[a] + nums[b] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int c = b + 1, d = len - 1;
                while (c < d) {
                    int curr = nums[a] + nums[b] + nums[c] + nums[d];
                    if (curr == target) {
                        res.add(Arrays.asList(nums[a],
                                              nums[b],
                                              nums[c],
                                              nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        c++;
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        d--;
                    } else if (curr < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        Lc18 lc18 = new Lc18();
        List<List<Integer>> res = lc18.fourSum(nums,
                                               target);
        System.out.println(res);
    }
}
