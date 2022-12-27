package com.jacobcai.cc;

public class Lc151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        for (; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i - 1) != ' ') {
                sb.append(' ');
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.reverse();
        for (int j = 0; j < sb.length(); j++) {
            int k = j;
            while (k < sb.length() && sb.charAt(k) != ' ') {
                k++;
            }
            reverse(sb,
                    j,
                    k - 1);
            j = k;
        }
        return sb.toString();
    }
    
    private void reverse(StringBuilder sb,
                         int j,
                         int k) {
        while (j < k) {
            char tmp = sb.charAt(j);
            sb.setCharAt(j++,
                         sb.charAt(k));
            sb.setCharAt(k--,
                         tmp);
        }
    }
    
    public static void main(String[] args) {
        String s = "  hello  world  ";
        Lc151 lc151 = new Lc151();
        String res = lc151.reverseWords(s);
        System.out.println("res = " + res);
    }
}
