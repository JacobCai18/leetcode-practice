package com.jacobcai.mc;

public class Lc1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = sb.length() - 1;
            if (!sb.isEmpty() && sb.charAt(i) == c) {
                sb.deleteCharAt(i);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "abbaca";
        Lc1047 lc1047 = new Lc1047();
        String res = lc1047.removeDuplicates(s);
        System.out.println("res = " + res);
    }
}
