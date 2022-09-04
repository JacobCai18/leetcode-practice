package com.jacobcai.c;

public class Lc67_2 {
    public String addBinary(String a,
                            String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ?
                   a.charAt(i) - '0' :
                   0;
            sum += j >= 0 ?
                   b.charAt(j) - '0' :
                   0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        sb.append(carry == 1 ?
                  1 :
                  "");
        return sb.reverse()
                 .toString();
    }
    
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        Lc67_2 lc67_2 = new Lc67_2();
        String res = lc67_2.addBinary(a,
                                      b);
        System.out.println("res = " + res);
    }
}
