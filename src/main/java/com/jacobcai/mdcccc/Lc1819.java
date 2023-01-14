package com.jacobcai.mdcccc;

import java.util.Arrays;

public class Lc1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        boolean[] occurred = new boolean[maxVal + 1];
        int cnt = 0;
        for (int num : nums) {
            if (!occurred[num]) {
                occurred[num] = true;
                cnt++;
            }
        }
        for (int i = 1; i <= maxVal / 3; i++) { // 想使 gcd 为 i，最少要 2i 和 3i 这两个数
            if (occurred[i]) continue;
            int g = 0;
            for (int j = i * 2; j <= maxVal && g != i; j += i) { // 对所有是 i 的倍数的元素求 gcd
                if (occurred[j]) {
                    g = gcd(g, j);
                    if (g == i) { // 只要能找到两个元素的 gcd 为 i，则可忽略后续元素
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        Lc1819 lc1819 = new Lc1819();
        int[] nums = {6, 10, 3};
        int res = lc1819.countDifferentSubsequenceGCDs(nums);
        System.out.println("res = " + res);
    }
}
