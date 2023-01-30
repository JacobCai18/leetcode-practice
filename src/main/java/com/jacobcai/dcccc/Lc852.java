package com.jacobcai.dcccc;

public class Lc852 {
    public int peakIndexInMountainArray(int[] arr) {
        int le = 1, ri = arr.length - 1;
        while (le < ri) { // [le, mid - 1], [mid, ri]
            int mid = (le + ri + 1) >> 1;
            if (arr[mid - 1] < arr[mid])
                le = mid;
            else
                ri = mid - 1;
        }
        return le;
    }

    public static void main(String[] args) {
        Lc852 lc852 = new Lc852();
        int[] arr = {0, 10, 5, 2};
        int res = lc852.peakIndexInMountainArray(arr);
        System.out.println("res = " + res);
    }
}
