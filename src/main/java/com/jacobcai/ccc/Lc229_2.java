package com.jacobcai.ccc;

import java.util.ArrayList;
import java.util.List;

public class Lc229_2 {
    public List<Integer> majorityElement(int[] nums) {
        int e1 = 0, e2 = 0, vote1 = 0, vote2 = 0;
        for (int x : nums) {
            if (vote1 > 0 && x == e1) { //如果该元素为第一个元素，则计数加1
                vote1++;
            } else if (vote2 > 0 && x == e2) { //如果该元素为第二个元素，则计数加1
                vote2++;
            } else if (vote1 == 0) { // 选择第一个元素
                e1 = x;
                vote1++;
            } else if (vote2 == 0) { // 选择第二个元素
                e2 = x;
                vote2++;
            } else { //如果三个元素均不相同，则相互抵消1次
                vote1--;
                vote2--;
            }
        }
        int ct1 = 0, ct2 = 0;
        for (int x : nums) {
            if (vote1 > 0 && x == e1) ct1++;
            if (vote2 > 0 && x == e2) ct2++;
        }
        List<Integer> res = new ArrayList<>(); // 检测元素出现的次数是否满足要求
        if (vote1 > 0 && ct1 > nums.length / 3) res.add(e1);
        if (vote2 > 0 && ct2 > nums.length / 3) res.add(e2);
        return res;
    }

    public static void main(String[] args) {
        Lc229_2 lc229 = new Lc229_2();
        int[] nums = {3, 2, 3};
        List<Integer> res = lc229.majorityElement(nums);
        System.out.println("res = " + res);
    }
}
