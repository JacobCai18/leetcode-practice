package com.jacobcai.dc;

public class Lc541 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k)
            reverse(arr, i, Math.min(i + k, n) - 1);
        return new String(arr);
    }

    public void reverse(char[] arr, int le, int ri) {
        while (le < ri) {
            char tmp = arr[le];
            arr[le++] = arr[ri];
            arr[ri--] = tmp;
        }
    }

    public static void main(String[] args) {
        Lc541 lc541 = new Lc541();
        String s = "abcdefg";
        String res = lc541.reverseStr(s, 2);
        System.out.println("res = " + res);
    }
}
