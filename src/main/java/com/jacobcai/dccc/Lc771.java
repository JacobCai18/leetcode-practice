package com.jacobcai.dccc;

public class Lc771 {
    public int numJewelsInStones(String jewels,
                                 String stones) {
        boolean[] set = new boolean[58];
        for (char c : jewels.toCharArray())
            set[c - 'A'] = true;
        int cnt = 0;
        for (char c : stones.toCharArray())
            if (set[c - 'A'])
                cnt++;
        return cnt;
    }
    
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        Lc771 lc771 = new Lc771();
        int res = lc771.numJewelsInStones(jewels,
                                          stones);
        System.out.println("res = " + res);
    }
}
