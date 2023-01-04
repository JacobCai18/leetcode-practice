package com.jacobcai.dccc;

import java.util.ArrayList;
import java.util.List;

public class Lc763 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end,
                           last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
    
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Lc763 lc763 = new Lc763();
        List<Integer> res = lc763.partitionLabels(s);
        System.out.println("res = " + res);
    }
}
