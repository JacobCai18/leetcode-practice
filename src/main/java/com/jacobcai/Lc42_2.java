package com.jacobcai;

public class Lc42_2 {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int[] leMax, riMax;
        int res;
        leMax = new int[len];
        leMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leMax[i] = Math.max(leMax[i - 1],
                                height[i]);
        }
        riMax = new int[len];
        riMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            riMax[i] = Math.max(riMax[i + 1],
                                height[i]);
        }
        res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.min(leMax[i],
                            riMax[i]) - height[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 3, 2, 1, 1, 0, 2, 3, 2, 1};
        Lc42_2 lc42_2 = new Lc42_2();
        int res = lc42_2.trap(height);
        System.out.println("res = " + res);
    }
}
