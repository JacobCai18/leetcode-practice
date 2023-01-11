package com.jacobcai.cc;

public class Lc135_2 {
    public int candy(int[] ratings) {
        int n = ratings.length, cnt, ri;
        int[] le = new int[n];
        le[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i])
                le[i] = le[i - 1] + 1;
            else
                le[i] = 1;
        }
        ri = 1;
        cnt = Math.max(le[n - 1], ri);
        for (int i = n - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1])
                ri++;
            else
                ri = 1;
            cnt += Math.max(le[i], ri);
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] ratings = {1, 3, 2, 2, 1};
        Lc135_2 lc135 = new Lc135_2();
        int res = lc135.candy(ratings);
        System.out.println("res = " + res);
    }
}
