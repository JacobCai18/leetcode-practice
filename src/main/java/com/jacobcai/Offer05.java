package com.jacobcai;

public class Offer05 {
    public static void main(String[] args) {
        Offer05 repS = new Offer05();
        System.out.println(repS.replaceSpace("We are happy."));
    }
    
    public String replaceSpace(String s) {
        int len = s.length();
        String replace = "%20";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                sb.append(replace);
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}


