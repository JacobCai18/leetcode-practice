package com.jacobcai;

public class Lc58 {
    public int lengthOfLastWord(String s) {
        int count, i;
        count = 0;
        i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        String s = "Hello World ";
        Lc58 lc58 = new Lc58();
        int res = lc58.lengthOfLastWord(s);
        System.out.println("res = " + res);
    }
}
