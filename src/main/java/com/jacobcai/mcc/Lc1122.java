package com.jacobcai.mcc;

import java.util.Arrays;

public class Lc1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length], cnt = new int[1001];
        int i = 0;
        for (var e : arr1) cnt[e]++;
        for (var e : arr2) while (cnt[e]-- > 0) res[i++] = e;
        for (int e = 0; e < 1001; e++) while (cnt[e]-- > 0) res[i++] = e;
        return res;
    }

    public static void main(String[] args) {
        Lc1122 lc1122 = new Lc1122();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = lc1122.relativeSortArray(arr1, arr2);
        System.out.println("res = " + Arrays.toString(res));
    }
}
