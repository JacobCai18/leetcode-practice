package com.jacobcai.c;

import java.util.Arrays;

public class Offer40 {
    public int[] getLeastNumbers(int[] arr,
                                 int k) {
        if (k == arr.length) {
            return arr;
        }
        return partition(arr,
                         k,
                         0,
                         arr.length - 1);
    }
    
    private int[] partition(int[] arr,
                            int k,
                            int le,
                            int ri) {
        int i = le, j = ri;
        while (i < j) {
            while (i < j && arr[j] >= arr[le]) {
                j--;
            }
            while (i < j && arr[i] <= arr[le]) {
                i++;
            }
            swap(arr,
                 i,
                 j);
        }
        swap(arr,
             le,
             i);
        if (i > k) {
            return partition(arr,
                             k,
                             le,
                             i - 1);
        }
        if (i < k) {
            return partition(arr,
                             k,
                             i + 1,
                             ri);
        }
        return Arrays.copyOf(arr,
                             k);
    }
    
    private void swap(int[] arr,
                      int i,
                      int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String[] args) {
        Offer40 minK1 = new Offer40();
        int[] arr1 = {9, 8, 7, 6, 5, 4};
        int[] arr2 = minK1.getLeastNumbers(arr1,
                                           2);
        Arrays.stream(arr2)
              .forEach(System.out::println);
    }
}