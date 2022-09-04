package com.jacobcai.c;

public class Lc42_3 {
    public int trap(int[] height) {
        int res, le, ri, leMax, riMax;
        res = 0;
        le = 0;
        ri = height.length - 1;
        leMax = riMax = 0;
        while (le < ri) {
            leMax = Math.max(leMax,
                             height[le]);
            riMax = Math.max(riMax,
                             height[ri]);
            // 对于le，leMax是精确的，对于ri，riMax是精确的
            if (leMax < riMax) {
                // 此时leMax < riMax <= leRiMax
                res += leMax - height[le++];
            } else {
                res += riMax - height[ri--];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 3, 2, 1, 1, 0, 2, 3, 2, 1};
        Lc42_3 lc42_3 = new Lc42_3();
        int res = lc42_3.trap(height);
        System.out.println("res = " + res);
    }
}
