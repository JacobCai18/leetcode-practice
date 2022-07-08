package com.jacobcai;

public class Lc11 {
    public int maxArea(int[] height) {
        // 最大水量
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // 当前水量
            int curr;
            if (height[left] < height[right]) {
                curr = height[left] * (right - left);
                res = Math.max(res, curr);
                left++;
            } else {
                curr = height[right] * (right - left);
                res = Math.max(res, curr);
                right--;
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
