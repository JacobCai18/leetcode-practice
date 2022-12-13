package com.jacobcai.mdcccc;

public class Lc1832_2 {
    public boolean checkIfPangram(String sentence) {
        int exist = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int j = sentence.charAt(i) - 'a';
            exist |= 1 << j;
        }
        return exist == (1 << 26) - 1;
    }
    
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        Lc1832_2 lc1832_2 = new Lc1832_2();
        boolean res = lc1832_2.checkIfPangram(sentence);
        System.out.println("res = " + res);
    }
}
