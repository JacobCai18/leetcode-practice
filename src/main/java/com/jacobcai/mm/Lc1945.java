package com.jacobcai.mm;

public class Lc1945 {
    public int getLucky(String s,
                        int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += sb.charAt(i) - '0';
        }
        for (int i = 0; i < k - 1; i++) {
            int curr = 0;
            while (sum != 0) {
                curr += sum % 10;
                sum /= 10;
            }
            sum = curr;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        Lc1945 lc1945 = new Lc1945();
        int res = lc1945.getLucky(s,
                                  k);
        System.out.println("res = " + res);
    }
}
