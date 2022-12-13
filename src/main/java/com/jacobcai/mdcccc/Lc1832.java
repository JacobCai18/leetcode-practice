package com.jacobcai.mdcccc;

public class Lc1832 {
    public boolean checkIfPangram(String sentence) {
        boolean[] exist = new boolean[26];
        int cnt = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int j = sentence.charAt(i) - 'a';
            if (!exist[j]) {
                exist[j] = true;
                cnt++;
            }
        }
        return cnt == 26;
    }
    
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        Lc1832 lc1832 = new Lc1832();
        boolean res = lc1832.checkIfPangram(sentence);
        System.out.println("res = " + res);
    }
}
