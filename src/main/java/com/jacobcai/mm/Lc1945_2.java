package com.jacobcai.mm;

public class Lc1945_2 {
    public int getLucky(String s,
                        int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
        String digits = sb.toString();
        for (int i = 0; i < k && digits.length() > 1; i++) {
            int sum = 0;
            for (int j = 0; j < digits.length(); j++) {
                sum += digits.charAt(j) - '0';
            }
            digits = Integer.toString(sum);
        }
        return Integer.parseInt(digits);
    }
    
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        Lc1945_2 lc1945_2 = new Lc1945_2();
        int res = lc1945_2.getLucky(s,
                                  k);
        System.out.println("res = " + res);
    }
}
