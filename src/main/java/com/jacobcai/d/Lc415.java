package com.jacobcai.d;

public class Lc415 {
    public String addStrings(String num1,
                             String num2) {
        int i, j, c;
        i = num1.length() - 1;
        j = num2.length() - 1;
        c = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || c != 0) {
            int x = i >= 0 ?
                    num1.charAt(i--) - '0' :
                    0;
            int y = j >= 0 ?
                    num2.charAt(j--) - '0' :
                    0;
            int sum = x + y + c;
            sb.append(sum % 10);
            c = sum / 10;
        }
        return sb.reverse()
                 .toString();
    }
    
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        Lc415 lc415 = new Lc415();
        String res = lc415.addStrings(num1,
                                      num2);
        System.out.println("res = " + res);
    }
}
