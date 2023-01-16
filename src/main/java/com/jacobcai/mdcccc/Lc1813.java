package com.jacobcai.mdcccc;

public class Lc1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0, n1 = words1.length, n2 = words2.length;
        while (i < n1 && i < n2 && words1[i].equals(words2[i]))
            i++;
        while (j < n1 - i && j < n2 - i && words1[n1 - j - 1].equals(words2[n2 - j - 1]))
            j++;
        return i + j == Math.min(n1, n2);
    }

    public static void main(String[] args) {
        Lc1813 lc1813 = new Lc1813();
        String sentence1 = "My name is Haley", sentence2 = "My Haley";
        boolean res = lc1813.areSentencesSimilar(sentence1, sentence2);
        System.out.println("res = " + res);
    }
}
