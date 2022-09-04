package com.jacobcai.c;

public class Lc11 {
    public int maxArea(int[] height) {
        // 最大水量
        int res = 0;
        int le = 0;
        int ri = height.length - 1;
        while (le < ri) {
            if (height[le] < height[ri]) {
                res = Math.max(res,
                               height[le] * (ri - le));
                le++;
            } else {
                res = Math.max(res,
                               height[ri] * (ri - le));
                ri--;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Lc11 lc11 = new Lc11();
        int res = lc11.maxArea(height);
        System.out.println("res = " + res);
    }
}
