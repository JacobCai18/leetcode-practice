package com.jacobcai.cd;

public class Lc345 {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) i++;
            while (j > 0 && !isVowel(arr[j])) j--;
            if (i < j) swap(arr, i++, j--);
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Lc345 lc345 = new Lc345();
        String s = "hello";
        String res = lc345.reverseVowels(s);
        System.out.println("res = " + res);
    }
}
